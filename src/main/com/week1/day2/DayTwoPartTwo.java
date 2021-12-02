package main.com.week1.day2;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.List;

public class DayTwoPartTwo implements AdventDay {

    private String result;

    private List<String> resultList() {
        Reader reader = new Reader("day2.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> lines = resultList();
        int horizontal =0, aim =0, magnitude, depth = 0;
        char direction;
        for(String line: lines) {
            String[] vector = line.split(" ");
            direction = vector[0].toCharArray()[0];
            magnitude = Integer.parseInt(vector[1]);

            switch (direction) {
                case 'f' -> {
                    horizontal += magnitude;
                    depth += magnitude * aim;
                }
                case 'u' -> aim -= magnitude;
                case 'd' -> aim += magnitude;
                default -> {
                }
            }
        }
        result = String.valueOf(depth*horizontal);
    }

    @Override
    public String getResult() {
        return result;
    }
}
