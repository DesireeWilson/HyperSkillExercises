package machine;

public class Cappuccino extends Beverage{
    //fields:
    private int waterNeeded = 200;
    private int milkNeeded = 100;
    private int beansNeeded = 12;
    private int cost = 6;
    private boolean milkIncluded = true;


    //methods:
    public Cappuccino(){}

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
