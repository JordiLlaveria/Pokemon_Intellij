package edu.upc.dsa.models;

import java.util.Comparator;

public class Ranking implements Comparator<User> {

    public int compare(User u1, User u2){

        return (int)(u1.getCharacter().getPoints() - u2.getCharacter().getPoints());
    }

}
