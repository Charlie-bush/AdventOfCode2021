package main.com.AdventUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private String filePath = " ";
    private List<String> stringList;
    private List<Integer> integerList = new ArrayList<>();

    public Reader(String filePath) {
        this.filePath = "src/main/resources/" + filePath;
        readFile();
    }

    private void readFile() {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString() + " was caught");
        }
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public List<Integer> getIntegerList() {
        for (String line : stringList) {
            integerList.add(Integer.parseInt(line));
        }
        return integerList;
    }

}
