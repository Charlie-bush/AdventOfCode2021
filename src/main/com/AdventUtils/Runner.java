package main.com.AdventUtils;


import main.com.week2.day11.Day11P2;
import main.com.week2.day13.Day13;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        Day13 day = new Day13();
        day.process();
        System.out.println("Result: "+ day.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
