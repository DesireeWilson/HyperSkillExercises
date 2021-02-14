package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Model model = new Model();
        //Model model = new Model(1234);
        View view = new View();
        Controller controller = new Controller(model, view);

        //int numOfDigits = scanner.nextInt();

        controller.uiLogic(scanner);
//        int count = 0;
//        while(true) {
//            view.numberOfDigitsPrompt();
//            int numOfDigits = scanner.nextInt();
//            if(model.checkNumOfDigits(numOfDigits)){
//                view.startGameMessage();
//                model.generateSecretCode(numOfDigits);
//                break;
//            }
//            view.numberofDigitsErrorMessage(numOfDigits);
//        }
//        System.out.println(model.getSecretCode());

        //controller.graderLogic(scanner);
        //controller.randomNumberLogic(scanner);

//        System.out.println("The secret code is prepared: ****.");
//        System.out.println();
//        System.out.println("Turn 1. Answer:");
//        System.out.println("1234");
//        System.out.println("Grade: 1 cow.");
//        System.out.println("Turn 2. Answer:");
//        System.out.println("9876");
//        System.out.println("Grade: 4 bulls.");
//        System.out.println("Congrats! The secret code is 9876.");
    }
}
