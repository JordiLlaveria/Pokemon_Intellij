import java.util.*;

import org.apache.log4j.Logger;

public class ManagerImpl implements Manager {

    private static ManagerImpl instance;
    private ManagerImpl(){}
    public static ManagerImpl getInstance(){
        if (instance==null){
            instance=new ManagerImpl();
        }
        return instance;
    }

    final static Logger logger = Logger.getLogger(ManagerImpl.class);
    LinkedList<User> userList = new LinkedList<User>();
    LinkedList<Pokemon> pokemonList = new LinkedList<Pokemon>();
    LinkedList<Object> objectList = new LinkedList<Object>();

    User user;
    @Override
    public void RegisterUser(User user) {
        int i=0;
        int trobat=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(user.getUsername())){
                trobat=1;
            }
            i++;
        }
        if (trobat==0){this.userList.add(user);}
        else{}
    }

    @Override
    public boolean LoginUser(String name, String password) {
        int i=0;
        int trobat=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(name)){
                trobat=1;
            }
            i++;
        }
        if (trobat==0){return false;}
        else{return true;}
    }

    @Override
    public void AddCharacter(User user, Character character) {
        int i=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(user.getUsername())){
                userList.get(i).setCharacter(character);
            }
            i++;
        }
    }

    @Override
    public void AddObject(Object object) {
        int i=0;
        while (i<userList.size()){
            if (userList.get(i).getUsername().equals(user.getUsername())){
                userList.get(i).getCharacter().addObject(object);
            }
            i++;
        }
    }

    @Override
    public void AddPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    @Override
    public LinkedList<User> getRanking() {
        LinkedList<User> rankinglist = this.userList;
        Collections.sort(rankinglist,new Ranking());
        return rankinglist;
    }

    @Override
    public LinkedList<Pokemon> getPokemons() {
        return this.pokemonList;
    }

    @Override
    public LinkedList<Object> getObjects() {
        return this.objectList;
    }
}
