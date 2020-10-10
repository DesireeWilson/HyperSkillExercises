import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();

        if(firstNum == secondNum || firstNum == thirdNum || secondNum == thirdNum){
            System.out.println("false");
        }else{
            System.out.println("true");
        }
    }
}