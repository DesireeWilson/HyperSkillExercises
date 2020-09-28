package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        char[][] grid = new char[4][3];
//        System.out.println(grid.length);
//        System.out.println(grid[0].length);
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length ; j++) {
//                if(i % 2 == 0 && j % 2 == 0){
//                    grid[i][j] = 'O';
//                }else{
//                    grid[i][j] = 'X';
//                }
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printGrid(input);
    }

    public static void printGrid(String arg){
        char[][] grid = new char[3][3];
        String topOrBottom = "---------";
        String side = "|";
        String output = topOrBottom + "\n";
        int index = 0;
        for(int i = 0; i < grid.length; i++){
            String row = side + " ";
            for(int j = 0; j < grid[i].length; j++){
                if(j == 2){
                    row += arg.charAt(index) + " " + side + "\n";
                }else{
                    row += arg.charAt(index) + " ";
                }
                index++;
            }
            output += row;
        }
        output += topOrBottom;
        System.out.println(output);
    }
}
