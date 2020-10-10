package machine;

public class Latte extends Beverage{
    //fields:
    private int waterNeeded = 350;
    private int milkNeeded = 75;
    private int beansNeeded = 20;
    private int cost = 7;
    private boolean milkIncluded = true;


    //methods:
    public Latte(){}

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public int getBeansNeeded() {
        return beansNeeded;
    }

    public int getCost() {
        return cost;
    }

    public boolean isMilkIncluded(){
        return milkIncluded;
    }
}
