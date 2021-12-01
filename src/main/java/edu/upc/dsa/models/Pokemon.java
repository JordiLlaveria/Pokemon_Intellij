package edu.upc.dsa.models;

import java.util.LinkedList;

public class Pokemon {
    private String name;
    private String type;
    private int level;
    //private String aspect;
    LinkedList<Atack> atackList = new LinkedList<Atack>();
    private double maxHealth;
    private double actualHealth;
    private double probCapture;
    private double probAppear;

    public Pokemon(String name,String type,int level,LinkedList<Atack> atackList, double maxHealth, double actualHealth,double probCapture,double probAppear){
        this.name=name;
        this.type=type;
        this.level=level;
        this.atackList=atackList;
        this.maxHealth=maxHealth;
        this.actualHealth=actualHealth;
        this.probCapture=probCapture;
        this.probAppear=probAppear;
    }
    public void setName(String name){this.name=name;}
    public void setType(String type){this.type=type;}
    public void setLevel(int level){this.level=level;}
    public void setMaxHealth(double maxHealth){this.maxHealth=maxHealth;}
    public void setActualHealth(double actualHealth){this.actualHealth=actualHealth;}
    public void setAtackList(LinkedList<Atack> atackList){this.atackList=atackList;}
    public void setProbCapture(double probCapture) {this.probCapture = probCapture;}
    public void setProbAppear(double probAppear) {this.probAppear = probAppear;}

    public String getName(){return this.name;}
    public String getType(){return this.type;}
    public double getLevel(){return this.level;}
    public double getMaxHealth(){return this.maxHealth;}
    public double getActualHealth(){return this.actualHealth;}
    public LinkedList<Atack> getAtackList(){return this.atackList;}
    public double getProbCapture() {return probCapture;}
    public double getProbAppear() {return probAppear;}
}
