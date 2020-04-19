package com.example.restservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doll {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String star;
    private Integer productionMinute;
    private String linkUrl;
    private String howToGet;
    private String imageUrl;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getStar() {
        return star;
    }
    public void setStar(String star) {
        this.star = star;
    }

    public Integer getProductionMinute() {
        return productionMinute;
    }
    public void setProductionMinute(Integer productionMinute) {
        this.productionMinute = productionMinute;
    }

    public String getLinkUrl() {
        return linkUrl;
    }
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getHowToGet() {
        return howToGet;
    }
    public void setHowToGet(String howToGet) {
        this.howToGet = howToGet;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
