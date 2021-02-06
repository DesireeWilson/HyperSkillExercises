package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Model model = new Model(9306);
        //View view = new View();
        //Controller controller = new Controller(model, view);

        int numOfDigits = scanner.nextInt();
        model.generateSecretCode(numOfDigits);
        //controller.uiLogic(scanner);


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
