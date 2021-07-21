package com.ecdial.model;

public class CategoryHome {
    private String catName;
    private int catImage;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatImage() {
        return catImage;
    }

    public void setCatImage(int catImage) {
        this.catImage = catImage;
    }

    public CategoryHome(String catName, int catImage) {
        this.catName = catName;
        this.catImage = catImage;
    }
}
