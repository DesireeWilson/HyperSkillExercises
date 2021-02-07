package bullscows;


public class Model {
    //fields:
    private long secretCode;

    //methods:
    public Model() {}

    public Model(long secretCode){
        this.secretCode = secretCode;
    }

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
        this.secretCode = Long.valueOf(String.valueOf(randomNumberReversed));
    }

    public boolean checkNumOfDigits(int numOfDigits){
        return (numOfDigits < 11 && numOfDigits > 0) ? true : false;
    }

    public long getSecretCode(){
        return secretCode;
    }

    public int numOfBulls(String usersGuess){
        int count = 0;
        int indexCount = 0;
        String theCodeString = String.valueOf(secretCode);
        for (char digit : theCodeString.toCharArray()) {
            if(digit == usersGuess.toCharArray()[indexCount]){
                count++;
            }
            indexCount++;
        }
        return count;
    }

    public int numOfCows(String usersGuess){
        int count = 0;
        int indexCount = 0;
        String theCodeString = String.valueOf(secretCode);
        for (char digit : usersGuess.toCharArray()) {
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
