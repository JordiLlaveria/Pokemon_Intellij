package edu.upc.dsa.models;
import java.util.LinkedList;

public class GymZone {
        private Store store;
        LinkedList<Character> trainers = new LinkedList<Character>();

        public GymZone (Store store,LinkedList<Character>trainers){
            this.store=store;
            this.trainers=trainers;}

    public void setStore(Store store) {this.store = store;}
    public void setTrainers(LinkedList<Character> trainers) {this.trainers = trainers;}

    public Store getStore() {return store;}
    public LinkedList<Character> getTrainers() {return trainers;}
}
