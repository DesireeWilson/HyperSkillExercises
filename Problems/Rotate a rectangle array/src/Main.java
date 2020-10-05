import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int numRowsFirstMatrix = scanner.nextInt();
        int numColsFirstMatrix = scanner.nextInt();
        int[][] firstMatrix = new int[numRowsFirstMatrix][numColsFirstMatrix];
        int[][] outputMatrix;

        //reading in the numbers for the first matrix:
        for (int i = 0; i < numRowsFirstMatrix; i++) {
            for (int j = 0; j < numColsFirstMatrix; j++) {
                firstMatrix[i][j] = scanner.nextInt();
            }
        }

        outputMatrix = rotateMatrix(firstMatrix);
        printMatrix(outputMatrix);
    }

    public static int[][] rotateMatrix(int[][] matrix){
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[][] resultMatrix = new int[numCols][numRows];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int x = j;
                int y = (i == 0) ? matrix.length - 1 : matrix.length - 1 - i;
                resultMatrix[x][y] = matrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix){
        String output = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output += String.valueOf(matrix[i][j]) + " ";
            }
            output += "\n";
        }
        System.out.println(output);
    }
}