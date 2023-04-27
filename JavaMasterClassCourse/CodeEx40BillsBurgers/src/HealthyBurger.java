public class HealthyBurger extends Hamburger{
    private String healthyExtra1Name;
    private String healthyExtra2Name;
    private double healthyExtra1Price;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("HealthyBurger", meat, price, "Brown Rye");
    }


    public void addHealthyAddition1(String healthyExtra1Name, double healthyExtra1Price) {
        this.healthyExtra1Name = healthyExtra1Name;
        this.healthyExtra1Price = healthyExtra1Price;
    }

    public void addHealthyAddition2(String name, double price) {
        healthyExtra2Name = name;
        healthyExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();

        if(healthyExtra1Name != null) {
            System.out.println("Added: " + healthyExtra1Name + " for the price of " + healthyExtra1Price);
        }
        if(healthyExtra2Name != null) {
            System.out.println("Added: " + healthyExtra2Name + " for the price of " + healthyExtra2Price);

        }
        return (healthyExtra1Price + healthyExtra2Price + hamburgerPrice);
    }
}
