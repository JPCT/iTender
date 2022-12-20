package com.itender.service.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.itender.api.request.ProductRequest;
import com.itender.api.response.ProductResponse;
import com.itender.exception.FileException;
import com.itender.exception.ProductException;
import com.itender.model.Product;
import com.itender.repository.ProductRepository;
import com.itender.service.FileManager;
import com.itender.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final FileManager fileManager;
    private final ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, FileManager fileManager, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.fileManager = fileManager;
        this.mapper = mapper;
    }

    @Override
    public UUID createProduct(ProductRequest request) throws FileException, ProductException {
        if (!productRepository.findByName(request.getName()).isPresent()) {
            String fileId = fileManager.uploadFile(request.getImage());

            Product product = mapper.map(request, Product.class);
            product.setImageId(fileId);
            product.setId(null);
            log.info("Creating product {}", product.getName());

            productRepository.save(product);

            return product.getId();
        } else {
            throw new ProductException("Product with name " + request.getName() + " already exists.",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ProductResponse getProduct(UUID id)
            throws FileException, GeneralSecurityException, IOException, ProductException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductResponse productResponse = mapper.map(optionalProduct.get(), ProductResponse.class);

            productResponse.setImageUrl(fileManager.getUrl(optionalProduct.get().getImageId()));
            productResponse.getStore()
                    .setLogoUrl(fileManager.getUrl(optionalProduct.get().getStore().getLogoImageId()));
            log.info("Retrieving product {}", optionalProduct.get().getName());

            return productResponse;
        } else {
            throw new ProductException(String.format("Product with id %s not exists", id), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteProduct(UUID productId) throws ProductException {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            log.info("Deleting product {}", optionalProduct.get().getName());

            productRepository.deleteById(productId);
        } else {
            throw new ProductException("Product with id " + productId + " not exists.", HttpStatus.NOT_FOUND);
        }
    }

}
