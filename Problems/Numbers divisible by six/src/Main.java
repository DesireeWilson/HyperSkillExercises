import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int numOfElements = scanner.nextInt();
        for (int i = 0; i < numOfElements; i++) {
            int num = scanner.nextInt();
            sum += (num % 6 == 0) ? num : 0;
        }
        System.out.println(sum);
    }
}