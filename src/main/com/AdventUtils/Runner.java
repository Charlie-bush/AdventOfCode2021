package main.com.AdventUtils;



import main.com.week2.Day10;
import main.com.week2.Day10P2;

import java.util.Stack;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        Day10P2 day10P2 = new Day10P2();
        day10P2.process();
        System.out.println("Result: "+ day10P2.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
