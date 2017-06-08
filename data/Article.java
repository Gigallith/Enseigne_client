package fr.unice.polytech.enseigne_client.data;

/**
 * Created by user on 10/05/2017.
 */

class Article {

    String name;
    String picture;
    int price;
    int loyalty_price;
    int sale_price;

    public Article(String name, String picture, int price) {
        this.name = name;
        this.picture = picture;
        this.price=price;
        this.loyalty_price=price*100;
    }

    public String getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getLoyalty_price() {
        return loyalty_price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }
}
