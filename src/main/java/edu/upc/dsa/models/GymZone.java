package edu.upc.dsa.models;
import java.util.LinkedList;

public class GymZone {
        private Store store;
        LinkedList<character> trainers = new LinkedList<character>();

        public GymZone (Store store,LinkedList<character>trainers){
            this.store=store;
            this.trainers=trainers;}

    public void setStore(Store store) {this.store = store;}
    public void setTrainers(LinkedList<character> trainers) {this.trainers = trainers;}

    public Store getStore() {return store;}
    public LinkedList<character> getTrainers() {return trainers;}
}
