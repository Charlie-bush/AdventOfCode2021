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
        int count =0;
        for(int i=1; i < lines.size(); i++) {
            if (i + 2 > lines.size() - 1) break;

            if(lines.get(i-1) < lines.get(i+2)) {
                count++;
            }
        }
        result = String.valueOf(count);
    }

    public String getResult() {
        return result;
    }
}
