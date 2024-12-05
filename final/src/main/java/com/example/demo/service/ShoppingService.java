package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ShoppingRepository;
import com.example.demo.model.Shopping;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShoppingService {

	@Autowired
    private ShoppingRepository reposito;

	public List<Shopping> getAllList() {
		return reposito.findAll();
	}

	public List<Shopping> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Shopping> shopping = reposito.findAll(pageReq);
		return shopping.getContent();
	} 

	public void save(Shopping shopping) {
		reposito.save(shopping);
	}

	public Shopping getByIdShopping(Integer idShopping) {
		return reposito.findById(idShopping).get();
	}

	public void delete(Integer idShopping) {
		reposito.deleteById(idShopping);
	}
}