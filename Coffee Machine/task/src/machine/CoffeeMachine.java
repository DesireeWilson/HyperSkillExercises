package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachineModel model = new CoffeeMachineModel(400, 540, 120, 9, 550);
        CoffeeMachineView view = new CoffeeMachineView();
        CoffeeMachineController controller = new CoffeeMachineController(model, view);

        //controller.calculateIngredients(scanner); // previous stage
        //controller.calculateCupsOfCoffeeDesired(scanner);

        controller.mainMenuLogic(scanner);
//        Espresso espresso1 = new Espresso();
//        Beverage espresso2 = new Espresso();
//        System.out.println(model.canMakeCoffee(espresso2));
//        System.out.println(espresso1.getBeansNeeded());
//        System.out.println(espresso2.getBeansNeeded());

    }
}
