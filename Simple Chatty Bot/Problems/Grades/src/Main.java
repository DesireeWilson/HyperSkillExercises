import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int acount = 0;
        int bcount = 0;
        int ccount = 0;
        int dcount = 0;
        int gradeLimit = 0;
        int grade = 0;
        Scanner scanner = new Scanner(System.in);

        gradeLimit = scanner.nextInt();
        for (int i = 0; i < gradeLimit; i++) {
            grade = scanner.nextInt();
            if(grade == 5){
                acount++;
            }else if(grade == 4){
                bcount++;
            }else if(grade == 3){
                ccount++;
            }else{
                dcount++;
            }
        }
        System.out.println(dcount + " " +
                           ccount + " " +
                           bcount + " " +
                           acount);
    }
}