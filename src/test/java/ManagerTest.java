import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Atack;
import edu.upc.dsa.models.Character;
import edu.upc.dsa.models.Object;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class ManagerTest {
    ManagerImpl manager;
    User Jordi;
    User Ash;
    Pokemon pikachu;
    Pokemon bulbasaur;
    @Before
    public void setUp  () {
        this.manager = ManagerImpl.getInstance();

        LinkedList<Pokemon> JordipokemonsList = new LinkedList<Pokemon>();
        LinkedList<edu.upc.dsa.models.Object> JordiobjectsList = new LinkedList<edu.upc.dsa.models.Object>();

        LinkedList<Pokemon> AshpokemonsList = new LinkedList<Pokemon>();
        LinkedList<edu.upc.dsa.models.Object> AshobjectsList = new LinkedList<edu.upc.dsa.models.Object>();

        LinkedList<Atack> pikachuAtackList = new LinkedList<Atack>();
        LinkedList<Atack> bulbasaurAtackList = new LinkedList<Atack>();
        pikachu = new Pokemon(1,"Pikachu",50,"Electric", pikachuAtackList);
        bulbasaur = new Pokemon(1,"Bulbasaur",45,"Grass",bulbasaurAtackList);
        manager.addPokemon(pikachu);
        manager.addPokemon(bulbasaur);

        Character characterjordi = new Character("jllaveria",100,0,JordipokemonsList,JordiobjectsList);
        Character characterash = new Character("ash",100,0,AshpokemonsList,AshobjectsList);
        characterjordi.addPokemon(bulbasaur);
        characterash.addPokemon(pikachu);
        Jordi = new User("Jordi", "1234", "jordi.llaveria@estudiantat.upc.edu",characterjordi);
        Ash = new User("Ash", "1234", "ash@gmail.com",characterash);
        manager.registerUser(Jordi);
        manager.registerUser(Ash);

        edu.upc.dsa.models.Object potion = new edu.upc.dsa.models.Object("Potion", 20,"Healthcure","Adds +20 health");
        edu.upc.dsa.models.Object pokeball = new Object("Pokeball", 18,"Pokeball", "Allows to capture a pokemon with probability 1/3");
        manager.createObject(potion);
        manager.createObject(pokeball);
        manager.addObject(Jordi,potion);
        manager.addObject(Ash,pokeball);

    }

    @Test
    public void ComprobarRegistre(){
        Assert.assertEquals(manager.getUsers().size(),2);
    }
}
