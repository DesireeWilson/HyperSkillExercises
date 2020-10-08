package machine;

public class Cappuccino {
    //fields:
    private int waterNeeded = 200;
    private int milkNeeded = 100;
    private int beansNeeded = 12;
    private int cost = 6;


    //methods:
    public Cappuccino(){}

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
