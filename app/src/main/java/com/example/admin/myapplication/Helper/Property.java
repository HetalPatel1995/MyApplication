package com.example.admin.myapplication.Helper;

public class Property {

    int id;
     String name;
     int image;

    public Property(int id, String title, String shortdesc, String rating, String price, int image) {
        this.id = id;

        this.name = price;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
