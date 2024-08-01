package main.java.com.indusnet.ums.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indusnet.ums.util.ObjectIdTypeAdapter;
import com.indusnet.ums.common.MessageTypeConst;
import com.indusnet.ums.common.LoggingResponseModel;
import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.ProductModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.indusnet.ums.service.IproductService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product/")
@Slf4j
public class ProductController {

    
    @Autowired
    Gson gson;

    @Autowired
    private IProductService productService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> addProduct(@RequestBody ProductModel productModel) {
        ResponseModel response = productService.add(productModel);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/:id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductModel> getProductById(@PathVariable String id) {
        ProductModel  product= productService.getProductById(id);
        if ( product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( product, HttpStatus.OK);
    }

    @PutMapping(value = "/:id/items", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> updateProduct(@PathVariable String id, @RequestBody ProductModel productModel) {
        productModel.setId(id);
        ResponseModel response = productService.updateProduct(productModel);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    
}
