package com.indusnet.ums.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.CartModel;

import jakarta.validation.Valid;
public interface ICartService {

    ResponseModel add(@Valid CartModel model);

	List<CartModel> getCarts();

	CartModel getCartById(String userId);

	void deleteCart(String userId);

	ResponseModel updateCart(CartModel user);
}
