import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rowSize = n * n;
        int colSize = rowSize;
        int[][] sudokuMatrix = new int[rowSize][colSize];
        String output = "YES";

        createSudokuGrid(sudokuMatrix, scanner);


        if(n != 1){
            for (int rowIndex = 0; rowIndex < (n * n); rowIndex++) {
                for (int num = 1; num <= (n * n); num++) {
                    int[] row = getRow(rowIndex, sudokuMatrix);
                    int colIndex = numIndex(num, row);
                    if(colIndex == -1){
                        output = "NO";
                        break;
                    }
                    int[] col = getColumn(colIndex, sudokuMatrix);
                    if(rowIndex % n != 0){
                        if(numCount(num, row) == 1 && numCount(num, col) == 1){
                            continue;
                        }else{
                            output = "NO";
                            break;
                        }
                    }else{
                        int[][] subMatrix = getSubMatrix(n, rowIndex, colIndex, sudokuMatrix);
                        if(numCount(num, row) == 1 && numCount(num, col) == 1 &&
                                numCount(num, subMatrix) == 1){
                            continue;
                        }else{
                            output = "NO";
                            break;
                        }
                    }
                }
            }
        }else if(sudokuMatrix[0][0] != 1){
            output = "NO";
        }
        System.out.println(output);
    }


    public static int[][] createSudokuGrid(int[][] matrix, Scanner scanner){
        int numOfRows = matrix.length;
        int numOfCols = matrix[0].length;
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[] getRow(int index, int[][] matrix){
        int[] row = matrix[index];
        return row;
    }

    public static int[] getColumn(int index, int[][] matrix){
        int[] column = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            column[i] = matrix[i][index];
        }
        return column;
    }

    public static int[][] getSubMatrix(int n, int rowNum, int index, int[][] matrix){
        int[][] subMatrix = new int[n][n];
        //int count = 1;
        int rowMultiplier = 1;
        int colMultiplier = 1;
        int lowerRowIndex = 0;
        int lowerColIndex = 0;
        while(rowNum > rowMultiplier * n){
            rowMultiplier++;
        }
        while(index > colMultiplier * n){
            colMultiplier++;
        }
        if(rowMultiplier != 0 && rowNum != 0){
            if((rowMultiplier * n) % rowNum == 0 && rowNum != 1){
                lowerRowIndex = rowMultiplier * n;
            }else {
                lowerRowIndex = (rowMultiplier - 1) * n;
            }
        }
        if(colMultiplier != 0 && index != 0){
            if((colMultiplier * n) % index == 0 && index != 1){
                lowerColIndex = colMultiplier * n;
            }else {
                lowerColIndex = (colMultiplier - 1) * n;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                subMatrix[i][j] = matrix[lowerRowIndex + i][lowerColIndex + j];
            }
        }
        return subMatrix;
    }

    public static int numIndex(int num, int[] array){
        int index = 0;
        for (int number : array) {
            if(number == num){
                return index;
            }
            index++;
        }
        return -1;
    }

    //for row and column
    public static int numCount(int num, int[] array){
        int count = 0;
        for (int number : array) {
            if(number == num){
                count++;
            }
        }
        return count;
    }

    //for matrix
    public static int numCount(int num, int[][] matrix){
        int count = 0;
        for (int[] array : matrix) {
            for (int number : array) {
                if(number == num){
                    count++;
                }
            }
        }
        return count;
    }
}