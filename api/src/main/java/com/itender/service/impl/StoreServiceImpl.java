package com.itender.service.impl;

import static com.itender.utils.Constants.PRODUCT_WITH_CATEGORY_ID_NOT_FOUND;
import static com.itender.utils.Constants.STORE_NOT_FOUND;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itender.api.request.StoreRequest;
import com.itender.api.response.CategoryMenuResponse;
import com.itender.api.response.GetStoreResponse;
import com.itender.api.response.MenuResponse;
import com.itender.api.response.ProductMenuResponse;
import com.itender.exception.FileException;
import com.itender.exception.ProductCategoryException;
import com.itender.exception.ProductException;
import com.itender.exception.StoreException;
import com.itender.model.Product;
import com.itender.model.ProductCategory;
import com.itender.model.Store;
import com.itender.repository.ProductCategoryRepository;
import com.itender.repository.ProductRepository;
import com.itender.repository.StoreRepository;
import com.itender.service.FileManager;
import com.itender.service.StoreService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;
    private final FileManager fileManager;
    private final ModelMapper mapper;
    private final Clock clock;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository,
                            ProductCategoryRepository productCategoryRepository,
                            ProductRepository productRepository,
                            FileManager fileManager,
                            ModelMapper mapper,
                            Clock clock) {
        this.storeRepository = storeRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
        this.fileManager = fileManager;
        this.mapper = mapper;
        this.clock = clock;
    }

    @Override
    public UUID createStore(StoreRequest request) throws FileException, StoreException {
        if (!storeRepository.findByName(request.getName()).isPresent()) {
            String fileId = fileManager.uploadFile(request.getLogoImage());

            Store store = mapper.map(request, Store.class);
            store.setLogoImageId(fileId);
            store.setCreatedAt(LocalDateTime.now(clock));
            store.setId(null);
            log.info("Creating store {}", store.getName());

            storeRepository.save(store);

            return store.getId();
        } else {
            throw new StoreException("Store with name " + request.getName() + " already exists.",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void updateStore(UUID id, StoreRequest request) throws FileException, StoreException {
        Optional<Store> optionalStore = storeRepository.findById(id);

        if (optionalStore.isPresent()) {
            String fileId = fileManager.uploadFile(request.getLogoImage());

            mapper.map(request, optionalStore.get());
            optionalStore.get().setLogoImageId(fileId);
            log.info("Updating store {}", optionalStore.get().getName());

            storeRepository.save(optionalStore.get());
        } else {
            throw new StoreException("Store with id " + id + " not exists.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteStore(UUID id) throws StoreException {
        Optional<Store> optionalStore = storeRepository.findById(id);

        if (optionalStore.isPresent()) {
            log.info("Deleting store {}", optionalStore.get().getName());

            storeRepository.deleteById(id);
        } else {
            throw new StoreException("Store with id " + id + " not exists.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<GetStoreResponse> getAllStores()
            throws StoreException, FileException, GeneralSecurityException, IOException {
        List<Store> stores = storeRepository.findAll();

        if (!stores.isEmpty()) {
            List<GetStoreResponse> getStoreResponses = new ArrayList<>();
            for (Store store : stores) {
                GetStoreResponse getStoreResponse = mapper.map(store, GetStoreResponse.class);
                getStoreResponse.setLogoUrl(fileManager.getUrl(store.getLogoImageId()));
                getStoreResponses.add(getStoreResponse);
            }

            return getStoreResponses;
        } else {
            throw new StoreException("Any store was found.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public MenuResponse getMenuFromStore(UUID id)
            throws StoreException, ProductCategoryException, GeneralSecurityException, IOException {
        Optional<Store> optionalStore = storeRepository.findById(id);

        if (optionalStore.isPresent()) {
            List<CategoryMenuResponse> categoryMenuResponses = new ArrayList<>();
            List<ProductCategory> productCategoryList = productCategoryRepository.getProductCategoriesByStoreId(id);

            if (!productCategoryList.isEmpty()) {
                productCategoryList.forEach(productCategory -> {
                    List<ProductMenuResponse> productMenuList = getProductsByCategory(productCategory.getId());
                    categoryMenuResponses.add(CategoryMenuResponse.builder()
                            .categoryName(productCategory.getCategoryName())
                            .id(productCategory.getId())
                            .productList(productMenuList)
                            .build());
                });

                return MenuResponse.builder()
                        .id(optionalStore.get().getId())
                        .name(optionalStore.get().getName())
                        .description(optionalStore.get().getDescription())
                        .logoUrl(fileManager.getUrl(optionalStore.get().getLogoImageId()))
                        .categoryList(categoryMenuResponses)
                        .build();
            } else {
                log.info("No category product found for this store {}", optionalStore.get().getName());
                return MenuResponse.builder()
                        .id(optionalStore.get().getId())
                        .name(optionalStore.get().getName())
                        .description(optionalStore.get().getDescription())
                        .logoUrl(fileManager.getUrl(optionalStore.get().getLogoImageId()))
                        .build();
            }
        } else {
            throw new StoreException(String.format(STORE_NOT_FOUND, id), HttpStatus.NOT_FOUND);
        }
    }

    private List<ProductMenuResponse> getProductsByCategory(UUID id) throws ProductException {
        List<Product> productList = productRepository.findProductsByProductCategoryId(id);

        if (!productList.isEmpty()) {
            return productList.stream().map(product -> {
                try {
                    return ProductMenuResponse.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .price(product.getPrice())
                            .description(product.getDescription())
                            .imageUrl(fileManager.getUrl(product.getImageId()))
                            .build();
                } catch (GeneralSecurityException | IOException | FileException e) {
                    throw new FileException(e.getMessage(), e);
                }
            }).collect(Collectors.toList());
        } else {
            throw new ProductException(String.format(PRODUCT_WITH_CATEGORY_ID_NOT_FOUND, id),
                    HttpStatus.NOT_FOUND);
        }

    }

}