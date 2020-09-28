import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int maxProduct = 0;
        String arraySize = "";
        String arg = "";
        String[] stringArray;


        arraySize = scanner.nextLine();
        arg = scanner.nextLine();
        stringArray = arg.split(" ");


        for(int i = 0; i <= stringArray.length - 2; i++){
            int num1 = Integer.valueOf(stringArray[i]);
            int num2 = Integer.valueOf(stringArray[i + 1]);
            if((num1 * num2) > maxProduct){
                maxProduct = num1 * num2;
            }
        }
        System.out.println(maxProduct);
    }
}