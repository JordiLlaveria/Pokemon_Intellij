import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import javax.swing.text.Element;
import java.util.LinkedList;
import java.util.List;

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
        LinkedList<Object> JordiobjectsList = new LinkedList<Object>();

        LinkedList<Pokemon> AshpokemonsList = new LinkedList<Pokemon>();
        LinkedList<Object> AshobjectsList = new LinkedList<Object>();

        Character characterjordi = new Character("jllaveria",100,0,JordipokemonsList,JordiobjectsList);
        Character characterash = new Character("ash",100,0,AshpokemonsList,AshobjectsList);
        Jordi = new User("Jordi", "1234", "jordi.llaveria@estudiantat.upc.edu",characterjordi);
        Ash = new User("Ash", "1234", "ash@gmail.com",characterash);
        manager.RegisterUser(Jordi);
        manager.RegisterUser(Ash);

        LinkedList<Atack> pikachuAtackList = new LinkedList<Atack>();
        LinkedList<Atack> bulbasaurAtackList = new LinkedList<Atack>();
        pikachu = new Pokemon(1,"Pikachu",50,"Electric", pikachuAtackList);
        bulbasaur = new Pokemon(1,"Bulbasaur",45,"Grass",bulbasaurAtackList);
        manager.AddPokemon(pikachu);
        manager.AddPokemon(bulbasaur);

        Object potion = new Object("Potion", 20,"Healthcure");
        Object pokeball = new Object("Pokeball", 18,"Pokeball");
        manager.CreateObject(potion);
        manager.CreateObject(pokeball);
        manager.AddObject(Jordi,potion);
        manager.AddObject(Ash,pokeball);

        Jordi.getCharacter().addPokemon(pikachu);
        Ash.getCharacter().addPokemon(bulbasaur);
    }

    @Test
    public void ComprobarRegistre(){
        Assert.assertEquals(manager.getUsers().size(),2);
    }
}
