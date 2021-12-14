import edu.upc.dsa.FactorySession;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.*;
import edu.upc.dsa.models.character;
import edu.upc.dsa.models.objects;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class QueryHelperTest {
    ManagerImpl manager;
    FactorySession s;
    @Before
    public void setUp()
    {
        manager=null;
        s = new FactorySession();
    }

    @Test
    public void ProbarSetter(){
        //User u = new User("Maria", "12345", "maria@gmail.com",null);
        //ObjectHelper.setter(e,"name","Juan");
        //Assert.assertEquals(e.getName(),"Juan");
    }
    @Test
    public void ProbarGetter(){
        //Employee e = new Employee("Jordi", "Llaveria",500);
        //String name = (String) ObjectHelper.getter(e,"name");
        //Assert.assertEquals(e.getName(),name);
    }
    @Test
    public void testInsertCharacterandUser(){
        character c = new character("Pablito","Red","level2", 200.0,20.0,null,null,null,null,null,null);
        Session sess = s.openSession();
        sess.save(c);
        user u = new user("Pablo", "12345", "pablo@gmail.com","Pablito");
        sess = s.openSession();
        sess.save(u);
    }

    @Test
    public void testInsertUser(){
        user u = new user("Pablo", "12345", "pablo@gmail.com","Pablito");
        Session sess = s.openSession();
        sess = s.openSession();
        sess.save(u);
    }
    @Test
    public void testInsertPokemon(){
        pokemons p = new pokemons("Eevee","Normal",1.0,20.0,20.0,0.5,0.5,null,null);
        Session sess = s.openSession();
        sess.save(p);
    }
    @Test
    public void testInsertObject(){
        objects o = new objects("Superpotion",125.0,"Potion","Heals 100HP");
        Session sess = s.openSession();
        sess.save(o);
    }

    @Test
    public void testSelectUser(){
        Session sess = s.openSession();
        Object u = sess.get(user.class,"Jordi");
    }

    @Test
    public void testSelectCharacter(){
        Session sess = s.openSession();
        Object c = sess.get(character.class,"James");
    }

    @Test
    public void testSelectPokemon(){
        Session sess = s.openSession();
        Object p = sess.get(pokemons.class,"Squirtle");
    }

    @Test
    public void testSelectObject(){
        Session sess = s.openSession();
        Object o = sess.get(objects.class,"Pokeball");
    }

    @Test
    public void testSelectEnemy(){
        Session sess = s.openSession();
        Object e = sess.get(enemy.class,"Malo1");
    }
    @Test
    public void testUpdate(){
        user u = new user("Jordi","1234","jordi.llaveria@estudiantat.upc.edu","James");
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.update(u);
    }

    @Test
    public void testDelete(){
        user u = new user("Pablo","1234","jordi.llaveria@estudiantat.upc.edu","James");
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.delete(u, u.getName());
    }
    @Test
    public void testSelectallPokemons(){
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        LinkedList<pokemons> pokemons = sess.findAll(edu.upc.dsa.models.pokemons.class);
    }

    @Test
    public void testSelectallUsers(){
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        LinkedList<user> users = sess.findAll(user.class);
    }
    @Test
    public void testQueryUPDATE(){
        //Assert.assertEquals("UPDATE Employee SET name = ?, surname = ?, salary = ? WHERE ID = ?",
                //QueryHelper.createQueryUPDATE(new Employee("Juan", "lopez", 333333)));
    }
    @Test
    public void testQueryINSERT() {

        //Assert.assertEquals("INSERT INTO Employee (ID, name, surname, salary) VALUES (?, ?, ?, ?)",
                //QueryHelper.createQueryINSERT(new Employee("Juan", "lopez", 333333)));
    }

    @Test
    public void testQueryINSERT2() {
        //Assert.assertEquals("INSERT INTO Deparment (ID, name, description) VALUES (?, ?, ?)",
                //QueryHelper.createQueryINSERT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA")));
    }

    @Test
    public void testQuerySELECT() {
        //Assert.assertEquals("SELECT * FROM Employee WHERE name = ?",
                //QueryHelper.createQuerySELECT(new Employee("Juan", "lopez", 333333).getClass()));
    }

    @Test
    public void testQuerySELECT2() {
        //Assert.assertEquals("SELECT * FROM Deparment WHERE ID = ?",
                //QueryHelper.createQuerySELECT(new Deparment("ENTEL", "ENGINYERIA TELEMÀTICA").getClass()));
    }

}
