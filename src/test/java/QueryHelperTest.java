import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.*;
import edu.upc.dsa.models.Character;
import edu.upc.dsa.models.Object;
import org.junit.Test;

public class QueryHelperTest {

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
    public void testInsert(){
        Character c = new Character();
        User u = new User("Maria", "12345", "maria@gmail.com","James");
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.save(u);
    }
    @Test
    public void testSelectUser(){
        User u = new User();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.get(u,"Jordi");
    }

    @Test
    public void testSelectCharacter(){
        Character c = new Character();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.get(c,"James");
    }

    @Test
    public void testSelectPokemon(){
        Pokemons p = new Pokemons();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.get(p,"Squirtle");
    }

    @Test
    public void testSelectObject(){
        Object o = new Object();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.get(o,"Pokeball");
    }

    @Test
    public void testSelectEnemy(){
        Enemy e = new Enemy();
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        sess.get(e,"Malo1");
    }
    @Test
    public void testUpdate(){
        //Employee e = new Employee("Aida","Padilla", 600);
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        //sess.update(e);
    }

    @Test
    public void testDelete(){
        //Employee e = new Employee("Joana", "Orpella", 500);
        FactorySession s = new FactorySession();
        Session sess = s.openSession();
        //sess.delete(e);
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
