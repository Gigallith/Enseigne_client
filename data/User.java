package fr.unice.polytech.enseigne_client.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/05/2017.
 */

public class User {

    private String name;
    private String mail;
    private String password;
    private List<GiftCard> giftCards;
    private LoyaltyCard loyaltyCard;
    private List<User> sponsored;

    public User(String name, String mail, LoyaltyCard loyaltyCard) {
        this.name = name;
        this.mail = mail;
        this.loyaltyCard = loyaltyCard;
        this.sponsored = new ArrayList<>();
        this.giftCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }

    public List<User> getSponsored() {
        return sponsored;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addSponsored(User user) {
        this.sponsored.add(user);
    }

    public void addGiftCard(GiftCard giftCard) {
        this.giftCards.add(giftCard);
    }
}
