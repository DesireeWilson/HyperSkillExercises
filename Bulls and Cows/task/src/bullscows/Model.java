package bullscows;

import java.util.Random;

public class Model {
    //fields:
    private long secretCode;

    //methods:
    public Model() {}

    public void generateSecretCode(int numOfDigits){
        //local variables:
        StringBuilder randomNumberReversed = new StringBuilder();
        StringBuilder randomString;
        long pseudoRandomNumber; //creating random number

        while(randomNumberReversed.length() != numOfDigits){
            pseudoRandomNumber = System.nanoTime(); //creating random number
            //turn random number into a string
            randomString = new StringBuilder(String.valueOf(pseudoRandomNumber));

            //pull digits from random number in reverse order:
            for (int i = (randomString.length() - 1); i > -1; i--){
                //local variable:
                char theDigit = randomString.charAt(i);

                //if the last digit in randomString is 0, skip digit
                if(randomNumberReversed.length() == 0 & theDigit == '0'){
                    continue;
                //if digit is already present in randomNumberReversed, skip digit
                }else if(randomNumberReversed.indexOf(String.valueOf(theDigit)) != -1){
                    continue;
                //if the number of digits in randomNumberReversed  equals numOfDigits, break for-loop
                }else if(randomNumberReversed.length() == numOfDigits){
                    break;
                //else, add digit to randomNumberReversed
                }else{
                    randomNumberReversed.append(theDigit);
                }
            }
        }
        this.secretCode = Long.valueOf(randomNumberReversed)
    }

    public boolean checkNumOfDigits(int numOfDigits){
        return (numOfDigits < 11 && numOfDigits > 0) ? true : false;
    }

    public long getSecretCode(){
        return secretCode;
    }

    public int numOfBulls(int usersGuess){
        int count = 0;
        int indexCount = 0;
        String theCodeString = String.valueOf(secretCode);
        String userGuessString = String.valueOf(usersGuess);
        for (char digit : theCodeString.toCharArray()) {
            if(digit == userGuessString.toCharArray()[indexCount]){
                count++;
            }
            indexCount++;
        }
        return count;
    }

    public int numOfCows(int usersGuess){
        int count = 0;
        int indexCount = 0;
        String theCodeString = String.valueOf(secretCode);
        String userGuessString = String.valueOf(usersGuess);
        for (char digit : userGuessString.toCharArray()) {
            if(theCodeString.contains(String.valueOf(digit))){
                if(theCodeString.toCharArray()[indexCount] != digit){
                    count++;
                }
            }
            indexCount++;
        }
        return count;
    }
}
