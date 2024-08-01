package main.java.com.indusnet.ums.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.ProductModel;

import jakarta.validation.Valid;
public interface IProductService {

    ResponseModel add(@Valid ProductModel model);

	List<ProductModel> getProducts();

	ProductModel getProductById(String userId);

	void deleteProduct(String userId);

	ResponseModel updateProduct(ProductModel user);
}
