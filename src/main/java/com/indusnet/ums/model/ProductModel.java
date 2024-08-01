package main.java.com.indusnet.ums.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "cart")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
	
	
	@Id
    private String id;

    private String name;

    private String description;

    



   
}


