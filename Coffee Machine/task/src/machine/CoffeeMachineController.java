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
        int water = model.getAmountOfWaterInMachine();
        int milk = model.getAmountOfMilkInMachine();
        int beans = model.getAmountOfBeansInMachine();
        int cups = model.getAmountOfCupsInMachine();
        int money = model.getAmountOfMoneyInMachine();
        view.printCoffeeMachineIngredientAmount(water, milk, beans, cups, money);

        view.printActionPrompt();
        String action = scanner.nextLine();
        methodSelection(action, scanner);

        water = model.getAmountOfWaterInMachine();
        milk = model.getAmountOfMilkInMachine();
        beans = model.getAmountOfBeansInMachine();
        cups = model.getAmountOfCupsInMachine();
        money = model.getAmountOfMoneyInMachine();
        view.printCoffeeMachineIngredientAmount(water, milk, beans, cups, money);
    }

    public void methodSelection(String arg, Scanner scanner){
        if(arg.equalsIgnoreCase("buy")){
            buySomething(scanner);
        }else if(arg.equalsIgnoreCase("fill")){
            fillSomething(scanner);
        }else if(arg.equalsIgnoreCase("take")){
            takeSomething();
        }else{
            //print "invalid command"
        }
    }

    public void buySomething(Scanner scanner){
        //call 'what do you want to buy' prompt
        view.printBeverageMenuPrompt();
        int selection = scanner.nextInt();
        if(selection == 1){
            //create expresso and update coffee machine
            Espresso espresso = new Espresso();
            model.updateCoffeeMachineIngredientAmounts(espresso.getWaterNeeded()
                    ,espresso.getMilkNeeded()
                    ,espresso.getBeansNeeded()
                    ,1
                    ,espresso.getCost());
        }else if(selection == 2){
            //create latte and update coffee machine
            Latte latte = new Latte();
            model.updateCoffeeMachineIngredientAmounts(latte.getWaterNeeded()
                    ,latte.getMilkNeeded()
                    ,latte.getBeansNeeded()
                    ,1
                    ,latte.getCost());
        }else if(selection == 3){
            //create cappuccino and update coffee machine
            Cappuccino cappuccino = new Cappuccino();
            model.updateCoffeeMachineIngredientAmounts(cappuccino.getWaterNeeded()
                    ,cappuccino.getMilkNeeded()
                    ,cappuccino.getBeansNeeded()
                    ,1
                    ,cappuccino.getCost());
        }else{
            //print "invalid command"
            System.out.println("Invalid command. Please type '1', '2', or '3'.");
        }
    }

    public void fillSomething(Scanner scanner){
        //call "fillIngredients" prompt
        view.printAmountOfIngredientsToAddPrompt("water", "ml");
        int waterAmount = scanner.nextInt();
        //call "fillIngredients" prompt
        view.printAmountOfIngredientsToAddPrompt("milk", "ml");
        int milkAmount = scanner.nextInt();
        //call "fillIngredients" prompt
        view.printAmountOfIngredientsToAddPrompt("coffee beans", "grams");
        int beansAmount = scanner.nextInt();
        //call fillIngredients prompt
        view.printAmountOfIngredientsToAddPrompt("coffee", "disposable cups");
        int numOfCups = scanner.nextInt();
        model.addIngredients("water", waterAmount);
        model.addIngredients("milk", milkAmount);
        model.addIngredients("beans", beansAmount);
        model.addIngredients("cups", numOfCups);
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
}
