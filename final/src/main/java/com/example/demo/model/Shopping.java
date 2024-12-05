package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.validation.constraints.Size;

@Entity
public class Shopping {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idShopping")
    @JsonProperty("idShopping")
    private Integer idShopping;
    
    
    //@Size(min=1, max =255, message="The name of contact must be at most 30 characters")
    @Column(name="platform")
    @JsonProperty("platform")
    private String platform;
    

    @JoinColumn (name="idCvv")
    @JsonProperty("idCvv")
    private Integer idCvv;

    public Integer getCVVcode(){
        return idCvv;
    }

    public void setCVVcode (Integer idCvv){
        this.idCvv = idCvv;
    }



    public Integer getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(Integer idShopping) {
        this.idShopping = idShopping;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}


