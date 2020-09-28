import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String arraySize = "";
        String stringArg = "";
        String[] stringArray;
        String limit = "";
        int sum = 0;

        arraySize = scanner.nextLine();
        stringArg = scanner.nextLine();
        limit = scanner.nextLine();
        stringArray = new String[Integer.valueOf(arraySize)];
        stringArray = stringArg.split(" ");



        for (String num : stringArray) {
            if(Integer.valueOf(num) > Integer.valueOf(limit)){
                sum += Integer.valueOf(num);
            }
        }
//        System.out.println(stringArg);
//        System.out.println(Arrays.toString(stringArray));
//        System.out.println(limit);
        System.out.println(sum);
    }
}