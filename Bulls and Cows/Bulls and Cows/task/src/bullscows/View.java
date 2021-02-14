package bullscows;

public class View {
    //fields:


    //methods:
    public View(){}

    public void secretCodeLengthPrompt(){
        System.out.println("Input the length of the secret code: ");
    }

    public void numPossibleCharPrompt() {
        System.out.println("Input the number of possible symbols in the code: ");
    }

    public void startGameMessage() {
        System.out.println("Okay, let's start a game!");
    }

    public void numberofDigitsErrorMessage(int numOfDigits) {
        System.out.printf("Error: can't generate a secret number with a length of %d " +
                "because there aren't enough unique digits.", numOfDigits);
    }

    public void secretCodePrompt(int secretCodeLength, int numPossibleChar, char terminalCharacter){
        String firstPart = "The secret code is prepared: ";
        String numStars = "";
        String range = "";
        //printing number of stars for secret code length:
        for (int i = 0; i < secretCodeLength; i++) {
            numStars += "*";
        }

        //creating range example (0-9, a) or (0-9, a-f)
        if(numPossibleChar < 11){
            range = "(0-" + terminalCharacter + ")";
        } else if(numPossibleChar == 11){
            range = "(0-9, " + terminalCharacter + ")";
        } else if(numPossibleChar == 12) {
            range = "(0-9, a, " + terminalCharacter + ")";
        }else {
            range = "(0-9, a-" + terminalCharacter + ")";
        }

        System.out.println(firstPart + numStars + " " + range);
    }

    /*public void turnPrompt(int numOfTurns){
        System.out.printf("Turn %d. Answer: \n", numOfTurns);
    }*/

    public void turnPrompt(int numOfTurns){
        System.out.printf("Turn %d.\n", numOfTurns);
    }

    public void gradePrompt(int numOfBulls, int numOfCows, int numOfDigits){
        String bulls = (numOfBulls > 1) ? String.format("%d bulls", numOfBulls)
                : (numOfBulls == 1) ? String.format("%d bull", numOfBulls)
                : "";
        String cows = (numOfCows > 1) ? String.format("%d cows", numOfCows)
                : (numOfCows == 1) ? String.format("%d cow", numOfCows)
                : "";
        String output = (numOfBulls == numOfDigits) ? String.format("Grade: %d bulls. ", numOfBulls)
                : (numOfBulls > 1 && numOfCows > 1) ? String.format("Grade: %d bulls and %d cows. ", numOfBulls,  numOfCows)
                : (numOfBulls > 1 && numOfCows == 1) ? String.format("Grade: %d bulls and %d cow. ", numOfBulls,  numOfCows)
                : (numOfBulls == 1 && numOfCows > 1) ? String.format("Grade: %d bull and %d cows. ", numOfBulls,  numOfCows)
                : (numOfBulls == 1 && numOfCows == 1) ? String.format("Grade: %d bull and cow %d. ", numOfBulls,  numOfCows)
                : (numOfBulls == 0 && numOfCows == 0) ? "None. "
                : "Grade: " + bulls + cows + ". ";
        System.out.println(output);
    }

    /*public void congratsPrompt(long secretCode){
        System.out.printf("Congrats! The secret code is %d.\n", secretCode);
    }*/

    public void congratsPrompt(String secretCode){
        System.out.println("Congratulations! You guessed the secret code.");
    }
}