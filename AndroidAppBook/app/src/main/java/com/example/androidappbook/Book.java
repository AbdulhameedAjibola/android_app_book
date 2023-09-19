package com.example.androidappbook;

public class Book {
    private String title;
    private String author;
    private int coverResourceId;
    private String webUrl;

    public Book(String title, String author, int coverResourceId, String webUrl) {
        this.title = title;
        this.author = author;
        this.coverResourceId = coverResourceId;
        this.webUrl = webUrl;
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
}


