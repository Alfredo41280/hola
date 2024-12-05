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


@Entity
@Table(name = "product" )

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    @JsonProperty("idProduct")
    private Integer idProduct;

   
    @Column(name = "category")
    @JsonProperty("category")
    private String category;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "idRecommendations", referencedColumnName = "idRecommendations")
    //@JsonProperty("idRecommendations")
    //private Recommendation recommendation;
   
    @Column(name = "name")
    @JsonProperty("name")
    private String name;

   
    @Column(name = "price")
    @JsonProperty("price")
    private float price;

   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idShopping")
    @JsonProperty("idShopping")
    @JsonBackReference
    private Shopping idShopping;

    public Shopping getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(Shopping idShopping) {
        this.idShopping = idShopping;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

  //  public Recommendation getRecommendationsModel() {
  //      return recommendation;
  //  }

  //  public void setRecommendationsModel(Recommendation recommendationsModel) {
  //      this.recommendation = recommendationsModel;
  // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
}
