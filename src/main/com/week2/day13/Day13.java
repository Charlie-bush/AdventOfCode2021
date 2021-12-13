package main.com.week2.day13;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day13 implements AdventDay {
    private String result;

    private int totalDots;

    private List<String> resultList(){
        Reader reader = new Reader("day13.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> dots = resultList().subList(0, 908);
        totalDots = dots.size();
        List<String> folds = resultList().subList(909,resultList().size());

        List<Integer> dotXPosition = new ArrayList<>();
        List<Integer> dotYPosition = new ArrayList<>();
        for (String line: dots) {
            String[] values = line.split(",");
            dotXPosition.add(Integer.parseInt(values[0]));
            dotYPosition.add(Integer.parseInt(values[1]));
        }
        int numberOfFolds =folds.size();
        int magnitude;
        char direction;
        for (int i = 0; i < numberOfFolds; i++) {
            magnitude = Integer.parseInt(folds.get(i).split("=")[1]);
            direction = folds.get(i).split("along ")[1].charAt(0);
            switch (direction) {
                case 'x' -> dotXPosition = fold(dotXPosition, magnitude);
                case 'y' -> dotYPosition = fold(dotYPosition, magnitude);
            }
            dots.clear();
            for (int j =0; j < dotXPosition.size(); j++) {
                dots.add(dotXPosition.get(j)+ "," + dotYPosition.get(j));
            }
            List<String> distinct = dots.stream().distinct().collect(Collectors.toList());
            dots = distinct;
            totalDots = dots.size();
        }

        Collections.sort(dots);

        printList(dots);
        result = String.valueOf(totalDots);

    }

    private List<Integer> fold(List<Integer> dotsList, int magnitude) {
        List<Integer> dotsCopy = new ArrayList<>(dotsList);
        for (int i =0; i < dotsCopy.size(); i++) {
            if (dotsCopy.get(i) > magnitude) {
                int difference = dotsCopy.get(i)-magnitude;
                dotsList.set(i, magnitude - difference);
            }
        }
        return dotsList;
    }

    private void printList(List<String> listToPrint) {
        int maxHeight = 0, maxLength =0;
        for (String entry: listToPrint){
            if (Integer.valueOf(entry.split(",")[1])> maxHeight) {
                maxHeight = Integer.valueOf(entry.split(",")[1]);
            }
            if (Integer.valueOf(entry.split(",")[0]) > maxLength) {
                maxLength = Integer.valueOf(entry.split(",")[0]);
            }
        }
        char[][] instruction = new char[maxHeight+1][maxLength+1];
        for (int i = 0; i < maxHeight+1; i++) {
            for (int j =0; j <maxLength+1; j++) {
                instruction[i][j] = '-';
            }
        }
        for (String entry: listToPrint){
            instruction[Integer.valueOf(entry.split(",")[1])][Integer.valueOf(entry.split(",")[0])] = '#';
        }
        for (int i =0; i< maxHeight+1; i++) {
            System.out.println(String.valueOf(instruction[i]));
        }
    }



    @Override
    public String getResult() {
        return result;
    }
}
