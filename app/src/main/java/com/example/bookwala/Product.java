package com.example.bookwala;

public class Product {

    private int semester;
    private String subject;
    private String publication;
    private int year,price;
    private int image;

    public Product(int semester, String subject, String publication, int year, int price, int image) {
        this.semester = semester;
        this.subject = subject;
        this.publication = publication;
        this.year = year;
        this.price = price;
        this.image = image;
    }

    public int getSemester() {
        return semester;
    }

    public String getSubject() {
        return subject;
    }

    public String getPublication() {
        return publication;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}
