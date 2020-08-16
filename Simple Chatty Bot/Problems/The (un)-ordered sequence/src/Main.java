import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = 1;
        int ascendingCount = 0;
        int descendingCount = 0;

        if(num1 == 0){
            System.out.println("true");
        }else{
            while(true){
                num2 = scanner.nextInt();
                if(num1 == 0 || num2 == 0){
                    break;
                }
                if(ascending(num1, num2)){
                    ascendingCount++;
                }else if(descending(num1, num2)){
                    descendingCount++;
                }else {
                    continue;
                }
                num1 = num2;
            }
            if(ascendingCount == 0 && descendingCount == 0){
                System.out.println("true");
            }else if(ascendingCount > 0 && descendingCount == 0){
                System.out.println("true");
            }else if(descendingCount > 0 && ascendingCount == 0){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }

    public static boolean ascending(int num1, int num2){
        if(num2 > num1){
            return true;
        }
        return false;
    }

    public static boolean descending(int num1, int num2){
        if(num2 < num1){
            return true;
        }
        return false;
    }


}