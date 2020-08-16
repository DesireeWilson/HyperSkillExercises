import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num;
        int sum = 0;


        while(true){
            num = scanner.nextInt();
            if(num == 0){
                break;
            }
            if(sum < 1000){
                sum += num;
            }
        }
        if(sum >= 1000){
            sum -= 1000;
        }
        System.out.println(sum);
    }
}