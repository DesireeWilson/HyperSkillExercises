package machine;

import java.util.Scanner;

public class CoffeeMachineModel {
    //fields:
    private int numberOfCupsOfCoffee;
    private int amountOfWaterInMachine;
    private int amountOfMilkInMachine;
    private int amountOfBeansInMachine;
    private int amountOfCupsInMachine;
    private int amountOfMoneyInMachine;
    private Beverage beverage;


    //methods:
    public CoffeeMachineModel(int water, int milk, int beans, int cups, int money){
        this.amountOfWaterInMachine = water;
        this.amountOfMilkInMachine = milk;
        this.amountOfBeansInMachine = beans;
        this.amountOfCupsInMachine = cups;
        this.amountOfMoneyInMachine = money;
    }

    public void updateCoffeeMachineIngredientAmounts(Beverage beverage){
        this.amountOfWaterInMachine -= beverage.getWaterNeeded();
        this.amountOfMilkInMachine -= beverage.getMilkNeeded();
        this.amountOfBeansInMachine -= beverage.getBeansNeeded();
        this.amountOfCupsInMachine -= 1;
        this.amountOfMoneyInMachine += beverage.getCost();
    }

    public int calculateAmountOfWaterNeeded(int numberOfCupsOfCoffee, int waterNeeded){
        int amountOfWaterNeeded;
        amountOfWaterNeeded = numberOfCupsOfCoffee * waterNeeded;
        return amountOfWaterNeeded;
    }

    public int calculateAmountOfMilkNeeded(int numberOfCupsOfCoffee, int milkNeeded){
        int amountOfMilkNeeded;
        amountOfMilkNeeded = numberOfCupsOfCoffee * milkNeeded;
        return amountOfMilkNeeded;
    }

    public int calculateAmountOfBeans(int numberOfCupsOfCoffee, int beansNeeded){
        int amountOfBeansNeeded;
        amountOfBeansNeeded = numberOfCupsOfCoffee * beansNeeded;
        return amountOfBeansNeeded;
    }

    public void setNumberOfCupsOfCoffee(Scanner scanner){
        numberOfCupsOfCoffee = scanner.nextInt();
    }

    public void setNumberOfCupsOfCoffee(int amount){
        numberOfCupsOfCoffee = amount;
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

    public void setAmountOfCupsInMachine(Scanner scanner){
        amountOfCupsInMachine = scanner.nextInt();
    }

    public void setAmountOfMoneyInMachine(Scanner scanner){
        amountOfMoneyInMachine = scanner.nextInt();
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

    public void setAmountOfCupsInMachine(int amount){
        amountOfCupsInMachine = amount;
    }

    public void setAmountOfMoneyInMachine(int amount){
        amountOfMoneyInMachine = amount;
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

    public int getAmountOfCupsInMachine(){
        return amountOfCupsInMachine;
    }

    public int getAmountOfMoneyInMachine() {
        return amountOfMoneyInMachine;
    }

    public int calculateNumberOfCupsOfCoffeePossible(int waterNeeded, int milkNeeded, int beansNeeded){
        int count = 0;
        int waterRemaining = getAmountOfWaterInMachine();
        int milkRemaining = getAmountOfMilkInMachine();
        int beansRemaining = getAmountOfBeansInMachine();

        while(true){
            if((waterRemaining / waterNeeded == 0) || (milkRemaining / milkNeeded == 0) ||
                    (beansRemaining / beansNeeded == 0)){
                break;
            }
            count++;
            waterRemaining -= waterNeeded;
            milkRemaining -= milkNeeded;
            beansRemaining -= beansNeeded;
        }
        return count;
    }

    public int calculateNumberOfCupsOfCoffeePossible(Beverage beverage){
        int count = 0;
        int waterRemaining = getAmountOfWaterInMachine();
        int milkRemaining = getAmountOfMilkInMachine();
        int beansRemaining = getAmountOfBeansInMachine();

        if(beverage.isMilkIncluded()){
            while(true){
                if((waterRemaining / beverage.getWaterNeeded() == 0) || (milkRemaining / beverage.getMilkNeeded() == 0) ||
                        (beansRemaining / beverage.getBeansNeeded() == 0)){
                    break;
                }
                count++;
                waterRemaining -= beverage.getWaterNeeded();
                milkRemaining -= beverage.getMilkNeeded();
                beansRemaining -= beverage.getBeansNeeded();
            }
        }else{
            while(true){
                if((waterRemaining / beverage.getWaterNeeded() == 0) || (beansRemaining / beverage.getBeansNeeded() == 0)){
                    break;
                }
                count++;
                waterRemaining -= beverage.getWaterNeeded();
                beansRemaining -= beverage.getBeansNeeded();
            }
        }
        return count;
    }

    public boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded){
        return (calculateNumberOfCupsOfCoffeePossible(waterNeeded, milkNeeded, beansNeeded) >= getNumberOfCupsOfCoffee());
    }

    public boolean canMakeCoffee(Beverage beverage){
        return (calculateNumberOfCupsOfCoffeePossible(beverage) >= getNumberOfCupsOfCoffee());
    }

    public boolean canMakeExtraCoffee(int waterNeeded, int milkNeeded, int beansNeeded){
        return (calculateNumberOfCupsOfCoffeePossible(waterNeeded, milkNeeded, beansNeeded) > getNumberOfCupsOfCoffee());
    }

    public boolean canMakeExtraCoffee(Beverage beverage){
        return (calculateNumberOfCupsOfCoffeePossible(beverage) > getNumberOfCupsOfCoffee());
    }

    public int calculateNumberOfExtraCupsOfCoffee(int waterNeeded, int milkNeeded, int beansNeeded){
        return calculateNumberOfCupsOfCoffeePossible(waterNeeded, milkNeeded, beansNeeded) - getNumberOfCupsOfCoffee();
    }

    public int calculateNumberOfExtraCupsOfCoffee(Beverage beverage){
        return calculateNumberOfCupsOfCoffeePossible(beverage) - getNumberOfCupsOfCoffee();
    }

    public void addIngredients(String ingredient, int amount){
        if(ingredient.equalsIgnoreCase("water")){
            setAmountOfWaterInMachine(getAmountOfWaterInMachine() + amount);
        }else if(ingredient.equalsIgnoreCase("milk")){
            setAmountOfMilkInMachine(getAmountOfMilkInMachine() + amount);
        }else if(ingredient.equalsIgnoreCase("beans")){
            setAmountOfBeansInMachine(getAmountOfBeansInMachine() + amount);
        }else if(ingredient.equalsIgnoreCase("cups")){
            setAmountOfCupsInMachine(getAmountOfCupsInMachine() + amount);
        }else{
            System.out.println("invalid entry");
        }
    }

    public String ingredientsNeeded(Beverage beverage){
        String output = "";
        if(beverage.getWaterNeeded() > getAmountOfWaterInMachine()){
            if(beverage.getMilkNeeded() > getAmountOfMilkInMachine()){
                if(beverage.getBeansNeeded() > getAmountOfBeansInMachine()){
                    output = "water, milk and beans";
                }else{
                    output = "water and milk";
                }
            }else{
                if(beverage.getBeansNeeded() > getAmountOfBeansInMachine()){
                    output = "water and beans";
                }else{
                    output = "water";
                }
            }
        }else if(beverage.getMilkNeeded() > getAmountOfMilkInMachine()){
            if(beverage.getBeansNeeded() > getAmountOfBeansInMachine()){
                output = "milk and beans";
            }else{
                output = "milk";
            }
        }else if(beverage.getBeansNeeded() > getAmountOfBeansInMachine()){
            output = "beans";
        }
        return output;
    }
}
