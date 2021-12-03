package main.com.week1.day3;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DayThreePartTwo implements AdventDay {

    private String result;

    private List<String> resultList(){
        Reader reader = new Reader("day3.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> resultListGamma = resultList();
        int digitIndex =0, count =0;
        while(resultListGamma.size()>1) {
            for(String line: resultListGamma) {
                char[] binaryArray = line.toCharArray();
                if(binaryArray[digitIndex]=='1') {
                    count++;
                }
            }

            if (count >= Math.ceil((float)resultListGamma.size()/2)) {
                List<String> toRemove = new ArrayList<>();
                for(String line: resultListGamma) {
                    char[] binaryArray = line.toCharArray();
                    if(binaryArray[digitIndex]=='0') {
                        toRemove.add(line);
                    }
                }
                resultListGamma.removeAll(toRemove);
            } else {
                List<String> toRemove = new ArrayList<>();
                for(String line: resultListGamma) {
                    char[] binaryArray = line.toCharArray();
                    if(binaryArray[digitIndex]=='1') {
                        toRemove.add(line);
                    }
                }
                resultListGamma.removeAll(toRemove);
                toRemove.clear();
            }
            digitIndex++;
            count=0;
        }
        count=0;
        digitIndex=0;
        List<String> resultListEpsilon = resultList();
        while(resultListEpsilon.size()>1) {
            for(String line: resultListEpsilon) {
                char[] binaryArray = line.toCharArray();
                if(binaryArray[digitIndex]=='1') {
                    count++;
                }
            }
            if (count >= Math.ceil((float)resultListEpsilon.size()/2)) {
                List<String> toRemove = new ArrayList<>();
                for(String line: resultListEpsilon) {
                    char[] binaryArray = line.toCharArray();
                    if(binaryArray[digitIndex]=='1') {
                        toRemove.add(line);
                    }
                }
                resultListEpsilon.removeAll(toRemove);
            } else {
                List<String> toRemove = new ArrayList<>();
                for(String line: resultListEpsilon) {
                    char[] binaryArray = line.toCharArray();
                    if(binaryArray[digitIndex]=='0') {
                        toRemove.add(line);
                    }
                }
                resultListEpsilon.removeAll(toRemove);
            }
            digitIndex++;
            count=0;
        }
        String gamma = resultListGamma.get(0), epsilon = resultListEpsilon.get(0);

        result = String.valueOf(Integer.parseInt(gamma,2) * Integer.parseInt(epsilon,2));
    }

    @Override
    public String getResult() {
        return result;
    }
}
