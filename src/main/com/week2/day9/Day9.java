package main.com.week2.day9;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.ArrayList;
import java.util.List;

public class Day9 implements AdventDay {
    private String result;

    private List<String> resultList(){
        Reader reader = new Reader("day9.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> resultList = resultList();
        int[][] heightArray = listToArrayConvert(resultList);
        int yBound = resultList.size();
        int xBound = resultList.get(0).length();
        List<Integer> lowPoints = new ArrayList<>();
        for(int y = 0; y < yBound; y++){
            for (int x = 0; x < xBound; x++) {
                boolean isLowest = true;
                if (!(x-1<0)){
                    isLowest = heightArray[y][x] < heightArray[y][x-1];
                }
                if (!(y-1<0) && isLowest) {
                    isLowest = heightArray[y][x] < heightArray[y-1][x];
                }
                if (!(x+1>=xBound) && isLowest) {
                    isLowest = heightArray[y][x] < heightArray[y][x+1];
                }
                if (!(y+1>=yBound) && isLowest) {
                    isLowest = heightArray[y][x] < heightArray[y+1][x];
                }
                if (isLowest) {
                    lowPoints.add(heightArray[y][x]);
                }
            }
        }
        int total =0;
        for (int lowPoint: lowPoints) {
            total+=lowPoint+1;
        }
        result = String.valueOf(total);

    }

    private int[][] listToArrayConvert(List<String> resultList) {
        int[][] heightArray = new int[resultList.size()][resultList.get(0).length()];
        int xPos, yPos =0;
        for (String line: resultList){
            xPos=0;
            for (char digit: line.toCharArray()){
                heightArray[yPos][xPos] = Character.digit(digit, 10);
                xPos++;
            }
            yPos++;
        }

        return heightArray;
    }

    @Override
    public String getResult() {
        return result;
    }
}
