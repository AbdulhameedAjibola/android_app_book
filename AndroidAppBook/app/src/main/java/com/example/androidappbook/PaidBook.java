package com.example.androidappbook;

public class PaidBook {
    private String title;
    private String author;
    private int coverResourceId;
    private String webUrl;
    private String price;


    public PaidBook(String title, String author, int coverResourceId, String webUrl, String price) {
        this.title = title;
        this.author = author;
        this.coverResourceId = coverResourceId;
        this.webUrl = webUrl;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCoverResourceId() {
        return coverResourceId;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getPrice() {
        return price;
    }
}
