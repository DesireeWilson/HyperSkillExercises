import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String arraySize;
        String stringArg;
        int indexOfMaxNum = 0;
        int maxNum = 0;

        arraySize = scanner.nextLine();
        stringArg = scanner.nextLine();
        String[] stringArray = new String[Integer.valueOf(arraySize)];

        stringArray = stringArg.split(" ");


        for (int i = 0; i < Integer.valueOf(arraySize); i++) {
            if(Integer.valueOf(stringArray[i]) > maxNum){
                maxNum = Integer.valueOf(stringArray[i]);
                indexOfMaxNum = i;
            }
        }
        System.out.println(indexOfMaxNum);
    }
}