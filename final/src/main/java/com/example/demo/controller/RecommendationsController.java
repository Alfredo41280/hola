package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationsService;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.validation.annotation.Validated;



import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Validated
@RestController
@RequestMapping("/recommendations")
@Tag(name = "Recomendations", description = "Provides methods for managing recomendation")
public class RecommendationsController {
    @Autowired
	private RecommendationsService service;

	//@Operation(summary="Get recommendations CU10------")
	//@ApiResponse(responseCode = "200", description = "Found recharge", content = {
    //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recommendation.class))) })
	//@GetMapping
	//public List<Recommendation> getAll() {
	//	return service.getAll();
	//}

    @Operation(summary="Get recommendations with pagination")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<Recommendation> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int pageSize){
        List<Recommendation> recommendation = service.getAll(page,pageSize);
        return recommendation;
    }

	//@Tag(name = "Get user by Id", description="Get info user with Id or confirm his existence")
	@Operation(summary="Get information recommendation by Id")
	@GetMapping("{idRecommendation}")
	public ResponseEntity<Recommendation> getByControlNumber(@PathVariable Integer idRecommendation) {
		Recommendation recommendation = service.getByIdUser(idRecommendation);
		return new ResponseEntity<Recommendation>(recommendation, HttpStatus.OK);
	}

	//@Tag(name = "Create a user", description="create user with data: name, dateOfBirth, address")
	//@Operation(summary="Create a recommendation")
	//@PostMapping
	//public void registrar(@RequestBody Recommendation recommendation) {
	//	service.save(recommendation);
	//}

	//@Tag(name = "Update user with Id", description="Update info user data: name, dateOfBirth, address")
	//@Operation(summary="Update information user")
	//@PutMapping("{idRecommendation}")
	//public ResponseEntity<?> update(@RequestBody Recommendation recommendation, @PathVariable Integer idRecommendation) {
	//	try {
	//		Recommendation auxRecommendation = service.getByIdUser(idRecommendation);
	//		recommendation.setIdRecommendation(auxRecommendation.getIdRecommendation());
	//		service.save(recommendation);
	//		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	//	}catch (NoSuchElementException e) {
	  //      return new ResponseEntity<String>("The record with the idUser provided is not found in the database", HttpStatus.NOT_FOUND);
	    //}
	//}

	//@Tag(name = "Delete user with Id", description="Delete user from database")
	//@Operation(summary="Delete user from database")
	//@DeleteMapping("{idRecommendation}")
	//public void delete(@PathVariable Integer idRecommendation) {
	//	service.delete(idRecommendation);
	//}
}

