package edu.upc.dsa.models;

public class Object {
    private String name;
    private Double price;
    private String type;
    private String description;

    public Object(){}
    public Object(String name, Double price, String type, String description){
        this();
        setName(name);
        setPrice(price);
        setType(type);
        setDescription(description);
    }

    public void setName(String name){this.name=name;}
    public String getName(){return this.name;}

    public void setPrice(Double price){this.price=price;}
    public Double getPrice(){return this.price;}

    public void setType(String type){this.type=type;}
    public String getType(){return this.type;}

    public void setDescription(String description){this.description=description;}
    public String getDescription(){return this.description;}
}
