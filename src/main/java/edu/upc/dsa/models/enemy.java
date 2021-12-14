package edu.upc.dsa.models;

public class enemy {
    String name;
    String message;
    String pokemonname;
    //Pokemons pokemons;

    public enemy(){}
    public enemy(String name, String message, String pokemonname){
        this();
        setName(name);
        setMessage(message);
        setPokemonname(pokemonname);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return this.name;}

    public void setMessage(String message){this.message=message;}
    public String getMessage(){return this.message;}

    //public void setPokemon(Pokemons pokemons){this.pokemons = pokemons;}
    //public Pokemons getPokemon(){return this.pokemons;}

    public void setPokemonname(String name){this.pokemonname=name;}
    public String getPokemonname(){return this.pokemonname;}
}
