package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RecommendationsRepository;
import com.example.demo.model.Recommendation;

import java.util.List;

import org.springframework.data.domain.Page;


@Service
public class RecommendationsService {

    @Autowired
	private RecommendationsRepository repo;


	public List<Recommendation> getAll() {
		return repo.findAll();
	}

	public List<Recommendation> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Recommendation> recommendations = repo.findAll(pageReq);
		return recommendations.getContent();
	}

	public void save(Recommendation recommendation) {
		repo.save(recommendation);
	}

	public Recommendation getByIdUser(Integer idRecommendation) {
		return repo.findById(idRecommendation).get();
	}

	public void delete(Integer idRecommendation) {
		repo.deleteById(idRecommendation);
	}
	
}


