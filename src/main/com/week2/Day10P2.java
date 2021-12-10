package main.com.week2;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.*;

public class Day10P2 implements AdventDay {
    private String result;

    private List<String> resultList(){
        Reader reader = new Reader("day10.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> resultList = resultList();
        List<Long> totalList = new ArrayList<>();
        for (String line: resultList) {
            Stack<Character> currentOpenBrackets = new Stack<>();
            char[] letters = line.toCharArray();
            boolean corruptedLine = false;
            for (char letter: letters) {
                switch (letter) {
                    case '(', '[', '{', '<' -> currentOpenBrackets.push(letter);
                    case ')', ']', '}', '>' -> {
                        if (currentOpenBrackets.pop()!=reverseOfBracket(letter)) {
                            corruptedLine =true;
                        }
                    }
                }
                if (corruptedLine) break;
            }
            if (!corruptedLine){
                totalList.add(scoreForLine(currentOpenBrackets));
            }
        }
        Collections.sort(totalList);
        int midPoint = (totalList.size()+1)/2;
        result = String.valueOf(totalList.get(midPoint-1));

    }

    private long scoreForLine(Stack<Character> currentOpenBrackets) {
        long currentScore =0;
        while(!currentOpenBrackets.isEmpty()) {
            switch (currentOpenBrackets.pop()) {
                case '(' -> currentScore=(currentScore*5) +1;
                case '[' -> currentScore=(currentScore*5) +2;
                case '{' -> currentScore=(currentScore*5) +3;
                case '<' -> currentScore=(currentScore*5) +4;
            }
        }
        return currentScore;
    }

    private char reverseOfBracket(char closeBracket) {
        return switch (closeBracket){
            case ')' -> '(';
            case ']' -> '[';
            case '>' -> '<';
            case '}' -> '{';
            default -> ' ';
        };
    }

    @Override
    public String getResult() {
        return result;
    }
}
