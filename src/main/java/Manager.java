import java.util.LinkedList;

public interface Manager {
    public void registerUser(User user);
    public boolean loginUser(String name, String password);
    public void addCharacter(User user, Character character);
    public void createObject(Object object);
    public void addObject(User user, Object object);
    public void addPokemon(Pokemon pokemon);
    public LinkedList<User> getUsers();
    public LinkedList<Map> getMaps();
    public LinkedList<User> getRanking();
    public LinkedList<Pokemon> getPokemons();
    public LinkedList<Pokemon> getPokemonsCharacter(Character character);
    public LinkedList<Object> getObjects();
    public LinkedList<Object> getObjectsPersonatge(Character character);
    public Map levelup(Character character);
}
