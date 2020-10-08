package machine;

public class Espresso {
    //fields:
    private int waterNeeded = 250;
    private int milkNeeded = 0;
    private int beansNeeded = 16;
    private int cost = 4;


    //methods:
    public Espresso(){}

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public void setWaterNeeded(int waterNeeded) {
        this.waterNeeded = waterNeeded;
    }

    public int getMilkNeeded() {
        return milkNeeded;
    }

    public void setMilkNeeded(int milkNeeded) {
        this.milkNeeded = milkNeeded;
    }

    public int getBeansNeeded() {
        return beansNeeded;
    }

    public void setBeansNeeded(int beansNeeded) {
        this.beansNeeded = beansNeeded;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
