public class Case {
    private String model;
    private String manufactuer;
    private String powerSupply;
    private Dimensions dimensions;  // Case has dimensions which is a case because dimensions have a width, height, and depth. where others do not need a class because it is one thing

    public Case(String model, String manufactuer, String powerSupply, Dimensions dimensions) {
        this.model = model;
        this.manufactuer = manufactuer;
        this.powerSupply = powerSupply;
        this.dimensions = dimensions;
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }

    public String getModel() {
        return model;
    }

    public String getManufactuer() {
        return manufactuer;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
