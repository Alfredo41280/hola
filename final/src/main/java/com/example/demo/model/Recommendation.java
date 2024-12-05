package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Size;

@Entity
@Table(name = "recommendation" )

public class Recommendation {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecommendation")
    @JsonProperty("idRecommendation")    
    private Integer idRecommendation;

    
    //@Size(min = 1, max = 500, message = "The content must be at most 500 characters, and has at least one character")
    @Column(name = "category")
    @JsonProperty("category")    
    private String category;

    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idProduct")
    @JsonProperty("idProduct")
    @JsonBackReference
    private Product idProduct;

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }


    public Integer getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(Integer idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
}
