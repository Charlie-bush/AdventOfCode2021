package main.com.week1.day1;

import main.com.AdventUtils.Reader;
import java.util.List;

public class DayOne {

    private String result;

    private List<Integer> resultList() {
        Reader reader = new Reader("day1.txt");
        return reader.getIntegerList();
    }

    public void process(){
        List<Integer> lines = resultList();
        int temp =0;
        int count =0;
        for(int i=0; i < lines.size(); i++) {
            if (i + 2 > lines.size() - 1) break;

            if (lines.get(i)+lines.get(i+1)+lines.get(i+2) > temp) {
                count++;
            }
            temp = lines.get(i)+lines.get(i+1)+lines.get(i+2);
        }
        result = String.valueOf(count-1);
    }

    public String getResult() {
        return result;
    }
}
