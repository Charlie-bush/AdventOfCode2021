package main.com.week1.day4;

import main.com.AdventUtils.AdventDay;
import main.com.AdventUtils.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class DayFourPartTwo implements AdventDay {
    private String result;

    private List<String> resultList(){
        Reader reader = new Reader("day4.txt");
        return reader.getStringList();
    }

    @Override
    public void process() {
        List<String> resultList = resultList();
        String[] bingoNumbers = resultList.get(0).split(",");
        resultList.remove(0);
        HashMap<Integer, int[][]> mapOfTables = convertToHashmap(resultList);
        HashMap<Integer, int[][]> binaryMap = new HashMap<>();
        boolean noBingo = true;
        int winnerOfBingo = 0, digitIndex =0, winningNumber =0;
        while (noBingo) {
            for (int i=0; i < mapOfTables.size(); i++) {
                int[][] matrix = mapOfTables.get(i);
                int[][] binaryMatrix = binaryMap.getOrDefault(i, new int[5][5]);
                for (int j =0; j< 5; j++){
                    for (int k =0; k< 5; k++){
                        if(matrix[j][k]==Integer.parseInt(bingoNumbers[digitIndex])){
                            binaryMatrix[j][k] = 1;
                        }
                    }
                }
                binaryMap.put(i, binaryMatrix);
                if(isBingo(binaryMatrix)) {
                    winnerOfBingo = i;
                    winningNumber = Integer.parseInt(bingoNumbers[digitIndex]);
                }
                noBingo = !areWeDone(binaryMap);
                if (noBingo==false){
                    break;
                }
            }
            if (noBingo==false){
                break;
            }
            digitIndex++;
        }
        int[][] winningMatrix = mapOfTables.get(winnerOfBingo);
        int[][] binaryWinningMatrix = binaryMap.get(winnerOfBingo);
        int sumFromMatrix =0;
        for (int i =0; i<5;i++){
            for (int j =0; j < 5; j++){
                sumFromMatrix += (1-binaryWinningMatrix[i][j]) * winningMatrix[i][j];
            }
        }
        result=String.valueOf(sumFromMatrix*winningNumber);

    }

    public boolean areWeDone(HashMap<Integer, int[][]> binaryMap){
        boolean answer = false;
        for(int i =0; i< binaryMap.size(); i++){
            if (isBingo(binaryMap.get(i))) {
                answer =true;
            } else {
                return false;
            }
        }
        return answer;
    }

    public boolean isBingo(int[][] matrix) {
        for (int i =0; i<5; i++){
            int[] vert = matrix[i];
            if (IntStream.of(vert).sum() ==5) {
                return true;
            } else if(matrix[0][i]+matrix[1][i]+matrix[2][i]+matrix[3][i]+matrix[4][i]==5){
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, int[][]> convertToHashmap(List<String> matrixList) {
        List<String> empty = new ArrayList<>();
        empty.add("");
        matrixList.removeAll(empty);
        HashMap<Integer, int[][]> matrixHolder = new HashMap<>();
        for (int i = 0; i<matrixList.size()/5; i++){
            int[][] matrix = new int[5][5];
            for (int k=0; k<5; k++) { // x direction
                String[] numbers = matrixList.get(i*5+k).strip().replaceAll("  ", " ").replace(' ', ',').split(",");
                for (int j =0; j<5; j++){ // y direction
                    matrix[k][j] = Integer.parseInt(numbers[j]);
                }
            }
            matrixHolder.put(i, matrix);
        }
        return matrixHolder;
    }

    @Override
    public String getResult() {
        return result;
    }
}
