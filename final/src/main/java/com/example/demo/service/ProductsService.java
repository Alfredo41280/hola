package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductsRepository;
import com.example.demo.model.Product;

import org.springframework.data.domain.Page;



@Service
public class ProductsService {

    @Autowired
	private ProductsRepository repo;


	public List<Product> getAll() {
		return repo.findAll();
	}

	public List<Product> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Product> products = repo.findAll(pageReq);
		return products.getContent();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product getByIdUser(Integer idProduct) {
		return repo.findById(idProduct).get();
	}

	public void delete(Integer idProduct) {
		repo.deleteById(idProduct);
	}
	
}

