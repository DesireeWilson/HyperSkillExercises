package machine;


public class CoffeeMachineView {
    //fields:



    //methods:
    public CoffeeMachineView(){}

    public void printMainMenu(){
        String mainMenuPrompt = "";
        System.out.print(mainMenuPrompt);
    }

    public void printActionPrompt(){
        String actionsPrompt =
                "Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!";
        System.out.println(actionsPrompt);
    }

    public void printAmountOfCoffeePrompt(){
        System.out.print("Write how many cups of coffee will you need: ");
    }

    public void printAmountOfCoffeeNeeded(int numCups, int mLWater, int mLMilk, int gBeans){
        String result = String.format("For %s cups of coffee you will need:\n" +
                "%s ml of water\n" +
                "%s ml of milk\n" +
                "%s g of coffee beans\n"
                , numCups
                , mLWater
                , mLMilk
                , gBeans);
        System.out.print(result);
    }

    public void printAmountOfIngredientPrompt(String measurement, String ingredient){
        System.out.printf("Write how many %s of %s the coffee machine has: ", measurement, ingredient);
    }

    public void printAmountOfCupsPossiblePrompt(boolean canMakeCoffee, boolean canMakeExtraCoffee, int amountToMake, int amountExtra){
        String output = (canMakeCoffee) ?
                (canMakeExtraCoffee ? String.format("Yes, I can make that amount of coffee (and even %s more than that)", amountExtra)
                        : String.format("Yes, I can make that amount of coffee"))
                : String.format("No, I can only make %s cup(s) of coffee", amountToMake);
        System.out.println(output);
    }

    public void printAmountOfIngredientInMachinePrompt(String ingredient, String ingredientMeasurement){
        System.out.printf("Write how many %s of %s the coffee machine has: ", ingredientMeasurement, ingredient);
    }

}
