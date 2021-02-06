package bullscows;

import java.util.Random;

public class Model {
    //fields:
    private long secretCode;

    //methods:
    public Model(){
        Random random = new Random();
        String firstDigit = String.valueOf(random.nextInt(10));
        String secondDigit = String.valueOf(random.nextInt(10));
        String thirdDigit = String.valueOf(random.nextInt(10));
        String fourthDigit = String.valueOf(random.nextInt(10));

        String secretCode = firstDigit + secondDigit + thirdDigit + fourthDigit;
        this.secretCode = Long.valueOf(secretCode);
    }

    public Model(int fourDigitCode){
        this.secretCode = fourDigitCode;
    }

    public int generateSecretCode2(int numOfDigits){
        if(numOfDigits > 10 || numOfDigits == 0){
            return -1;
        }else{
            StringBuilder randomNumber = new StringBuilder();
            Random random = new Random();
            if(numOfDigits >= 1){
                int firstDigit = random.nextInt(8) + 1;
                randomNumber.append(firstDigit);
            }
            if(numOfDigits > 1){
                for (int i = 0; i < numOfDigits - 1; i++) {
                    int digit = random.nextInt(10);
                    if(!randomNumber.toString().contains(String.valueOf(digit))){
                        randomNumber.append(digit);
                    }

                }
            }
            this.secretCode = Long.valueOf(randomNumber.toString());
        }
        return 0;
    }

    public void generateSecretCode(int numOfDigits){
        if(checkNumOfDigits(numOfDigits)){
            //local variables:
            StringBuilder randomNumberReversed = new StringBuilder();
            StringBuilder randomString;
            //int randomNumber = 0;
            long pseudoRandomNumber; //creating random number

            //while(randomNumberReversed.length() != numOfDigits){
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
            //}
            System.out.println("The random secret number is " + randomNumberReversed.toString());
        }else{
            System.out.println("Error: can't generate a " +
                    "secret number with a length of 11 because " +
                    "there aren't enough unique digits.");
        }
    }

    public boolean checkNumOfDigits(int numOfDigits){
        return (numOfDigits < 11) ? true : false;
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
