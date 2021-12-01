package edu.upc.dsa.models;

import java.util.LinkedList;

public class Store {

    LinkedList<Object> products = new LinkedList<Object>();
    public Store(LinkedList<Object> products){
        this.products=products;}

    public void setProducts(LinkedList<Object> objects){this.products=products;}
    public LinkedList<Object> getProducts(){return this.products;}

}
