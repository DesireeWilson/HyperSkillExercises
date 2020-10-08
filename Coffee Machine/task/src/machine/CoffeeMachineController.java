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

    public void mainMenuLogic(Scanner scanner){
        view.printAmountOfIngredientInMachinePrompt();
        view.printActionPrompt();
        //I need to have a method that reads in


        view.printAmountOfIngredientInMachinePrompt();
    }

    public void methodSelection(String arg){
        if(arg.equalsIgnoreCase("buy")){
            //call buyUI method
        }else if(arg.equalsIgnoreCase("fill")){
            //call fillUI method
        }else if(arg.equalsIgnoreCase("take")){
            //call takeUI method
        }else{
            //print "invalid command"
        }
    }

    public void buySomething(Scanner scanner){
        //call 'what do you want to buy' prompt
        int selection = scanner.nextInt();
        if(selection == 1){
            //create expresso and update coffee machine
        }else if(selection == 2){
            //create latte and update coffee machine
        }else if(selection == 3){
            //create cappuccino and update coffee machine
        }else{
            //print "invalid command"
        }
    }

    public void fillSomething(Scanner scanner){
        //call "fillIngredients" prompt
        int waterAmount = scanner.nextInt();
        //call "fillIngredients" prompt
        int milkAmount = scanner.nextInt();
        //call "fillIngredients" prompt
        int beansAmount = scanner.nextInt();
        model.addIngredients("water", waterAmount);
        model.addIngredients("milk", milkAmount);
        model.addIngredients("beans", beansAmount);
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
