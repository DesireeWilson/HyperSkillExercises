package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        char[][] grid = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        String outputCells;
        String inputCells = "         ";
        int count = 1;
        char letter;

        printGrid(inputCells);

        while(true){
            System.out.print("Enter the coordinates: ");
            String coordInput = scanner.nextLine();
            letter = (count % 2 == 0) ? 'O' : 'X';
            outputCells = updateGridString(inputCells, coordInput, letter);

            if(outputCells.charAt(0) == 'X' || outputCells.charAt(0) == 'O' ||
                    outputCells.charAt(0) == ' ' || outputCells.charAt(0) == '_'){
                //check if someone won, if they did, break this loop
                inputCells = outputCells;
                if(isFinished(inputCells)){
                    if(isTheWinner(inputCells, 'X')){
                        printGrid(inputCells);
                        System.out.println("X wins");
                        break;
                    }else if(isTheWinner(inputCells, 'O')){
                        printGrid(inputCells);
                        System.out.println("O wins");
                        break;
                    }else{
                        printGrid(inputCells);
                        System.out.println("Draw");
                        break;
                    }
                }else{
                    count++;
                    printGrid(inputCells);
                }
            }
        }
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

    public static String updateGridString(String arg, String coordArg, char letter){
        String result = "";
        //check if the user typed numbers:
        if(!(coordArg.charAt(0) >= 48 && coordArg.charAt(2) <= 57)){
            result = "You should enter numbers!";
            System.out.println(result);
        }else{
            //obtaining coordinates:
            int xinput = Integer.valueOf(coordArg.charAt(0) % 48);
            int yinput = Integer.valueOf(coordArg.charAt(2) % 48);
            if(!(0 < yinput && yinput < 4) || !(0 < xinput && xinput < 4)){
                result = "Coordinates should be from 1 to 3!";
                System.out.println(result);
            }else{
                int x;
                int y;
                x = (yinput == 3) ? 0
                        :(yinput == 2) ? 1
                        :2;
                y = xinput - 1;

                //checking to see if there is an 'X' or an 'O':
                int charIndex = 3 * x + y;
                if(arg.charAt(charIndex) == 'X' || arg.charAt(charIndex) == 'O'){
                    result = "This cell is occupied! Choose another one!";
                    System.out.println(result);
                }else{
                    char[] charArray = arg.toCharArray();
                    charArray[charIndex] = letter;
                    result = toString(charArray);
                }
            }
        }
        return result;
    }

    public static String toString(char[] charArray){
        String string = new String(charArray);
        return string;
    }

    public static int numOfOccurrences(String arg, char charToCount){
        char charTocount = String.valueOf(charToCount).toUpperCase().charAt(0);
        int result = 0;
        for (char letter : arg.toUpperCase().toCharArray()) {
            if(letter == charToCount){
                result++;
            }
        }
        return result;
    }

    public static boolean isFinished(String arg){
        if(isTheWinner(arg, 'X') || isTheWinner(arg, 'O')){
            return true;
        }else if(numOfOccurrences(arg, ' ') == 0 &&
            numOfOccurrences(arg, '_') == 0){
            return true;
        }
        return false;
    }

    public static boolean horizontalWin(String arg, char charToCheck){
        char letter = String.valueOf(charToCheck).toUpperCase().charAt(0);
        for (int i = 0; i < 3; i++) {
            int index = 3 * i;
            if((2 * arg.charAt(index)) == (arg.charAt(index + 1) + arg.charAt(index + 2)) &&
                    (arg.charAt(index) + arg.charAt(index + 1) + arg.charAt(index + 2))/3 == letter){
                return true;
            }
        }
        return false;
    }

    public static boolean verticalWin(String arg, char charToCheck){
        char letter = String.valueOf(charToCheck).toUpperCase().charAt(0);
        for (int i = 0; i < 3; i++) {
            int index = i;
            if((2 * arg.charAt(index)) == (arg.charAt(index + 3) + arg.charAt(index + 6)) &&
                    (arg.charAt(index) + arg.charAt(index + 3) + arg.charAt(index + 6))/3 == letter){
                return true;
            }
        }
        return false;
    }

    public static boolean diagonalWin(String arg, char charToCheck){
        char letter = String.valueOf(charToCheck).toUpperCase().charAt(0);
        return (arg.charAt(4) == letter && (2 * arg.charAt(0) == (arg.charAt(4) + arg.charAt(8)) ||
                2 * arg.charAt(2) == (arg.charAt(4) + arg.charAt(6)))) ? true : false;
    }

    public static boolean isTheWinner(String arg, char charToCheck){
        return (horizontalWin(arg, charToCheck) || verticalWin(arg, charToCheck) ||
                diagonalWin(arg, charToCheck)) ? true : false;
    }

    public static boolean isDraw(String arg){
        return (!isTheWinner(arg, 'X') &&
                !isTheWinner(arg, 'O')) ? true : false;
    }

    public static boolean isPossible(String arg){
        if((Math.abs(numOfOccurrences(arg, 'X') - numOfOccurrences(arg, 'O'))) > 1){
            return false;
        }else if(isTheWinner(arg, 'X') && isTheWinner(arg, 'O')){
            return false;
        }else{
            return true;
        }
    }
}
