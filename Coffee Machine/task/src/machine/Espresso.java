package machine;

public class Espresso extends Beverage{
    //fields:
    private int waterNeeded = 250;
    private int milkNeeded = 0;
    private int beansNeeded = 16;
    private int cost = 4;
    private boolean milkIncluded = false;


    //methods:
    public Espresso(){}

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
