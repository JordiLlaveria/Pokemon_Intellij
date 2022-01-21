package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Character;
import edu.upc.dsa.models.Objects;

import java.util.LinkedList;
import java.util.List;

public interface Manager {
    public int registerUser(User user);
    public User login(String name);
    public int updateUser(User user);
    public int addCharacter(Character character);
    public Character getCharacter(String charactername);
    public int updateCharacter(Character character); // FALTA IMPLEMENTAR EN BBDD
    public LinkedList<Objects> getObjects(); // TEMPORAL
    public User deleteUser(String username);
    public List<Basepokemon> getPokemons();
    public List<Character> getRanking();
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
