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

    public User(String name, String mail) {

        this.name = name;
        this.mail = mail;
        this.giftCards = new ArrayList<>();
        this.loyaltyCard = new LoyaltyCard();
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.loyaltyCard = new LoyaltyCard();

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


    public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addGiftCard(GiftCard giftCard) {
        this.giftCards.add(giftCard);
    }


}
