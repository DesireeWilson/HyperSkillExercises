import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numLimit = scanner.nextInt();

        int perfectSquare = 1;
        int count = 1;
        while(perfectSquare <= numLimit){
            perfectSquare = count * count;
            if(perfectSquare > numLimit){
                break;
            }
            System.out.println(perfectSquare);
            count++;
        }
    }
}