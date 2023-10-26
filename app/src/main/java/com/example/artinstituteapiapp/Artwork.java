package com.example.artinstituteapiapp;

public class Artwork {



    private String title;
    private String artist;

    private String imageUrl;
    private String date;
    private String department;
    private String galleryTitle;
    private String galleryId;
    private String location;
    private String typeAndMedium;
    private String dimensions;
    private String creditLine;
    public Artwork(String title,String artist,String imageUrl)
    {
        this.title=title;
        this.artist=artist;
        this.imageUrl=imageUrl;
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

    public String getTypeAndMedium() {
        return typeAndMedium;
    }

    public void setTypeAndMedium(String typeAndMedium) {
        this.typeAndMedium = typeAndMedium;
    }

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
