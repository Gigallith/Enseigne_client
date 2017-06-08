package fr.unice.polytech.enseigne_client.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 14/05/2017.
 */

public class Database {
    public static Map<String, User> userDatabase;
    public static Map<String, Shop> shopDatabase;
    static List<Article> articles;

    static {
        userDatabase = new HashMap<>();
        //1Qgigof1T8dYjDEYF0iVyFixW2L2
        userDatabase.put("paul.dupont@etu.unice.fr", new User("Paul DUPONT", "paul.dupont@etu.unice.fr", "123"));
        userDatabase.put("alexandre.clement@etu.unice.fr", new User("Alexandre CLEMENT", "alexandre.clement@etu.unice.fr", "123"));
        userDatabase.put("marion.campora@etu.unice.fr", new User("Marion CAMPORA", "marion.campora@etu.unice.fr", "123"));
        userDatabase.put("gaetan.vialon@etu.unice.fr", new User("Gaetan VIALON", "gaetan.vialon@etu.unice.fr", "123"));

        userDatabase.get("paul.dupont@etu.unice.fr").getLoyaltyCard().addPoints(1000);

        articles = new ArrayList<>();
        articles.add(new Article("Drone", "@drawable/pictureGoods/drone.jpg", 100));
        articles.add(new Article("Canard Bluetooth", "@drawable/pictureGoods/canard.jpg", 150));
        articles.add(new Article("Casque", "@drawable/pictureGoods/casque.jpg", 70));
        articles.add(new Article("Enceinte WiFi", "@drawable/pictureGoods/enceinte.jpg", 50));
        articles.add(new Article("Ordinateur portable", "@drawable/pictureGoods/portable.jpg", 800));
        articles.add(new Article("Moto de sport", "@drawable/pictureGoods/moto.jpg", 5000));
        articles.add(new Article("Aspirateur Dyson", "@drawable/pictureGoods/aspirateur.jpg", 200));
        articles.add(new Article("Manette ps4", "@drawable/pictureGoods/manette.jpg", 60));
        articles.add(new Article("Smartphone", "@drawable/pictureGoods/smartphone.jpg", 300));


        shopDatabase = new HashMap<>();
        int nbShops = 5;
        for (int i = 0; i < nbShops; i++) {
            List<Article> articlesAleat = new ArrayList<>(articles);
            Collections.shuffle(articlesAleat);
            articlesAleat.remove(8);
            articlesAleat.remove(7);
            articlesAleat.remove(6);
            shopDatabase.put("" + (i + 1), new Shop("", 0, 0, articlesAleat, new ArrayList<Article>()));
        }

        shopDatabase.get("1").setVille("Antibes");
        shopDatabase.get("1").setLatitude(43.603582);
        shopDatabase.get("1").setLongitude(7.088716);

        shopDatabase.get("2").setVille("Trelissac");
        shopDatabase.get("2").setLatitude(45.191373);
        shopDatabase.get("2").setLongitude(0.762879);

        shopDatabase.get("3").setVille("Toulouse");
        shopDatabase.get("3").setLatitude(43.602833);
        shopDatabase.get("3").setLongitude(1.449432);

        shopDatabase.get("4").setVille("Nante");
        shopDatabase.get("4").setLatitude(47.190735);
        shopDatabase.get("4").setLongitude(-1.493405);

        shopDatabase.get("5").setVille("Hamhung");
        shopDatabase.get("5").setLatitude(39.985041);
        shopDatabase.get("5").setLongitude(127.611869);

    }
}
