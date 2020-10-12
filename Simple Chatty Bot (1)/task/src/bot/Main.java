package bot;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String seqToCompress = scanner.nextLine().toLowerCase();
        String compressedSeq = "";
        int count = 1;
        int lastIndex = seqToCompress.length() - 1;
        int secondToLastIndex = seqToCompress.length() - 2;
        if(seqToCompress.length() == 0){
            compressedSeq = "0";
        }else if(seqToCompress.length() == 1){
            compressedSeq = seqToCompress + String.valueOf("1");
        }else{
            for (int i = 0; i < lastIndex; i++) {
                char letter = seqToCompress.charAt(i);
                char nextLetter = seqToCompress.charAt((i+1));
                if(letter == nextLetter){
                    count++;
                    if(i == seqToCompress.length() - 2){
                        if(letter == nextLetter){
                            String appendToResult = String.valueOf(letter) + String.valueOf(count);
                            compressedSeq += appendToResult;
                        }else{
                            compressedSeq += String.valueOf(letter) + String.valueOf(count);
                            compressedSeq += String.valueOf(nextLetter) + String.valueOf("1");
                        }
                    }
                }else{
                    String appendToResult = String.valueOf(letter) + String.valueOf(count);
                    compressedSeq += appendToResult;
                    if(i == seqToCompress.length() - 2){
                        if(letter == nextLetter){
                            appendToResult = String.valueOf(letter) + String.valueOf(count);
                            compressedSeq += appendToResult;
                        }else{
                            compressedSeq += String.valueOf(nextLetter) + String.valueOf("1");
                        }
                    }
                    count = 1;
                }

            }
        }

        System.out.println(compressedSeq);
    }
}
