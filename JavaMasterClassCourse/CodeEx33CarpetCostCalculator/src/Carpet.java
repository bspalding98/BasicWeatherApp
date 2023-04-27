public class Carpet {
//    fields
    private double cost;

//    constructors
    public Carpet(double cost) {
        this.cost = (cost < 0) ? 0 : cost;
    }

//    Getter
    public double getCost() {
        return cost;
    }
}
