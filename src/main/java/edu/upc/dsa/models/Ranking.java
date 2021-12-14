package edu.upc.dsa.models;

import java.util.Comparator;

public class Ranking implements Comparator<character> {

    public int compare(character c1, character c2){

        return (int)(c1.getPoints() - c2.getPoints());
    }
}
