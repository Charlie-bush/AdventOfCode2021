package main.com.AdventUtils;


import main.com.week2.day11.Day11P2;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        Day11P2 day11 = new Day11P2();
        day11.process();
        System.out.println("Result: "+ day11.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
