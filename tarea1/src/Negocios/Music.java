package Negocios;

import java.io.Serializable;

public class Music implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sku;
    private String title;
    private String year;
    private String artist;
    private String genre;
    private String type;

    public Music() {}

    public Music(String sku, String title, String year, String artist, String genre, String type) {
        this.sku = sku;
        this.title = title;
        this.year = year;
        this.artist = artist;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
                "\nGénero: " + this.genre +
                "\nTipo: " + this.type;
    }
}