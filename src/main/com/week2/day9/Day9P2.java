package main.com.week2.day9;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day9P2 implements AdventDay {
    private String result;

    private List<Integer> basinLengths = new ArrayList<>();
    private int currentBasinLength = 0;

    private List<String> resultList(){
        Reader reader = new Reader("day9.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> resultList = resultList();
        List<String> freshList = new ArrayList<>();
        for (String line: resultList){
             freshList.add(line.replaceAll("8","7").replaceAll("7","6").replaceAll("6","5").replaceAll("5","4").replaceAll("4","3").replaceAll("3","2").replaceAll("2","1").replaceAll("0","1").replaceAll("9","0"));
        }
        int[][] easyArray = listToArrayConvert(freshList);
        for (int i =0; i<100; i++) {
            for (int j = 0; j<100; j++){
                if (easyArray[i][j]==1) {
                    currentBasinLength =0;
                    easyArray = clearBasin(easyArray, i, j);
                    basinLengths.add(currentBasinLength);
                    currentBasinLength =0;
                }
            }
        }
        Collections.sort(basinLengths);

        int listSize = basinLengths.size();
        result = String.valueOf(basinLengths.get(listSize-1)*basinLengths.get(listSize-2)*basinLengths.get(listSize-3));

    }

    private int[][] clearBasin(int[][] oldArray, int x, int y) {
        int[][] newArray = oldArray;
        newArray[x][y] = 0;
        currentBasinLength++;
        if (!(x-1<0)){
            if (newArray[x-1][y]==1){
                newArray[x-1][y]=0;
                clearBasin(newArray, x-1,y);
            }
        }
        if (!(y-1<0)) {
            if (newArray[x][y-1]==1){
                newArray[x][y-1]=0;
                clearBasin(newArray, x,y-1);
            }
        }
        if (!(x+1>=100)) {
            if (newArray[x+1][y]==1){
                newArray[x+1][y]=0;
                clearBasin(newArray, x+1,y);
            }
        }
        if (!(y+1>=100)) {
            if (newArray[x][y+1]==1){
                newArray[x][y+1]=0;
                clearBasin(newArray, x,y+1);
            }
        }
        return newArray;
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

    public class Tuple {
        public final int x;
        public final int y;

        public Tuple(int x, int y) {
            this.x =x;
            this.y =y;
        }
    }
}
