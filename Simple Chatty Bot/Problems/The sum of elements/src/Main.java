import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        int sum = 0;

        while(num != 0){
            num = scanner.nextInt();
            if(num == 0){
                break;
            }
            sum += num;
        }
        System.out.println(sum);
    }
}