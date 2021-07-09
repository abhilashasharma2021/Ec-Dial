package com.ecdial.model;

public class OfferModel {
    private String catName;
    private int image;

    public OfferModel(String catName, int image) {
        this.catName = catName;
        this.image = image;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
