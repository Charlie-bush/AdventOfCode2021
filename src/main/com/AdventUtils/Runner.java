package main.com.AdventUtils;

import main.com.week1.day1.DayOne;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        DayOne dayOne = new DayOne();
        dayOne.process();
        System.out.println("Result: "+ dayOne.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
