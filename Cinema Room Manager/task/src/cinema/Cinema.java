package cinema;

import java.util.Scanner;

public class Cinema {
    //states:
    private int numOfRows;
    private int numOfSeatsPerRow;
    private char[][] seating;
    private int income;
    private int numOfSeatsSold;


    //behaviors:
    public Cinema(int numOfRows, int numOfSeatsPerRow){
        this.numOfRows = numOfRows;
        this.numOfSeatsPerRow = numOfSeatsPerRow;
        initializeSeating(numOfRows, numOfSeatsPerRow);
    }

    public boolean alreadyPurchased(int rowNum, int colNum) {
        boolean result = false;
        if(seating[rowNum - 1][colNum - 1] == 'B') {
            result = true;
        }
        return result;
    }

    public void buyTicket(int rowNum, int colNum) {
        if(isAvailable(rowNum, colNum)) {
            income += getTicketPrice(rowNum, colNum);
            numOfSeatsSold++;
        }else {
            System.out.println("That ticket has already been purchased!");
        }
    }

    public int calculateProfit() {
        int result = 0;
        int totalNumOfSeats = numOfRows * numOfSeatsPerRow;

        if(totalNumOfSeats <= 60) {
            result = 10 * numOfRows * numOfSeatsPerRow;
        } else {
            result = (10 * (numOfRows/2) * numOfSeatsPerRow) +
                    (8 * ((1 + numOfRows)/2) * numOfSeatsPerRow);
        }
        return result;
    }

    public double calculatePercentage() {
        return 100.0 * ((1.0 * numOfSeatsSold ) / (numOfRows * numOfSeatsPerRow));
    }

    public int getIncome() {
        return income;
    }

    public int getNumberOfTicketsSold() {
        return numOfSeatsSold;
    }

    public int getNumOfRows() {
        return this.numOfRows;
    }

    public int getNumOfSeatsPerRow() {
        return this.numOfSeatsPerRow;
    }

    public int getTicketPrice(int rowNum, int colNum) {
        int cost = 0;
        int totalNumOfSeats = this.numOfRows * this.numOfSeatsPerRow;
        cost = totalNumOfSeats <= 60 ? 10
                : (rowNum - 1) < (numOfRows/2) ? 10
                : 8;
        return cost;
    }

    private void initializeSeating(int numOfRows, int numOfSeatsPerRow) {
        this.seating = new char[numOfRows][numOfSeatsPerRow];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfSeatsPerRow; j++) {
                seating[i][j] = 'S';
            }
        }
    }

    public boolean isAvailable(int rowNum, int colNum){
        return seating[rowNum - 1][colNum - 1] == 'S' ? true : false;
    }

    public boolean outOfRange(int rowNum, int colNum) {
        boolean result = false;
        if(rowNum <= 0 || rowNum > this.numOfRows || colNum <= 0 ||
                colNum > this.numOfSeatsPerRow) {
            result = true;
        }
        return result;
    }

    public void printSeatingArrangement() {
        String titleRow = "Cinema:\n";
        String theFirstRow = " ";
        String theRow = "";
        String theResult = "";

        for (int i = 1; i <= this.numOfSeatsPerRow; i++) {
            theFirstRow += " " + i;
        }
        theFirstRow += "\n";
        theResult += titleRow + theFirstRow;
        for (int i = 0; i < this.numOfRows; i++) {
            theRow += i+1;
            for (int j = 0; j < this.numOfSeatsPerRow; j++) {
                theRow += " " + this.seating[i][j];
            }
            theRow += "\n";
            theResult += theRow;
            theRow = "";
        }
        System.out.println(theResult);
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public void setNumOfSeatsPerRow(int numOfSeatsPerRow) {
        this.numOfSeatsPerRow = numOfSeatsPerRow;
    }

    public void updateSeatingArrangement(int rowNum, int colNum) {
        if(isAvailable(rowNum, colNum)) {
            seating[rowNum - 1][colNum - 1] = 'B';
        }
    }

}