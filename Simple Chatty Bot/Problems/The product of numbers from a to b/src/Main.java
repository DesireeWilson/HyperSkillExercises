import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long startNumInclusive = scanner.nextInt();
        long endNumExclusive = scanner.nextInt();


        System.out.println(fun(startNumInclusive, endNumExclusive));
    }

    public static long fun(long start, long end){
        if(start == (end - 1)){
            return start;
        }else{
            return start * fun((start + 1), end);
        }
    }
}