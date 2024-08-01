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
import com.indusnet.ums.model.CartModel;
import com.indusnet.ums.repository.ICartServiceRepository;
import com.indusnet.ums.service.ICartService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class CartServicelmpl implements ICartService {
    @Autowired
	Gson gson = new Gson();

	@Autowired
	ICartServiceRepository repository;

    @Override
    public ResponseModel add(CartModel model) {
        Long currentTimeInMilli = Instant.now().toEpochMilli();
        CartModel saveModel = CartModel.builder()
                .quantity(model.getQuantity())
                .description(model.getDescription())
                .build();

        repository.save(saveModel);

        //log.info(gson.toJson(saveModel));

        return ResponseModel.builder()
                .messageEn("Cart Added Successfully")
                .messageFr("Cart Added Successfully")
                .messageTypeId(1)
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public List<CartModel> getCarts() {
        return repository.findAll();
    }

    @Override
    public CartModel getCartById(String cartId) {
        return repository.findById(cartId).orElse(null);
    }

    @Override
    public void deleteCart(String cartId) {
        repository.deleteById(cartId);
    }

    @Override
    public ResponseModel updateCart(CartModel user) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateCart'");
    }

    // @Override
    // public ResponseModel updateCart(CartModel Cart) {
    //     CartModel existingCart = repository.findById(Cart.getId()).orElse(null);
    //     if (existingCart != null) {
    //         existingCart.setTitle(Cart.getTitle());
    //         existingCart.setDescription(Cart.getDescription());
    //         existingCart.setAssignedUser(Cart.getAssignedUser());
    //         existingCart.setDueDate(Cart.getDueDate());
    //         existingCart.setCompleted(Cart.getCompleted());
    //         repository.save(existingCart);

    //         return ResponseModel.builder()
    //                 .messageEn("Cart Updated Successfully")
    //                 .messageFr("Cart Updated Successfully")
    //                 .messageTypeId(1)
    //                 .statusCode(HttpStatus.OK)
    //                 .build();
    //     } else {
    //         return ResponseModel.builder()
    //                 .messageEn("Cart Not Found")
    //                 .messageFr("Cart Not Found")
    //                 .messageTypeId(2)
    //                 .statusCode(HttpStatus.NOT_FOUND)
    //                 .build();
    //     }
    // }
}
