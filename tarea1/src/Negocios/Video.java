package Negocios;

import java.io.Serializable;

public class Video implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sku;
    private String title;
    private String year;
    private String artist;
    private String rating;
    private String type;

    public Video() {}

    public Video(String sku, String title, String year, String artist, String rating, String type) {
        this.sku = sku;
        this.title = title;
        this.year = year;
        this.artist = artist;
        this.rating = rating;
        this.type = type;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Información del disco\n" +
                "SKU: " + this.sku +
                "\nTítulo: " + this.title +
                "\nAño: " + this.year +
                "\nArtista: " + this.artist +
                "\nClasificación: " + this.rating +
                "\nTipo: " + this.type;
    }
}
