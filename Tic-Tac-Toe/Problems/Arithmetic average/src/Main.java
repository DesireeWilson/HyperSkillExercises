import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        double leftBoundNum = Double.valueOf(scan.nextLine());
        double rightBoundNum = Double.valueOf(scan.nextLine());

        double result = avergeOfNumsInInterval(leftBoundNum, rightBoundNum);
        System.out.println(result);
    }

    public static double avergeOfNumsInInterval(double leftBoundNum, double rightBoundNum){
        int numOfNumbers = 0;
        double sum = 0;
        for(double num = leftBoundNum; num <= rightBoundNum; num++){
            if(num % 3.0 == 0){
                numOfNumbers++;
                sum += num;
            }
        }
        if(numOfNumbers > 0){
            return sum / numOfNumbers;
        }else{
            return 0;
        }
    }
}