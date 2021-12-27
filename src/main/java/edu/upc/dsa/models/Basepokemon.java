package edu.upc.dsa.models;

public class Basepokemon {
    private String name;
    private String type;
    private Double maxHealth;

    public Basepokemon() {}
    public Basepokemon(String name, String type, Double maxHealth){
        this();
        setName(name);
        setType(type);
        setMaxHealth(maxHealth);
    }

    public void setName(String name){this.name=name;}
    public void setType(String type){this.type=type;}
    public void setMaxHealth(Double health){this.maxHealth=health;}

    public String getName(){return this.name;}
    public String getType(){return this.type;}
    public Double getMaxHealth(){return this.maxHealth;}
}
