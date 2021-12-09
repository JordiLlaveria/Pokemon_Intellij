package edu.upc.dsa.models;

public class Enemy {
    String name;
    String message;
    String pokemon_name;
    Pokemons pokemons;

    public Enemy(){}
    public Enemy(String name, String message, Pokemons pokemons){
        this();
        setName(name);
        setMessage(message);
        setPokemon(pokemons);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return this.name;}

    public void setMessage(String message){this.message=message;}
    public String getMessage(){return this.message;}

    public void setPokemon(Pokemons pokemons){this.pokemons = pokemons;}
    public Pokemons getPokemon(){return this.pokemons;}

    public void setPokemon_name(String name){this.pokemon_name=name;}
    public String getPokemon_name(){return this.pokemon_name;}
}
