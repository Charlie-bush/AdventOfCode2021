package main.com.AdventUtils;


import main.com.week1.day3.DayThree;
import main.com.week1.day3.DayThreePartTwo;
import main.com.week1.day4.DayFour;
import main.com.week1.day4.DayFourPartTwo;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        DayFourPartTwo dayFourPartTwo = new DayFourPartTwo();
        dayFourPartTwo.process();
        System.out.println("Result: "+ dayFourPartTwo.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
