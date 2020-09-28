import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sizeI = 0;
        int sizeJ = 0;
        int swapI = 0;
        int swapJ = 0;

        sizeI = scanner.nextInt();
        sizeJ = scanner.nextInt();

        int[][] matrix = new int[sizeI][sizeJ];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        swapI = scanner.nextInt();
        swapJ = scanner.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            //System.out.println(matrix[i]);
            int placeholder = matrix[i][swapI];
            matrix[i][swapI] = matrix[i][swapJ];
            matrix[i][swapJ] = placeholder;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}