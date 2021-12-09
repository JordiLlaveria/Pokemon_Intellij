package edu.upc.dsa.models;

import java.util.LinkedList;

public class Character {
    private String name;
    private Double money;
    private Double points;
    //private String avatar;
    private String pokemon1_name;
    private String pokemon2_name;
    private String pokemon3_name;
    private String object1_name;
    private String object2_name;
    private String object3_name;
    LinkedList<Pokemons> pokemons = new LinkedList<Pokemons>();
    LinkedList<Object> objects = new LinkedList<Object>();

    public Character(){}
    public Character(String name, Double money, Double points, LinkedList<Pokemons> pokemons, LinkedList<Object> objects){
        this();
        setName(name);
        setMoney(money);
        setPoints(points);
        setPokemons(pokemons);
        setObjects(objects);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return this.name;}

    public void setMoney(Double money){this.money=money;}
    public Double getMoney(){return this.money;}

    public void setPoints(Double points){this.points=points;}
    public Double getPoints(){return this.points;}

    public void addPokemon(Pokemons pokemons){this.pokemons.add(pokemons);}
    public void setPokemons(LinkedList<Pokemons> pokemons){this.pokemons=pokemons;}
    public LinkedList<Pokemons> getPokemons(){return this.pokemons;}

    public void setObjects(LinkedList<Object> objects){this.objects=objects;}
    public LinkedList<Object> getObjects(){return this.objects;}

    public void setPokemon1_name(String p){this.pokemon1_name=p;}
    public String getPokemon1_name(){return this.pokemon1_name;}

    public void setPokemon2_name(String p){this.pokemon2_name=p;}
    public String getPokemon2_name(){return this.pokemon2_name;}

    public void setPokemon3_name(String p){this.pokemon3_name=p;}
    public String getPokemon3_name(){return this.pokemon3_name;}

    public void setObject1_name(String o){this.object1_name=o;}
    public String getObject1_name(){return this.object1_name;}

    public void setObject2_name(String o){this.object2_name=o;}
    public String getObject2_name(){return this.object2_name;}

    public void setObject3_name(String o){this.object3_name=o;}
    public String getObject3_name(){return this.object3_name;}

    public void addObject(Object object){this.objects.add(object);}
    public int compareTo(Character c)
    {
        int res = (int) (this.getPoints()-c.getPoints());
        return res;
    }
}
