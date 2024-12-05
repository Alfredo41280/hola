package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shopping;
import com.example.demo.service.ShoppingService;

import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@RestController
@RequestMapping("shopping")
@CrossOrigin (origins= "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@Tag(name = "Shopping", description = "Provides methods for managing shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService service;

  //@ApiResponse(responseCode = "200", description = "Found recharge", content = {
  //@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Shopping.class))) })
	//@GetMapping
	//public List<Shopping> getAllList() {
		//return service.getAllList();
	//}

    @Operation(summary="Get shopping with pagination")
    @GetMapping(value = "pagination", params = {"page", "size"})
    public List<Shopping> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false)int
    page,    

    @RequestParam(value = "size", defaultValue = "10", required = false)int size){
        List<Shopping> shopping = service.getAll(page,size);
        return shopping;
    }

    @Operation(summary="Get shopping by id")
    @GetMapping("{idShopping}")
    public ResponseEntity<?> getById(@PathVariable Integer idShopping) {
        Shopping shopping = service.getByIdShopping(idShopping);
        return new ResponseEntity<Shopping>(shopping, HttpStatus.OK);
    }
   
    //@Operation(summary="Create shpping")
    //@PostMapping
    //public ResponseEntity<?> createShopping(@RequestBody Shopping shopping) {
      //  service.save(shopping);
       // return new ResponseEntity<String>("Saved record", HttpStatus.OK);
    //}
    //@Operation(summary="Update recharge by id")
    //@PutMapping("{idShopping}")
    //public ResponseEntity<?> update(@RequestBody Shopping shopping, @PathVariable Integer idShopping) {
      //  Shopping auxShopping = service.getByIdShopping(idShopping);
      //  shopping.setIdShopping(auxShopping.getIdShopping());
      //  service.save(shopping);
      //  return new ResponseEntity<String>("Updated record", HttpStatus.OK);
    //}
    //@Operation(summary="Delete shopping by idShopping")
    //@DeleteMapping("{idShopping}")
    //public ResponseEntity<?> delete(@RequestBody Shopping shopping, @PathVariable Integer idShopping) {
      //  service.delete(idShopping);
      //  return new ResponseEntity<String>("Deleted record", HttpStatus.OK);
    //}


}



