package com.indusnet.ums.repository;
import com.indusnet.ums.model.CartModel;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICartServiceRepository extends MongoRepository<CartModel, String> {
	 
	Optional<CartModel> findById(String Id);
    List<CartModel> findByName(Integer name);
    List<CartModel> findByDescription(String description);
}