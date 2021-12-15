package edu.upc.dsa.models;

import java.util.LinkedList;

public class Store {

    LinkedList<Objects> products = new LinkedList<Objects>();
    public Store(LinkedList<Objects> products){
        this.products=products;}

    public void setProducts(LinkedList<Objects> objects){this.products=products;}
    public LinkedList<Objects> getProducts(){return this.products;}

}
