package com.maksgir.util;

import javax.management.Query;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class DataGenerator {

    public Queue<String> colorSet;
    public Queue<Integer> legSet;

    public DataGenerator() {
        colorSet = new ArrayDeque<>();
        colorSet.add("FD0000FF");
        colorSet.add("FD6100FF");
        colorSet.add("FDCA00FF");
        colorSet.add("3FFD00FF");

        legSet = new ArrayDeque<>();
        legSet.add(9);
        legSet.add(8);
        legSet.add(5);
        legSet.add(1);
        legSet.add(6);
    }

    public String getColor(){
        return colorSet.peek();
    }

    public Integer getLegs(){
        return legSet.peek();
    }
}
