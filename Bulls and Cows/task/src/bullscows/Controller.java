package bullscows;

import java.util.Scanner;

public class Controller {
    //fields:
    private Model model;
    private View view;
    private int numOfDigits;


    //methods:
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void uiLogic(Scanner scanner){
        int count = 0;
        while(true) {
            view.numberOfDigitsPrompt();
            numOfDigits = scanner.nextInt();
            if(model.checkNumOfDigits(numOfDigits)){
                view.startGameMessage();
                model.generateSecretCode(numOfDigits);
                break;
            }
            view.numberofDigitsErrorMessage(numOfDigits);
        }

        //view.secretCodePrompt();
        while(true){
            count++;
            view.turnPrompt(count);
            String guess = scanner.next();
            int numOfBulls = model.numOfBulls(guess);
            int numOfCows = model.numOfCows(guess);
            if(numOfBulls == numOfDigits){
                view.gradePrompt(numOfBulls, numOfCows, numOfDigits);
                view.congratsPrompt(model.getSecretCode());
                break;
            }else{
                view.gradePrompt(numOfBulls, numOfCows, numOfDigits);
            }
        }
    }

    public void graderLogic(Scanner scanner){
        String usersGuess = scanner.nextLine();
        int numOfBulls = model.numOfBulls(usersGuess);
        int numOfCows = model.numOfCows(usersGuess);
        if(numOfBulls == numOfDigits){
            view.gradePrompt(numOfBulls, numOfCows, numOfDigits);
            view.congratsPrompt(model.getSecretCode());
        }else{
            view.gradePrompt(numOfBulls, numOfCows, numOfDigits);
            System.out.printf("The secret code is %d.\n", model.getSecretCode());
        }
    }

    /*public void randomNumberLogic(Scanner scanner){
        int numOfDigits = scanner.nextInt();
        int errorCode = model.generateSecretCode(numOfDigits);
        if(errorCode == 0){
            System.out.printf("The random secret number is %d", model.getSecretCode());
        }else{
            System.out.println("Error: can't generate a secret number with a" +
                    " length of 11 because there aren't enough unique digits.");
        }
    }*/
}
