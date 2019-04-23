package com.selenium;

public class Laptop {

    private String title;
    private double price;

    public Laptop(){}

    public Laptop(String title) {
        this.title = title;
    }

    public Laptop(String title, double price) {
        this.title = title;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nLaptop{" +
                "\ntitle='" + title + '\'' +
                ",\nprice=" + price +
                "\n}";
    }
}
