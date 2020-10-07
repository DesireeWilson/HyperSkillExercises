package machine;

import java.util.Scanner;

public class CoffeeMachineController {
    //fields:
    private CoffeeMachineModel model;
    private CoffeeMachineView view;


    //methods:
    public CoffeeMachineController(CoffeeMachineModel model, CoffeeMachineView view){
        this.model = model;
        this.view = view;
    }

    public void printMainMenu(){
        view.printMainMenu();
    }

    public void printActionsPrompt(){
        view.printActionPrompt();
    }

    public void calculateIngredients(Scanner scanner){
        view.printAmountOfCoffeePrompt();
        model.setNumberOfCupsOfCoffee(scanner);
        int numOfCups = model.getNumberOfCupsOfCoffee();
        int mLWater = model.calculateAmountOfWaterNeeded();
        int mLMilk = model.calculateAmountOfMilkNeeded();
        int gBeans = model.calculateAmountOfBeans();
        view.printAmountOfCoffeeNeeded(numOfCups, mLWater, mLMilk, gBeans);
    }

    public void calculateCupsOfCoffeeDesired(Scanner scanner){
        view.printAmountOfIngredientInMachinePrompt("water", "ml");
        model.setAmountOfWaterInMachine(scanner);
        view.printAmountOfIngredientInMachinePrompt("milk", "ml");
        model.setAmountOfMilkInMachine(scanner);
        view.printAmountOfIngredientInMachinePrompt("beans", "grams");
        model.setAmountOfBeansInMachine(scanner);
        view.printAmountOfCoffeePrompt();
        model.setNumberOfCupsOfCoffee(scanner);

        int numCupsPossible = model.calculateNumberOfCupsOfCoffeePossible();
        int numCupsExtra = model.calculateNumberOfExtraCupsOfCoffee();
        boolean canMakeCoffee = model.canMakeCoffee();
        boolean canMakeExtra = model.canMakeExtraCoffee();

        view.printAmountOfCupsPossiblePrompt(canMakeCoffee, canMakeExtra, numCupsPossible, numCupsExtra);
    }
}
