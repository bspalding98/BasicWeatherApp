

public class Calculator {
//    fields
    private Floor floor;
    private Carpet carpet;

//    constructors
    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

//    getters
    public double getTotalCost() {
        return (floor.getArea()) * (carpet.getCost());
    }
}
