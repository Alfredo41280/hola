package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductsService;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;



import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@RestController
@RequestMapping("products")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@Tag(name = "Products", description = "Provides methods for managing products")
public class ProductsController {
    @Autowired
	private ProductsService service;

	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class))) })
	//@GetMapping
	//public List<Product> getAll() {
	//	return service.getAll();
	//}

    @Operation(summary="Get products with pagination")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<Product> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<Product> products = service.getAll(page,pageSize);
        return products;
    }

	//@Tag(name = "Get user by Id", description="Get info user with Id or confirm his existence")
	@Operation(summary="Get information product by Id")
	@GetMapping("{idProduct}")
	public ResponseEntity<Product> getByControlNumber(@PathVariable Integer idProduct) {
		Product product = service.getByIdUser(idProduct);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	//@Tag(name = "Create a user", description="create user with data: name, dateOfBirth, address")
	//@Operation(summary="Create a product")
	//@PostMapping
	//public void registrar(@RequestBody Product product) {
	//	service.save(product);
	//}

	//@Tag(name = "Update user with Id", description="Update info user data: name, dateOfBirth, address")
	//@Operation(summary="Update information user")
	//@PutMapping("{idProduct}")
	//public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer idProduct) {
	//	try {
	//		Product auxProduct = service.getByIdUser(idProduct);
	//			product.setIdProduct(auxProduct.getIdProduct());
	//		service.save(product);
	//		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	//	}catch (NoSuchElementException e) {
	  //      return new ResponseEntity<String>("The record with the idUser provided is not found in the database", HttpStatus.NOT_FOUND);
	    //}
	//}

	//@Tag(name = "Delete user with Id", description="Delete user from database")
	//@Operation(summary="Delete user from database")
	//@DeleteMapping("{idProduct}")
	//public void delete(@PathVariable Integer idProduct) {
	//	service.delete(idProduct);
	//}
}

