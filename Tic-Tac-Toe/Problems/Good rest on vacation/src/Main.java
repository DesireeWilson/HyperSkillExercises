import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cost = vacationCost(scanner);
        System.out.println(cost);


    }
    public static int vacationCost(Scanner scanner){
        int numOfDays = scanner.nextInt();
        int foodCostPerDay = scanner.nextInt();
        int flightOneWay = scanner.nextInt();
        int hotelCostPerNight = scanner.nextInt();

        int cost = (numOfDays * foodCostPerDay) + (2 * flightOneWay) +
                (hotelCostPerNight * (numOfDays - 1));
        return cost;
    }
}