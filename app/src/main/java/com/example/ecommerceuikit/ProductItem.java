package com.example.ecommerceuikit;

public class ProductItem {
    private int id;
    private String title;
    private String color;
    private String size;
    private int image;
    private float price;

    public ProductItem(int id, String title, String color, String size, int image, float price) {
        this.title = title;
        this.color = color;
        this.size = size;
        this.id = id;
        this.image = image;
        this.price = price;
    }

    public ProductItem(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
