package bullscows;


import java.util.ArrayList;
import java.util.Random;

public class Model {
    //fields:
    private String secretCode;
    private ArrayList<Character> characterArrayList;

    //methods:
    public Model() {
        AllPossibleCharacters allPossibleCharacters = new AllPossibleCharacters();
        this.characterArrayList = allPossibleCharacters.getAllPossibleCharArray();

    }

    public Model(String secretCode){
        this.secretCode = secretCode;
    }

    public void generateSecretCode(int secretCodeLength, int numPossibleChar) {
        //variables:
        Random random = new Random();
        int indexPos;
        char character;
        StringBuilder secretCodeSB = new StringBuilder();

        while(secretCodeSB.length() != secretCodeLength) {
            if(secretCodeSB.length() == secretCodeLength) {
                break;
            }
            indexPos = random.nextInt(numPossibleChar + 1);
            character = characterArrayList.get(indexPos);
            //if the character is already in randomNumber, pick another digit:
            if(secretCodeSB.indexOf(String.valueOf(character)) != -1) {
                continue;
            } else {
                secretCodeSB.append(character);
            }
        }
        this.secretCode = String.valueOf(secretCodeSB);
    }

    public boolean checkNumOfDigits(int numOfDigits){
        return (numOfDigits < 11 && numOfDigits > 0) ? true : false;
    }

    public String getSecretCode(){
        return secretCode;
    }

    public int numOfBulls(String usersGuess){
        int count = 0;
        int indexCount = 0;
        for (char character : secretCode.toCharArray()) {
            if(character == usersGuess.toCharArray()[indexCount]){
                count++;
            }
            indexCount++;
        }
        return count;
    }

    public int numOfCows(String usersGuess){
        int count = 0;
        int indexCount = 0;
        for (char character : usersGuess.toCharArray()) {
            if(secretCode.contains(String.valueOf(character))){
                if(secretCode.toCharArray()[indexCount] != character){
                    count++;
                }
            }
            indexCount++;
        }
        return count;
    }
}
