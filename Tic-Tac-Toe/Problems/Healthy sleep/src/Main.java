import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        String output = (a <= h && h <= b) ? "Normal"
                : (h < a) ? "Deficiency"
                : "Excess";
        System.out.println(output);
    }
}