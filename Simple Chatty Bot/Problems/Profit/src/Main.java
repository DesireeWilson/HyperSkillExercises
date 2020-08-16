import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        double p = scanner.nextDouble() / 100;
        double k = scanner.nextDouble();
        int count = 0;

        System.out.println(counter(m, p, k, count));
    }

    public static int counter(double money, double percent, double goal, int count){
        if(money >= goal){
            return count;
        }else{
            money *= (1 + percent);
            //System.out.println(money + ", " + count);
            return counter(money, percent, goal, count + 1);
        }
    }
}