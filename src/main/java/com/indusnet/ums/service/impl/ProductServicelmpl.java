package com.indusnet.ums.service.impl;

import java.time.Instant;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.exception.CustomNotFoundException;
import com.indusnet.ums.exception.UnprocessableException;
import com.indusnet.ums.model.ProductModel;
import com.indusnet.ums.repository.IProductServiceRepository;
import com.indusnet.ums.service.IProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class ProductServicelmpl implements IProductService {
    @Autowired
	Gson gson = new Gson();

	@Autowired
	IProductServiceRepository repository;

    @Override
    public ResponseModel add(ProductModel model) {
        Long currentTimeInMilli = Instant.now().toEpochMilli();
        ProductModel saveModel = ProductModel.builder()
                .quantity(model.getQuantity())
                .description(model.getDescription())
                .build();

        repository.save(saveModel);

        //log.info(gson.toJson(saveModel));

        return ResponseModel.builder()
                .messageEn("Product Added Successfully")
                .messageFr("Product Added Successfully")
                .messageTypeId(1)
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public List<ProductModel> getProducts() {
        return repository.findAll();
    }

    @Override
    public ProductModel getProductById(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public void deleteProduct(String productId) {
        repository.deleteById(productId);
    }

    @Override
    public ResponseModel updateProduct(ProductModel user) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    // @Override
    // public ResponseModel updateProduct(ProductModel Product) {
    //     ProductModel existingProduct = repository.findById(Product.getId()).orElse(null);
    //     if (existingProduct != null) {
    //         existingProduct.setTitle(Product.getTitle());
    //         existingProduct.setDescription(Product.getDescription());
    //         existingProduct.setAssignedUser(Product.getAssignedUser());
    //         existingProduct.setDueDate(Product.getDueDate());
    //         existingProduct.setCompleted(Product.getCompleted());
    //         repository.save(existingProduct);

    //         return ResponseModel.builder()
    //                 .messageEn("Product Updated Successfully")
    //                 .messageFr("Product Updated Successfully")
    //                 .messageTypeId(1)
    //                 .statusCode(HttpStatus.OK)
    //                 .build();
    //     } else {
    //         return ResponseModel.builder()
    //                 .messageEn("Product Not Found")
    //                 .messageFr("Product Not Found")
    //                 .messageTypeId(2)
    //                 .statusCode(HttpStatus.NOT_FOUND)
    //                 .build();
    //     }
    // }
}
