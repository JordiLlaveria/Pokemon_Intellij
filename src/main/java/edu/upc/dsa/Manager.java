package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.models.character;
import edu.upc.dsa.models.objects;

import java.util.LinkedList;

public interface Manager {
    public boolean registerUser(user user);
    public user loginUser(String name, String password);
    public boolean addCharacter(character character);
    public character getCharacter(String charactername);
    public boolean updateCharacter(character character);
    public LinkedList<objects> getObjects();
    /*

    public void addCharacter(User user, Character character);
    public void createObject(Objects objects);
    public void addObject(User user, Objects objects);
    public void addPokemon(Pokemons pokemons);
    public LinkedList<User> getUsers();
    public LinkedList<Map> getMaps();
    public LinkedList<Character> getRanking();
    public LinkedList<Pokemons> getPokemons();
    public LinkedList<Pokemons> getPokemonsCharacter(Character character);
    public LinkedList<Objects> getObjectsPersonatge(Character character);
    public Map levelup(Character character);

     */
}
