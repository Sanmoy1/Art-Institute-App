package com.example.artinstituteapiapp;

import java.security.PrivateKey;

public class Artwork {



    private String title;
    private String artist;

    private String imageUrl;
    private String date;
    private String department;
    private String galleryTitle;
    private String galleryId;
    private String location;
    private String artworktype;
    private String medium_display;
    private String dimensions;
    private String creditLine;
    public Artwork(String title,String artist,String imageUrl, String date,String department,String galleryTitle, String galleryId, String location,String artworktype, String medium_display, String dimensions,String creditLine)
    {
        this.title=title;
        this.artist=artist;
        this.imageUrl=imageUrl;
        this.date=date;
        this.department=department;
        this.galleryTitle=galleryTitle;
        this.galleryId=galleryId;
        this.location=location;
        this.artworktype=artworktype;
        this.medium_display=medium_display;
        this.dimensions=dimensions;
        this.creditLine=creditLine;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Artwork{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGalleryTitle() {
        return galleryTitle;
    }

    public void setGalleryTitle(String galleryTitle) {
        this.galleryTitle = galleryTitle;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getartworkType() {
        return artworktype;
    }


    public void setartworkType(String artworktype) {
        this.artworktype = artworktype;
    }

    public String getMedium_display(){return medium_display;}

    public void setMedium_display(){this.medium_display=medium_display;}

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }




}
