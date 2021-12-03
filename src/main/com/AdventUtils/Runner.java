package main.com.AdventUtils;


import main.com.week1.day3.DayThree;
import main.com.week1.day3.DayThreePartTwo;

public class Runner {
    public static void main(String[] args) {
        long timeBegan = System.nanoTime();
        DayThreePartTwo dayThreePartTwo = new DayThreePartTwo();
        dayThreePartTwo.process();
        System.out.println("Result: "+ dayThreePartTwo.getResult());
        System.out.print("Time taken: ");
        System.out.print((System.nanoTime()-timeBegan)/1e6);
        System.out.println("ms");
    }
}
