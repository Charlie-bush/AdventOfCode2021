package main.com.week1.day3;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.HashMap;
import java.util.List;

public class DayThree implements AdventDay {

    private String result;

    private List<String> resultList(){
        Reader reader = new Reader("day3.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        HashMap<Integer, Integer> dictionary = new HashMap<>();
        List<String> resultList = resultList();
        for(String line: resultList) {
            char[] binaryArray = line.toCharArray();
            for(int i = 0; i < binaryArray.length; i++) {
                if(binaryArray[i]=='1'){
                    dictionary.put(i, dictionary.getOrDefault(i, 0) +1);
                }
            }
        }
    StringBuilder gamma = new StringBuilder(), epsilon = new StringBuilder();
        for (int i=0; i < dictionary.size(); i++){
            if (dictionary.get(i) > (resultList.size()/2)) {
                gamma.append('1');
                epsilon.append('0');
            } else {
                gamma.append('0');
                epsilon.append('1');
            }
        }
        result = String.valueOf(Integer.parseInt(gamma.toString(),2) * Integer.parseInt(epsilon.toString(),2));
    }

    @Override
    public String getResult() {
        return result;
    }
}
