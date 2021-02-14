package bullscows;

import java.util.Scanner;

public class Controller {
    //fields:
    private Model model;
    private View view;
    private int secretCodeLength = 0;
    private int numPossibleChar;


    //methods:
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void uiLogic(Scanner scanner){
        int count = 0;
        while(true) {
            view.secretCodeLengthPrompt();
            String argument = "";
            try {
                argument = scanner.nextLine();
                secretCodeLength = Integer.parseInt(argument);
            } catch(NumberFormatException e) {
                System.out.printf("Error: \"%s\" isn't a valid number.", argument);
                break;
            }
            view.numPossibleCharPrompt();
            numPossibleChar = scanner.nextInt();
            if(numPossibleChar > 36) {
                System.out.println("Error: maximum number of possible symbols " +
                                    "in the code is 36 (0-9, a-z)");
                break;
            }
            if(secretCodeLength > numPossibleChar){
                System.out.printf("Error: it's not possible to generate a " +
                                    "code with a length of %d with %d " +
                                    "unique symbols.\n", secretCodeLength, numPossibleChar);
                break;
            }
            if(model.checkNumOfDigits(secretCodeLength)){
                view.startGameMessage();
                model.generateSecretCode(secretCodeLength, numPossibleChar);
                char terminalCharacter = AllPossibleCharacters.getCharacter(numPossibleChar -1);
                view.secretCodePrompt(secretCodeLength, numPossibleChar, terminalCharacter);
                break;
            }
            //view.numberofDigitsErrorMessage(secretCodeLength);
        }

        //view.secretCodePrompt();
        if(secretCodeLength > 0 && secretCodeLength <= numPossibleChar && numPossibleChar <= 36) {
            while(true){
                count++;
                view.turnPrompt(count);
                String guess = scanner.next();
                int numOfBulls = model.numOfBulls(guess);
                int numOfCows = model.numOfCows(guess);
                if(numOfBulls == secretCodeLength){
                    view.gradePrompt(numOfBulls, numOfCows, secretCodeLength);
                    view.congratsPrompt(model.getSecretCode());
                    break;
                }else{
                    view.gradePrompt(numOfBulls, numOfCows, secretCodeLength);
                }
            }
        }

    }

    public void graderLogic(Scanner scanner){
        String usersGuess = scanner.nextLine();
        int numOfBulls = model.numOfBulls(usersGuess);
        int numOfCows = model.numOfCows(usersGuess);
        if(numOfBulls == secretCodeLength){
            view.gradePrompt(numOfBulls, numOfCows, secretCodeLength);
            view.congratsPrompt(model.getSecretCode());
        }else{
            view.gradePrompt(numOfBulls, numOfCows, secretCodeLength);
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
