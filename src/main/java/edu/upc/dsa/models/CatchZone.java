package edu.upc.dsa.models;

import java.util.LinkedList;

public class CatchZone {
    private int numBush;
    private int fruits;
    LinkedList<pokemons> pokemonsListToCatches = new LinkedList<pokemons>();

    public CatchZone (int numBush,int fruits,LinkedList<pokemons> pokemonsListToCatches){
        this.numBush=numBush;
        this.fruits=fruits;
        this.pokemonsListToCatches = pokemonsListToCatches;
    }

    public void setNumBush(int numBush) {this.numBush = numBush;}
    public void setFruits(int fruits) {this.fruits = fruits;}
    public void setPokemonListToCatch(LinkedList<pokemons> pokemonsListToCatches) {this.pokemonsListToCatches = pokemonsListToCatches;}


    public int getNumBush() {return numBush;}
    public int getFruits() {return fruits;}
    public LinkedList<pokemons> getPokemonListToCatch() {return pokemonsListToCatches;}
}
