import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String ticketDigits = scanner.nextLine();
        String firstHalf = ticketDigits.substring(0,3);
        String secondHalf = ticketDigits.substring(3,ticketDigits.length());
        int sumFirstHalf = firstHalf.chars()
                .reduce(0, (subtotal, element) -> subtotal + element % 48 ); // '0' equals the numeric value'
        int sumSecondHalf = secondHalf.chars()
                .reduce(0, (subtotal, element) -> subtotal + element % 48 ); // '0' equals the numeric value'
        String outcome = (sumFirstHalf == sumSecondHalf) ? "Lucky" : "Regular";
        System.out.println(outcome);
    }
}