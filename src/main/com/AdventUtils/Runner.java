package main.com.AdventUtils;

import main.com.week1.day1.DayOne;
import main.com.week1.day2.DayTwoPartTwo;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        DayTwoPartTwo dayTwoPartTwo = new DayTwoPartTwo();
        dayTwoPartTwo.process();
        System.out.println("Result: "+ dayTwoPartTwo.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
