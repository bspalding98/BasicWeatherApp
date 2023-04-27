public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private String addition2Name;
    private String addition3Name;
    private String addition4Name;
    private double addition1Price;
    private double addition2Price;
    private double addition3Price;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String name, double price) {
        addition1Name = name;
        addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price) {
        addition2Name = name;
        addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price) {
        addition3Name = name;
        addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price) {
        addition3Name = name;
        addition3Price = price;
    }

    public double itemizeHamburger() {
        System.out.println(name + " hamburger on a " + breadRollType + " roll with " + meat + ", price is " + price);
        if(addition1Name != null) {
            System.out.println("Added: " + addition1Name + " for the price of " + addition1Price);
        }
        if(addition2Name != null) {
            System.out.println("Added: " + addition2Name + " for the price of " + addition2Price);

        }
        if(addition3Name != null) {
            System.out.println("Added: " + addition3Name + " for the price of " + addition3Price);

        }
        if(addition4Name != null) {
            System.out.println("Added: " + addition4Name + " for the price of " + addition4Price);

        }

        return (addition1Price + addition2Price + addition3Price + addition4Price + price);
    }

}
