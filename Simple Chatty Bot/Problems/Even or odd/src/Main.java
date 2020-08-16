import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = 1;

        while(num != 0){
            num = scanner.nextInt();
            if(num == 0){
                break;
            }
            System.out.println(oddOrEven(num));
        }
    }

    public static String oddOrEven(int num){
        if(num % 2 == 0){
            return "even";
        }else{
            return "odd";
        }
    }
}