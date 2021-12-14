package edu.upc.dsa.models;

public class ObjectWithCharacter {
    private objects object;
    private edu.upc.dsa.models.character character;


    public ObjectWithCharacter(){}
    public ObjectWithCharacter(objects object, edu.upc.dsa.models.character character){
        this();
        setCharacter(character);
        setObject(object);

    }

    public edu.upc.dsa.models.character getCharacter() {return character;}
    public objects getObject() {return object;}
    public void setCharacter(edu.upc.dsa.models.character character) {this.character = character;}
    public void setObject(objects object) {this.object = object;}
}
