import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long firstNumber = scanner.nextLong();
        char operation = scanner.next().charAt(0);
        long secondNumber = scanner.nextLong();

        switch(operation){
            case '+':
                System.out.println(firstNumber + secondNumber);
                break;
            case '-':
                System.out.println(firstNumber - secondNumber);
                break;
            case '/':
                if(secondNumber == 0){
                    System.out.println("Division by 0!");
                }else{
                    System.out.println(firstNumber / secondNumber);
                }
                break;
            case '*':
                System.out.println(firstNumber * secondNumber);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}