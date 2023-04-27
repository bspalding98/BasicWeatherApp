public class VipCustomer {
//    Fields
    private String name;
    private long creditLimit;
    private String emailAddress;

//    Setters
    public VipCustomer() {
        this("defaultName", 50000, "default@email.com");
//        Calles constructor two below.
    }

    public VipCustomer(String name, long creditLimit) {
        this(name, creditLimit, "unknown@email.com");
//        Calls constructor below
    }

    public VipCustomer(String name, long creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
//        This is the only one that saves the values (sets them) ((setter))
    }

//    Getters
    public String getName() {
        return name;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
