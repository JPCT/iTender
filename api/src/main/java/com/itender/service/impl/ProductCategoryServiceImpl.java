package com.itender.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itender.api.request.ProductCategoryRequest;
import com.itender.api.response.ProductCategoryResponse;
import com.itender.exception.ProductCategoryException;
import com.itender.model.ProductCategory;
import com.itender.repository.ProductCategoryRepository;
import com.itender.service.ProductCategoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ModelMapper mapper;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository,
                                      ModelMapper mapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.mapper = mapper;
    }

    @Override
    public UUID createProductCategory(ProductCategoryRequest request) {
        ProductCategory productCategory = mapper.map(request, ProductCategory.class);
        log.info("Creating product category {}", productCategory.getCategoryName());

        productCategoryRepository.save(productCategory);

        return productCategory.getId();

    }

    @Override
    public void updateProductCategory(UUID id, ProductCategoryRequest request) throws ProductCategoryException {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(id);

        if (optionalProductCategory.isPresent()) {
            mapper.map(request, optionalProductCategory.get());
            log.info("Updating product category {}", optionalProductCategory.get().getCategoryName());
            optionalProductCategory.get().setId(id);

            productCategoryRepository.save(optionalProductCategory.get());
        } else {
            throw new ProductCategoryException("Product category with id " + id + " not exists.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProductCategory(UUID id) throws ProductCategoryException {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(id);

        if (optionalProductCategory.isPresent()) {
            log.info("Deleting product category {}", optionalProductCategory.get().getCategoryName());

            productCategoryRepository.deleteById(id);
        } else {
            throw new ProductCategoryException("Product category with id " + id + " not exists.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<ProductCategoryResponse> getProductCategoriesByStore(UUID storeId) throws ProductCategoryException {
        List<ProductCategory> productCategories = productCategoryRepository.getProductCategoriesByStoreId(storeId);

        if (!productCategories.isEmpty()) {
            List<ProductCategoryResponse> productCategoryResponses = new ArrayList<>();
            for (ProductCategory productCategory : productCategories) {
                ProductCategoryResponse productCategoryResponse = mapper.map(productCategory,
                        ProductCategoryResponse.class);
                productCategoryResponses.add(productCategoryResponse);
            }

            return productCategoryResponses;
        } else {
            throw new ProductCategoryException("Any product category was not found with store id " + storeId + " .",
                    HttpStatus.NOT_FOUND);
        }
    }

}
