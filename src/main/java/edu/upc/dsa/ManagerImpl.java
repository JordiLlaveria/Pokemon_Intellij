package edu.upc.dsa;

import edu.upc.dsa.models.*;
import edu.upc.dsa.models.character;
import edu.upc.dsa.models.objects;
import org.apache.log4j.Logger;

import java.util.LinkedList;

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
    LinkedList<user> userList = new LinkedList<user>();
    LinkedList<character> characterList = new LinkedList<character>();
    LinkedList<pokemons> pokemonsList = new LinkedList<pokemons>();
    LinkedList<objects> objectsList = new LinkedList<objects>();
    LinkedList<edu.upc.dsa.models.Map> mapList = new LinkedList<edu.upc.dsa.models.Map>();

    @Override
    public boolean registerUser(user user) {
        int i=0;
        boolean trobat=false;
        while ((i<userList.size())&&(trobat == false)){
            if (userList.get(i).getName().equals(user.getName())){
                trobat=true;
            }
            else {
                i=i+1;
            }
        }
        if (trobat==false){
            this.userList.add(user);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public user loginUser(String name, String password) {
        int i=0;
        boolean trobat=false; //bool
        while ((i<userList.size())&&(trobat == false)){
            if (userList.get(i).getName().equals(name) && userList.get(i).getPassword().equals(password)){
                trobat=true;
            }
            else {
                i=i+1;
            }
        }
        if(trobat){
            return userList.get(i);
        }
        else{
            return null;
        }
    }

    @Override
    public boolean addCharacter(character character) {
        int i=0;
        boolean trobat = false;
        if(characterList.size()==0) {
            while ((i < characterList.size()) && (trobat == false)) {
                if (characterList.get(i).getName().equals(character.getName())) {
                    trobat = true;
                } else {
                    i = i + 1;
                }
            }
        }
        if(trobat == false){
            characterList.add(character);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public character getCharacter(String name) {
        int i=0;
        boolean trobat = false;

        while (i<characterList.size()&&(trobat == false)){
            if (characterList.get(i).getName().equals(name))
            {
                trobat = true;
            }
            else {
                i=i+1;
            }
        }
        if(trobat) {
            return characterList.get(i);
        }
        else{
            return null;
        }
    }
    @Override
    public boolean updateCharacter(character character) {
        int i=0;
        boolean trobat = false;
        while ((i<characterList.size())&&(trobat == false)){
            if (characterList.get(i).getName().equals(character.getName())){
                trobat = true;
            }
            else {
                i=i+1;
            }
        }
        if(trobat == true){
            characterList.remove(i);
            characterList.add(i,character);
            return true;
        }
        else{ return false;}
    }
    @Override
    public LinkedList<objects> getObjects() {
        objectsList.add(new objects("Potion", 100.00, "Healing", "Heals 100 hp"));
        objectsList.add(new objects("PokeBall", 200.00, "Catching", "Can catch a Pokemon"));
        return this.objectsList;
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
