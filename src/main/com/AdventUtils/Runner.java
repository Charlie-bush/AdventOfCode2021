package main.com.AdventUtils;


import main.com.week2.day9.Day9;
import main.com.week2.day10.Day10P2;
import main.com.week2.day9.Day9P2;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        Day9P2 day9P2 = new Day9P2();
        day9P2.process();
        System.out.println("Result: "+ day9P2.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
