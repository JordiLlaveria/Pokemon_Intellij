package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Character;
import edu.upc.dsa.models.Objects;
import org.apache.log4j.Logger;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ManagerImpl implements Manager {

    private static ManagerImpl instance;
    public ManagerImpl(){}
    public static ManagerImpl getInstance(){
        if (instance==null){
            instance = new ManagerImpl();
        }
        return instance;
    }

    final static Logger logger = Logger.getLogger(ManagerImpl.class);
    LinkedList<User> userList = new LinkedList<User>();
    LinkedList<Character> characterList = new LinkedList<Character>();
    LinkedList<Pokemons> pokemonsList = new LinkedList<Pokemons>();
    LinkedList<Objects> objectsList = new LinkedList<Objects>();
    LinkedList<edu.upc.dsa.models.Map> mapList = new LinkedList<edu.upc.dsa.models.Map>();

    @Override
    public int registerUser(User user) {
        try{
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object u = null;
            u = sess.get(User.class,user.getName());
            if(u==null) {
                sess = s.openSession();
                sess.save(user);
                return 0; //registro correcto
            }
            else { return -1;} //usuario ya existente
        }catch(Exception e){return -2;} // no se ha podido conectar con la BBDD
    }

    @Override
    public User login(String name) {
        try {
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            User u = null;
            u = (User) sess.get(User.class,name);
            return u; // se ha podido iniciar sesión correctamente
        }catch(Exception e) {return null;} // no se ha podido conectar con la BBDD
    }

    @Override
    public int updateUser(User user) {
        try {
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.update(user);
            return 0; // modificación correcta
        }catch(Exception e) {return -2;} //no se ha podido conectar con la BBDD
    }

    @Override
    public int addCharacter(Character character) {
        try{
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Object c = null;
            c = sess.get(Character.class,character.getName());
            if(c==null) {
                sess = s.openSession();
                sess.save(character);
                return 0; // caracter añadido correctamente
            }
            else{ return -1; } // caracter ya existente
        }catch(Exception e) {return -2;} // no se ha podido conectar con la BBDD
    }

    @Override
    public Character getCharacter(String name) {
        try{
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            Character c = null;
            c = (Character) sess.get(Character.class,name);
            return c;
        }catch (Exception e){return null;}
    }

    @Override
    public int updateCharacter(Character character) {
        // FALTA IMPLEMENTAR EN LA BBDD
        try {
            int i = 0;
            boolean trobat = false;
            while ((i < characterList.size()) && (trobat == false)) {
                if (characterList.get(i).getName().equals(character.getName())) {
                    trobat = true;}
                else { i = i + 1;}
            }
            if (trobat == true) {
                characterList.remove(i);
                characterList.add(i, character);
                return 0;}
            else { return -1;}
        }catch (Exception e){ return -3;}
    }

    @Override //TEMPORAL
    public LinkedList<Objects> getObjects() {
        objectsList.add(new Objects("Potion", 100.00, "Healing", "Heals 100 hp"));
        objectsList.add(new Objects("PokeBall", 200.00, "Catching", "Can catch a Pokemon"));
        return this.objectsList;
    }

    public User deleteUser(String username) {
        try {
            FactorySession s = new FactorySession();
            Session sess = s.openSession();

            User u = null;
            u = (User) sess.get(User.class, username);

            if (u != null) {
                User user = new User();
                Character character = new Character();
                sess = s.openSession();
                sess.delete(character, u.getCharactername());
                sess = s.openSession();
                sess.delete(user, username);
            }
            return u;
        }catch(Exception e) {return null;} // error usuario no encontrado
    }

    @Override
    public List<Pokemons> getPokemons() {
        try{
        LinkedList<Pokemons> pokemons = null;
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        pokemons = sess.findAll(Pokemons.class);
        return pokemons;
        }catch(Exception e) {return null;} //error lista vacia
    }

    @Override
    public List<Character> getRanking() {
        LinkedList<Character> characters = null;

        FactorySession s = new FactorySession();
        Session sess = s.openSession();

        characters = sess.findAll(Character.class);

        Collections.sort(characters, new Ranking());

        return characters;
    }



    /*


    @Override
    public void createObject(Objects objects) {
        int i=0;
        int trobat=0;
        while ((i< objectsList.size()) && (trobat == 0)){
            if (objectsList.get(i).getName().equals(objects.getName())){
                trobat++;
            }
            i++;
        }
        if(trobat==0){
            objectsList.add(objects);}
    }

    @Override
    public void addObject(User user, Objects objects) {
        int i=0;
        int trobat = 0;
        while ((i<userList.size()) &&(trobat==0)){
            if (userList.get(i).getName().equals(user.getName())){
                searchCharacter(userList.get(i)).addObject(objects);
                searchCharacter(userList.get(i)).setMoney(searchCharacter(userList.get(i)).getMoney() - objects.getPrice());
                trobat = 1;
            }
            i++;
        }
    }

    @Override
    public void addPokemon(Pokemons pokemons) {
        this.pokemonsList.add(pokemons);
    }

    @Override
    public LinkedList<User> getUsers() {
        return this.userList;
    }

    @Override
    public LinkedList<edu.upc.dsa.models.Map> getMaps() {
        return this.mapList;
    }

    @Override
    public LinkedList<Character> getRanking() {
        LinkedList<Character> rankinglist = this.characterList;
        Collections.sort(rankinglist,new Ranking());
        return rankinglist;
    }

    @Override
    public LinkedList<Pokemons> getPokemons() {
        return this.pokemonsList;
    }

    @Override
    public LinkedList<Pokemons> getPokemonsCharacter(Character character) {
        int i=0;
        int trobat=0;
        LinkedList<Pokemons> pokemons = new LinkedList<Pokemons>();
        while ((i<userList.size())&&(trobat == 0)){
            if (searchCharacter(userList.get(i)).getName().equals(character.getName())){
                trobat=1;
            }
            else {
                i++;
            }
        }
        if(trobat==1){
            int j=0;
            while (i<pokemonsList.size())
            {
                if (pokemonsList.get(j).getName()==searchCharacter(userList.get(i)).getPokemon1name()||pokemonsList.get(j).getName()==searchCharacter(userList.get(i)).getPokemon2name()||pokemonsList.get(j).getName()==searchCharacter(userList.get(i)).getPokemon3name())
                {
                    pokemons.add(pokemonsList.get(j));
                }
                j++;
            }
            return pokemons;
        }
        else{return null;}
    }



    @Override
    public LinkedList<Objects> getObjectsPersonatge(Character character) {
        int i=0;
        int trobat=0;
        LinkedList<Objects> objects= new LinkedList<Objects>();
        while ((i<userList.size())&&(trobat == 0)){
            if (searchCharacter(userList.get(i)).getName().equals(character.getName())){
                trobat=1;
            }
            else {
                i++;
            }
        }
        if(trobat==1){
            int j=0;
            while (i< objectsList.size())
            {
                if (objectsList.get(j).getName()==searchCharacter(userList.get(i)).getObject1name()|| objectsList.get(j).getName()==searchCharacter(userList.get(i)).getObject2name()|| objectsList.get(j).getName()==searchCharacter(userList.get(i)).getObject3name())
                {
                    objects.add(objectsList.get(j));
                }
                j++;
            }
            return objects;
        }
        else{return null;}
    }

    @Override
    public Map levelup(Character character) {
        return null;
    }

     */
}
