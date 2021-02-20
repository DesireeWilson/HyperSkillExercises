package cinema;

import java.util.Scanner;

public class UI {
    //fields:
    private Scanner scanner;
    private Cinema cinema;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void buyTicketPrompt() {
        int rowNum = -1;
        int colNum = -1;
        while(cinema.outOfRange(rowNum, colNum) || cinema.alreadyPurchased(rowNum, colNum)) {
            System.out.println("Enter a row number:");
            rowNum = scanner.nextInt();
            System.out.println("Enter a seat number in that row: ");
            colNum = scanner.nextInt();
            if(!cinema.outOfRange(rowNum, colNum) && !cinema.alreadyPurchased(rowNum, colNum)) {
                break;
            }else if(cinema.outOfRange(rowNum, colNum)) {
                System.out.println("Wrong input!");
            }else {
                System.out.println("That ticket has already been purchased!");
            }
        }
        cinema.buyTicket(rowNum, colNum);
        cinema.updateSeatingArrangement(rowNum, colNum);
        System.out.printf("Ticket price: $%d\n\n", cinema.getTicketPrice(rowNum, colNum));
    }

    public void printUIMenu() {
        String output = "1. Show the seats\n" +
                        "2. Buy a ticket\n" +
                        "3. Statistics\n" +
                        "0. Exit";
        System.out.println(output);
        System.out.println();
    }

    public void printSeatingArrangment(){
        cinema.printSeatingArrangement();
    }

    public void printStatisticsPrompt() {
        String output = "Number of purchased tickets: %d\n" +
                        "Percentage: %.2f%\n" +
                        "Current income: $%d\n" +
                        "Total income: $%d\n\n";
        int tickets = cinema.getNumberOfTicketsSold();
        double percentage = cinema.calculatePercentage();
        int currentIncome = cinema.getIncome();
        int totalIncome = cinema.calculateProfit();
//        System.out.println("Number of purchased tickets: " +tickets);
//        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
//        System.out.println("Current income: $" + currentIncome);
//        System.out.println("Total income: $" + totalIncome);
        System.out.printf("Number of purchased tickets: %d\n" +
                          "Percentage: %.2f%%\n" +
                          "Current income: $%d\n" +
                          "Total income: $%d\n\n"
                          , tickets, percentage, currentIncome, totalIncome);
    }

    public void printTicketPricePrompt(){
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int colNum = scanner.nextInt();
        if(rowNum <= cinema.getNumOfRows() && rowNum >= 0 &&
                colNum <= cinema.getNumOfSeatsPerRow() && colNum >= 0) {
            System.out.printf("Ticket price: $%d\n\n", cinema.getTicketPrice(rowNum, colNum));
            cinema.updateSeatingArrangement(rowNum, colNum);
        }else {
            System.out.println("Wrong input!");
        }
    }

    public void setCinema(Scanner scanner) {
        System.out.println("Enter the number of rows:");
        int numOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int numOfSeatsPerRow = scanner.nextInt();
        this.cinema = new Cinema(numOfRows, numOfSeatsPerRow);
        System.out.println();
    }

    public void uiMenu(Scanner scanner) {
        setCinema(scanner);
        int selection = -1;
        while(selection != 0) {
            printUIMenu();
            selection = scanner.nextInt();
            switch (selection) {
                case 0:
                    break;
                case 1:
                    printSeatingArrangment();
                    break;
                case 2:
                    buyTicketPrompt();
                    break;
                case 3:
                    printStatisticsPrompt();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }



}
