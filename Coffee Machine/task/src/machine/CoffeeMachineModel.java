package machine;

import java.util.Scanner;

public class CoffeeMachineModel {
    //fields:
    private int numberOfCupsOfCoffee;
    private int amountOfWaterNeeded;
    private int amountOfMilkNeeded;
    private int amountOfBeansNeeded;
    private int amountOfWaterInMachine;
    private int amountOfMilkInMachine;
    private int amountOfBeansInMachine;
    private final int WATER_ML = 200;
    private final int MILK_ML = 50;
    private final int BEANS_G = 15;


    //methods:
    public CoffeeMachineModel(){}

    public int calculateAmountOfWaterNeeded(){
        amountOfWaterNeeded = numberOfCupsOfCoffee * WATER_ML;
        return amountOfWaterNeeded;
    }

    public int calculateAmountOfMilkNeeded(){
        amountOfMilkNeeded = numberOfCupsOfCoffee * MILK_ML;
        return amountOfMilkNeeded;
    }

    public int calculateAmountOfBeans(){
        amountOfBeansNeeded = numberOfCupsOfCoffee * BEANS_G;
        return amountOfBeansNeeded;
    }

    public void setNumberOfCupsOfCoffee(Scanner scanner){
        numberOfCupsOfCoffee = scanner.nextInt();
    }

    public void setAmountOfWaterInMachine(Scanner scanner){
        amountOfWaterInMachine = scanner.nextInt();
    }

    public void setAmountOfMilkInMachine(Scanner scanner){
        amountOfMilkInMachine = scanner.nextInt();
    }

    public void setAmountOfBeansInMachine(Scanner scanner){
        amountOfBeansInMachine = scanner.nextInt();
    }

    public void setNumberOfCupsOfCoffee(int amount){
        numberOfCupsOfCoffee = amount;
    }

    public void setAmountOfWaterInMachine(int amount){
        amountOfWaterInMachine = amount;
    }

    public void setAmountOfMilkInMachine(int amount){
        amountOfMilkInMachine = amount;
    }

    public void setAmountOfBeansInMachine(int amount){
        amountOfBeansInMachine = amount;
    }


    public int getAmountOfWaterNeeded() {
        return amountOfWaterNeeded;
    }

    public int getAmountOfMilkNeeded() {
        return amountOfMilkNeeded;
    }

    public int getAmountOfBeansNeeded() {
        return amountOfBeansNeeded;
    }

    public int getAmountOfWaterInMachine(){
        return amountOfWaterInMachine;
    }

    public int getAmountOfMilkInMachine(){
        return amountOfMilkInMachine;
    }

    public int getAmountOfBeansInMachine(){
        return amountOfBeansInMachine;
    }

    public int getNumberOfCupsOfCoffee() {
        return numberOfCupsOfCoffee;
    }

    public int calculateNumberOfCupsOfCoffeePossible(){
        int count = 0;
        int waterRemaining = getAmountOfWaterInMachine();
        int milkRemaining = getAmountOfMilkInMachine();
        int beansRemaining = getAmountOfBeansInMachine();


        while(true){
            if((waterRemaining / WATER_ML == 0) || (milkRemaining / MILK_ML == 0) ||
                    (beansRemaining / BEANS_G == 0)){
                break;
            }
            count++;
            waterRemaining -= WATER_ML;
            milkRemaining -= MILK_ML;
            beansRemaining -= BEANS_G;
        }
        return count;
    }

    public boolean canMakeCoffee(){
        return (calculateNumberOfCupsOfCoffeePossible() >= getNumberOfCupsOfCoffee());
    }

    public boolean canMakeExtraCoffee(){
        return (calculateNumberOfCupsOfCoffeePossible() > getNumberOfCupsOfCoffee());
    }

    public int calculateNumberOfExtraCupsOfCoffee(){
        return calculateNumberOfCupsOfCoffeePossible() - getNumberOfCupsOfCoffee();
    }

    public void addIngredients(String ingredient, int amount){
        if(ingredient.equalsIgnoreCase("water")){
            setAmountOfWaterInMachine(getAmountOfWaterInMachine() + amount);
        }else if(ingredient.equalsIgnoreCase("milk")){
            setAmountOfMilkInMachine(getAmountOfMilkInMachine() + amount);
        }else if(ingredient.equalsIgnoreCase("beans")){
            setAmountOfBeansInMachine(getAmountOfBeansInMachine() + amount);
        }else{
            System.out.println("invalid entry");
        }
    }
}
