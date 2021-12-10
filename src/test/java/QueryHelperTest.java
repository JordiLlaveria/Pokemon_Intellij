import edu.upc.dsa.FactorySession;
import edu.upc.dsa.ManagerImpl;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Character;
import edu.upc.dsa.models.Objects;
import org.junit.Before;
import org.junit.Test;

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
        Character c = new Character("Pablito", 200.0,20.0,null,null,null,null,null,null);
        Session sess = s.openSession();
        sess.save(c);
        User u = new User("Pablo", "12345", "pablo@gmail.com","Pablito");
        sess = s.openSession();
        sess.save(u);
    }

    @Test
    public void testInsertUser(){
        User u = new User("Pablo", "12345", "pablo@gmail.com","Pablito");
        Session sess = s.openSession();
        sess = s.openSession();
        sess.save(u);
    }
    @Test
    public void testInsertPokemon(){
        Pokemons p = new Pokemons("Eevee","Normal",1.0,20.0,20.0,0.5,0.5,null,null);
        Session sess = s.openSession();
        sess.save(p);
    }
    @Test
    public void testInsertObject(){
        Objects o = new Objects("Superpotion",125.0,"Potion","Heals 100HP");
        Session sess = s.openSession();
        sess.save(o);
    }

    @Test
    public void testSelectUser(){
        User u = new User();
        Session sess = s.openSession();
        sess.get(u,"Jordi");
    }

    @Test
    public void testSelectCharacter(){
        Character c = new Character();
        Session sess = s.openSession();
        sess.get(c,"James");
    }

    @Test
    public void testSelectPokemon(){
        Pokemons p = new Pokemons();
        Session sess = s.openSession();
        sess.get(p,"Squirtle");
    }

    @Test
    public void testSelectObject(){
        Objects o = new Objects();
        Session sess = s.openSession();
        //sess.get(o,"Pokeball");
    }

    @Test
    public void testSelectEnemy(){
        Enemy e = new Enemy();
        Session sess = s.openSession();
        //sess.get(e,"Malo1");
    }
    @Test
    public void testUpdate(){
        User u = new User("Jordi","1234","jordi.llaveria@estudiantat.upc.edu","Pablito");
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.update(u);
    }

    @Test
    public void testDelete(){
        User u = new User("Pablo","1234","jordi.llaveria@estudiantat.upc.edu","Pablito");
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.delete(u, u.getName());
    }
    @Test
    public void testSelectall(){
        //Employee e = new Employee();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        //List<Object> objects = sess.findAll(e);
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
