package bullscows;

public class View {
    //fields:


    //methods:
    public View(){}

    public void numberOfDigitsPrompt(){
        System.out.println("Please, enter the secret code's length: ");
    }

    public void startGameMessage() {
        System.out.println("Okay, let's start a game!");
    }

    public void numberofDigitsErrorMessage(int numOfDigits) {
        System.out.printf("Error: can't generate a secret number with a length of %d " +
                "because there aren't enough unique digits.", numOfDigits);
    }

    public void secretCodePrompt(){
        System.out.println("The secret code is prepared: ****.");
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

    public void congratsPrompt(long secretCode){
        System.out.println("Congratulations! You guessed the secret code.");
    }
}