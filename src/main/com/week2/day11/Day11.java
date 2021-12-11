package main.com.week2.day11;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.List;

public class Day11 implements AdventDay {
    private String result;

    private boolean[][] hasFlashed = new boolean[10][10];
    private boolean[][] willFlash = new boolean[10][10];
    private int numberOfFlashes = 0;

    private List<String> resultList(){
        Reader reader = new Reader("day11.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> resultList = resultList();
        int[][] energyArray = listToArrayConvert(resultList);
        int yBound = resultList.size(), xBound = resultList.get(0).length();
        int steps = 100;

        for (int i = 0; i<steps; i++) {
            for (int y = 0; y < yBound; y++) {
                for (int x = 0; x < xBound; x++) {
                    energyArray[y][x]++;
                    if (energyArray[y][x]>9){
                        willFlash[y][x] = true;
                    }
                }
            }
            while (containsATrueValue(willFlash)) {
                for (int y = 0; y < yBound; y++) {
                    for (int x = 0; x < xBound; x++) {
                        if (willFlash[y][x] && !hasFlashed[y][x]){
                            energyArray = flash(energyArray, y, x);
                            numberOfFlashes++;
                        }
                    }
                }
            }
            for (int y = 0; y < yBound; y++) {
                for (int x = 0; x < xBound; x++) {
                    if (hasFlashed[y][x]){
                        energyArray[y][x] = 0;
                    }
                }
            }
            resetBooleanArrays();
        }

        result = String.valueOf(numberOfFlashes);

    }

    private void resetBooleanArrays() {
        for (int i =0; i < 10; i++) {
            for (int j =0; j <10; j++) {
                hasFlashed[i][j] = false;
                willFlash[i][j] = false;
            }
        }
    }

    private int[][] flash(int[][] energyArray, int y, int x) {
        if (!(x-1<0)){
            if (!(y-1<0)) {
                energyArray[y-1][x-1]++;
                if (energyArray[y-1][x-1] >9 ) willFlash[y-1][x-1] = true;
            }
            if (!(y+1>=10)) {
                energyArray[y+1][x-1]++;
                if (energyArray[y+1][x-1] >9 ) willFlash[y+1][x-1] = true;
            }
            energyArray[y][x-1]++;
            if (energyArray[y][x-1] >9 ) willFlash[y][x-1] = true;
        }
        if (!(x+1>=10)) {
            if (!(y-1<0)) {
                energyArray[y-1][x+1]++;
                if (energyArray[y-1][x+1] >9 ) willFlash[y-1][x+1] = true;
            }
            if (!(y+1>=10)) {
                energyArray[y+1][x+1]++;
                if (energyArray[y+1][x+1] >9 ) willFlash[y+1][x+1] = true;
            }
            energyArray[y][x+1]++;
            if (energyArray[y][x+1] >9 ) willFlash[y][x+1] = true;
        }
        if (!(y-1<0)) {
            energyArray[y-1][x]++;
            if (energyArray[y-1][x] >9 ) willFlash[y-1][x] = true;
        }
        if (!(y+1>=10)) {
            energyArray[y+1][x]++;
            if (energyArray[y+1][x] >9 ) willFlash[y+1][x] = true;
        }
        hasFlashed[y][x] = true;
        return energyArray;
    }

    private boolean containsATrueValue(boolean[][] boolArray) {
        boolean containsATrue = false;
        for (int i =0; i < boolArray.length; i++) {
            for (int j = 0; j < boolArray[0].length; j++) {
                if (boolArray[i][j] && !hasFlashed[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] listToArrayConvert(List<String> resultList) {
        int[][] heightArray = new int[10][10];
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
