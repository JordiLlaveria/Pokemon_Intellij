import java.util.LinkedList;

public interface Manager {
    public void RegisterUser(User user);
    public boolean LoginUser(String name, String password);
    public void AddCharacter(User user, Character character);
    public void AddObject(Object object);
    public void AddPokemon(Pokemon pokemon);
    public LinkedList<User> getRanking();
    public LinkedList<Pokemon> getPokemons();
    public LinkedList<Object> getObjects();

}
