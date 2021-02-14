package bullscows;

import java.util.ArrayList;

public class AllPossibleCharacters {
    //fields:
    private static ArrayList<Character> allPossibleCharArray;


    //methods:
    public AllPossibleCharacters(){
        allPossibleCharArray = new ArrayList<>();
        addDigits();
        addLowercaseLetters();
    }

    private void addDigits(){
        for (int i = 0; i < 10; i++) {
            char digit = (char) (i + 48);
            this.allPossibleCharArray.add(digit);
        }
    }

    private void addLowercaseLetters(){
        for (int i = 0; i < 26; i++) {
            char lowercaseLetter = (char) (i + 97);
            this.allPossibleCharArray.add(lowercaseLetter);
        }
    }

    private void addUppercaseLetters(){
        for (int i = 0; i < 26; i++) {
            char uppercaseLetter = (char) (i + 65);
            this.allPossibleCharArray.add(uppercaseLetter);
        }
    }

    public ArrayList<Character> getAllPossibleCharArray() {
        return this.allPossibleCharArray;
    }

    public static char getCharacter(int indexPos){
        return allPossibleCharArray.get(indexPos);
    }

}
