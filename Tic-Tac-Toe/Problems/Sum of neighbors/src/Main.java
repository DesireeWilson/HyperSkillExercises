import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        //read in numbers:
        int[][] inputMatrix = readInNumbers(scanner);

        //creating output matrix:
        int rowSize = inputMatrix.length;
        int colSize = inputMatrix[0].length;
        int[][] outputMatrix = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                outputMatrix[i][j] = calculateSumOfNeighbors(i, j, inputMatrix);
            }
        }

        //printing the output matrix:
        printMatrix(outputMatrix);

//        //printing the input matrix:
//        printMatrix(inputMatrix);
    }
    public static int[][] readInNumbers(Scanner scanner){
        String input = "", rows = "";
        int numOfRows = 0, numOfCols = 0;
        while(true){
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("end")){
                break;
            }
            rows += input;
            numOfRows++;
            rows += ",";
        }
        String[] rowsArray = rows.split(",");
        numOfCols = rowsArray[0].split(" ").length;
        int[][] resultMatrix = new int[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            String row = rowsArray[i];
            String[] elements = row.split(" ");
            for (int j = 0; j < numOfCols; j++) {
                resultMatrix[i][j] = Integer.valueOf(elements[j]);
            }
        }
        return resultMatrix;
    }

    public static int calculateSumOfNeighbors(int row, int col, int[][] matrix){
        int result, previousRow, nextRow, previousCol, nextCol;
        previousRow = (row - 1 >= 0) ? row - 1 : matrix.length - 1;
        nextRow = (row + 1 < matrix.length) ? row + 1 : 0;
        previousCol = (col - 1 >= 0) ? col - 1 : matrix[row].length - 1;
        nextCol = (col + 1 < matrix[row].length) ? col + 1: 0;
        result = matrix[previousRow][col] + matrix[nextRow][col] +
                matrix[row][previousCol] + matrix[row][nextCol];
        return result;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        };
    }
}