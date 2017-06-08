package fr.unice.polytech.enseigne_client.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/05/2017.
 */

public class LoyaltyCard {

    private int points;
    private List<User> sponsored;

    public LoyaltyCard() {
        this.points = 0;
        this.sponsored = new ArrayList<>();
    }

    public void addPoints(int points) {
        this.points+=points;
    }

    public void addSponsored(User user) {
        this.sponsored.add(user);
    }

    public int getPoints() {
        return points;
    }

    public void addSponsor(User user) {
        sponsored.add(user);
    }

    public List<User> getSponsored() {
        return sponsored;
    }
}
