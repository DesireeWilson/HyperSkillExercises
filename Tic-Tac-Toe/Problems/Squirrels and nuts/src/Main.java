import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int numSquirrels = scanner.nextInt();
        int numNuts = scanner.nextInt();

        System.out.println(numNuts % numSquirrels);
    }
}