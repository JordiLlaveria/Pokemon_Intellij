public class Enemy {
    String name;
    String message;
    Pokemon pokemon;

    public Enemy(){}
    public Enemy(String name, String message, Pokemon pokemon){
        this();
        setName(name);
        setMessage(message);
        setPokemon(pokemon);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return this.name;}

    public void setMessage(String message){this.message=message;}
    public String getMessage(){return this.message;}

    public void setPokemon(Pokemon pokemon){this.pokemon=pokemon;}
    public Pokemon getPokemon(){return this.pokemon;}
}
