package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Character;
import edu.upc.dsa.models.Object;

import java.util.LinkedList;

public interface Manager {
    public void registerUser(User user);
    public boolean loginUser(String name, String password);
    public void addCharacter(User user, Character character);
    public void createObject(Object object);
    public void addObject(User user, Object object);
    public void addPokemon(Pokemons pokemons);
    public LinkedList<User> getUsers();
    public LinkedList<Map> getMaps();
    public LinkedList<User> getRanking();
    public LinkedList<Pokemons> getPokemons();
    public LinkedList<Pokemons> getPokemonsCharacter(Character character);
    public LinkedList<Object> getObjects();
    public LinkedList<Object> getObjectsPersonatge(Character character);
    public Map levelup(Character character);
}
