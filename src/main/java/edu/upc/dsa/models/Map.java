package edu.upc.dsa.models;

public class Map {
    private String name;
    private int level;
    private int zone;
    private CatchZone catchZone;
    private GymZone gymZone;

    public Map(String name,int level,int zone, CatchZone catchZone,GymZone gymZone){
        this.name=name;
        this.level=level;
        this.zone=zone;
        this.catchZone=catchZone;
        this.gymZone=gymZone;
    }

    public void setName(String name){this.name=name;}
    public void setLevel(int level) {this.level = level;}
    public void setZone(int zone) {this.zone = zone;}
    public void setCatchZone(CatchZone catchZone) {this.catchZone = catchZone;}
    public void setGymZone(GymZone gymZone) {this.gymZone = gymZone;}

    public String getName(){return this.name;}
    public int getLevel() {return level;}
    public int getZone() {return zone;}
    public CatchZone getCatchZone() {return catchZone;}
    public GymZone getGymZone() {return gymZone;}

}
