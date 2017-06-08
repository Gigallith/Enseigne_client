package fr.unice.polytech.enseigne_client.data;

import java.util.List;

/**
 * Created by user on 10/05/2017.
 */

public class Shop {

    private String ville;
    private double latitude;
    private double longitude;
    private List<Article> articles;
    private List<Article> sales;

    public Shop(String ville,double latitude, double longitude, List<Article> articles, List<Article> sales) {
        this.ville=ville;
        this.latitude=latitude;
        this.longitude = longitude;
        this.articles = articles;
        this.sales = sales;
    }


    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getVille() {
        return ville;
    }
}
