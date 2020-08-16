import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        if(x1 == x2 || y1 == y2){
            System.out.println("YES");
        }else{
            double slope = ((y2-y1) / (x2 - x1));
            if(Math.abs(slope) == 1.0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}