package edu.upc.dsa.util;

import net.moznion.random.string.RandomStringGenerator;
import java.util.Random;

public class RandomUtils {

    public static int getId() {
        Random rand = new Random();
        int id = rand.nextInt(1000);
        return id;
    }
}
