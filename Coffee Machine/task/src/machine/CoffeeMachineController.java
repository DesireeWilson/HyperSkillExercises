package machine;

import java.util.Scanner;

public class CoffeeMachineController {
    //fields:
    private CoffeeMachineModel model;
    private CoffeeMachineView view;
    private Beverage espresso;
    private Beverage latte;
    private Beverage cappuccino;


    //methods:
    public CoffeeMachineController(CoffeeMachineModel model, CoffeeMachineView view){
        this.model = model;
        this.view = view;
    }

    public void mainMenuLogic(Scanner scanner){
        while(true){
            view.printActionPrompt();
            String action = scanner.nextLine();
            if(action.equalsIgnoreCase("exit")){
                break;
            }
            methodSelection(action, scanner);
        }
    }

    public void methodSelection(String arg, Scanner scanner){
        if(arg.equalsIgnoreCase("buy")){
            buySomething(scanner);
        }else if(arg.equalsIgnoreCase("fill")){
            fillSomething(scanner);
        }else if(arg.equalsIgnoreCase("take")){
            takeSomething();
        }else if(arg.equalsIgnoreCase("remaining")){
            int water = model.getAmountOfWaterInMachine();
            int milk = model.getAmountOfMilkInMachine();
            int beans = model.getAmountOfBeansInMachine();
            int cups = model.getAmountOfCupsInMachine();
            int money = model.getAmountOfMoneyInMachine();
            view.printCoffeeMachineIngredientAmount(water, milk, beans, cups, money);
        }else if(arg.equalsIgnoreCase("back")){
            //goes back to main menu
            System.out.println("Returning to main menu.....");
        }
        else{
            //print "invalid command"
            System.out.println("Invalid command. Please type 'buy', 'fill', 'take', 'remaining', or 'exit'.");
        }
    }

    public void buySomething(Scanner scanner){
        //call 'what do you want to buy' prompt
        boolean enoughResources;
        String ingredient = "";
        model.setNumberOfCupsOfCoffee(1);

        view.printBeverageMenuPrompt();
        String selection = scanner.nextLine();
        if(selection.equalsIgnoreCase("back")){
            System.out.println("Returning to main menu...");
        }else{
            int selectionNum = Integer.valueOf(selection);
            if(selectionNum == 1){
                //create espresso and update coffee machine
                Beverage espresso = new Espresso();
                makeBeverage(espresso);
            }else if(selectionNum == 2){
                //create latte and update coffee machine
                Latte latte = new Latte();
                makeBeverage(latte);
            }else if(selectionNum == 3){
                //create cappuccino and update coffee machine
                Cappuccino cappuccino = new Cappuccino();
                makeBeverage(cappuccino);
            }else{
                //print "invalid command"
                System.out.println("Invalid command. Please type '1', '2', '3', or 'back'.");
            }
        }
    }

    public void fillSomething(Scanner scanner){
        //call "fillIngredients" prompt
        view.printAmountOfIngredientsToAddPrompt("water", "ml");
        int waterAmount = Integer.valueOf(scanner.nextLine());
        //call "fillIngredients" prompt
        view.printAmountOfIngredientsToAddPrompt("milk", "ml");
        int milkAmount = Integer.valueOf(scanner.nextLine());
        //call "fillIngredients" prompt
        view.printAmountOfIngredientsToAddPrompt("coffee beans", "grams");
        int beansAmount = Integer.valueOf(scanner.nextLine());
        //call fillIngredients prompt
        view.printAmountOfIngredientsToAddPrompt("coffee", "disposable cups");
        int numOfCups = Integer.valueOf(scanner.nextLine());
        model.addIngredients("water", waterAmount);
        model.addIngredients("milk", milkAmount);
        model.addIngredients("beans", beansAmount);
        model.addIngredients("cups", numOfCups);
        System.out.println();
    }

    public void takeSomething(){
        System.out.printf("I gave you $%s\n\n", model.getAmountOfMoneyInMachine());
        model.setAmountOfMoneyInMachine(0);
    }

    public void printActionsPrompt(){
        view.printActionPrompt();
    }

    public void calculateIngredients(Scanner scanner){
        view.printAmountOfCoffeePrompt();
        model.setNumberOfCupsOfCoffee(scanner);
        int numOfCups = model.getNumberOfCupsOfCoffee();
        int mLWater = model.calculateAmountOfWaterNeeded(numOfCups, 200);
        int mLMilk = model.calculateAmountOfMilkNeeded(numOfCups, 50);
        int gBeans = model.calculateAmountOfBeans(numOfCups, 15);
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

        int numCupsPossible = model.calculateNumberOfCupsOfCoffeePossible(200, 50, 15);
        int numCupsExtra = model.calculateNumberOfExtraCupsOfCoffee(200, 50, 15);
        boolean canMakeCoffee = model.canMakeCoffee(200, 50, 15);
        boolean canMakeExtra = model.canMakeExtraCoffee(200, 50, 15);

        view.printAmountOfCupsPossiblePrompt(canMakeCoffee, canMakeExtra, numCupsPossible, numCupsExtra);
    }

    public void makeBeverage(Beverage beverage){
        String ingredient = "";
        boolean enoughResources;
        if(model.canMakeCoffee(beverage)){
            model.updateCoffeeMachineIngredientAmounts(beverage);
            enoughResources = true;
        }else{
            ingredient = model.ingredientsNeeded(beverage);
            enoughResources = false;
        }
        view.printEnoughResources(enoughResources, ingredient);
    }
}
