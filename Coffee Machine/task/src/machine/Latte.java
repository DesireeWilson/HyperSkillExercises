package machine;

public class Latte {
    //fields:
    private int waterNeeded = 350;
    private int milkNeeded = 75;
    private int beansNeeded = 20;
    private int cost = 7;


    //methods:
    public Latte(){}

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
