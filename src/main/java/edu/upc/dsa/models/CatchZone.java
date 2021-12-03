package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class CatchZone {
    private int numBush;
    private int fruits;
    LinkedList<Pokemon> pokemonListToCatch = new LinkedList<Pokemon>();

    public CatchZone (int numBush,int fruits,LinkedList<Pokemon>pokemonListToCatch){
        this.numBush=numBush;
        this.fruits=fruits;
        this.pokemonListToCatch=pokemonListToCatch;
    }

    public void setNumBush(int numBush) {this.numBush = numBush;}
    public void setFruits(int fruits) {this.fruits = fruits;}
    public void setPokemonListToCatch(LinkedList<Pokemon> pokemonListToCatch) {this.pokemonListToCatch = pokemonListToCatch;}


    public int getNumBush() {return numBush;}
    public int getFruits() {return fruits;}
    public LinkedList<Pokemon> getPokemonListToCatch() {return pokemonListToCatch;}
}
