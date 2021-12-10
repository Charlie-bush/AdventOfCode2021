package main.com.week2;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Day10 implements AdventDay {
    private String result;

    private List<String> resultList(){
        Reader reader = new Reader("day10.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> resultList = resultList();
        List<Character> firstIllegalCharacters = new ArrayList<>();
        for (String line: resultList) {
            Stack<Character> currentOpenBrackets = new Stack<>();
            char[] letters = line.toCharArray();
            boolean finishedOnLine = false;
            int index = 0;
            for (char letter: letters) {
                switch (letter) {
                    case '(', '[', '{', '<' -> currentOpenBrackets.push(letter);
                    case ')', ']', '}', '>' -> {
                        if (currentOpenBrackets.pop()!=reverseOfBracket(letter)) {
                            firstIllegalCharacters.add(letter);

                            finishedOnLine =true;
                        }
                    }
                }
                index++;
                if (finishedOnLine) break;
            }
        }
        long total = 0;
        for (char illegalChars: firstIllegalCharacters){
            switch (illegalChars) {
                case ')' -> total+= 3;
                case ']' -> total+= 57;
                case '}' -> total+= 1197;
                case '>' -> total+= 25137;
            }
        }
        result = String.valueOf(total);

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
