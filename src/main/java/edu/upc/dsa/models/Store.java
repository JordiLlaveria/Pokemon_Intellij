package edu.upc.dsa.models;

import java.util.LinkedList;

public class Store {

    LinkedList<objects> products = new LinkedList<objects>();
    public Store(LinkedList<objects> products){
        this.products=products;}

    public void setProducts(LinkedList<objects> objects){this.products=products;}
    public LinkedList<objects> getProducts(){return this.products;}

}
