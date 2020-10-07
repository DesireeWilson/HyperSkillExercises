package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachineModel model = new CoffeeMachineModel();
        CoffeeMachineView view = new CoffeeMachineView();
        CoffeeMachineController controller = new CoffeeMachineController(model, view);

        //controller.calculateIngredients(scanner); // previous stage
        controller.calculateCupsOfCoffeeDesired(scanner);

    }
}
