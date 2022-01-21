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
            FactorySession s = new FactorySession();
            Session sess = s.openSession();
            sess.update(character);
            return 0; // modificación correcta
        }catch(Exception e) {return -2;} //no se ha podido conectar con la BBDD
    }

    @Override //TEMPORAL
    public LinkedList<Objects> getObjects() {
        try{
        LinkedList<Objects> objects = null;
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        objects = sess.findAll(Objects.class);
        return objects;}
        catch (Exception e){return null;}
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
    public List<Basepokemon> getPokemons() {
        try{
        LinkedList<Basepokemon> pokemons = null;
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        pokemons = sess.findAll(Basepokemon.class);
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



}
