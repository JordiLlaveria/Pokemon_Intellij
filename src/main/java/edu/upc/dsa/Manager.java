package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Character;
import edu.upc.dsa.models.Objects;

import java.util.LinkedList;

public interface Manager {
    public void registerUser(User user);
    public User loginUser(String name, String password);
    public Character searchCharacter(User user);
    //public void addCharacter(User user, Character character);
    public void createObject(Objects objects);
    public void addObject(User user, Objects objects);
    public void addPokemon(Pokemons pokemons);
    public LinkedList<User> getUsers();
    public LinkedList<Map> getMaps();
    public LinkedList<Character> getRanking();
    public LinkedList<Pokemons> getPokemons();
    public LinkedList<Pokemons> getPokemonsCharacter(Character character);
    public LinkedList<Objects> getObjects();
    public LinkedList<Objects> getObjectsPersonatge(Character character);
    public Map levelup(Character character);
}
