package com.example.sawankumarsingh.newsapp;

public class News {

    private String newsImage;

    private String newsHeadline;

    private String newsTime;

    private String newsUrl;

    public News(String NewsImage, String NewsHeadline, String NewsTime, String NewsUrl) {
        newsImage = NewsImage;
        newsHeadline = NewsHeadline;
        newsTime = NewsTime;
        newsUrl = NewsUrl;

    }

    public String getNewsImage() {
        return newsImage;
    }

    public String getNewsHeadline() {
        return newsHeadline;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public String getNewsUrl() {
        return newsUrl;
    }
}
