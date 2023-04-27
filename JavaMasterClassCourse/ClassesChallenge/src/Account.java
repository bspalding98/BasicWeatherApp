public class Account {

    private double balance;
    private String account;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account() {
//        This line below must be first line to be called. Can not have anything else before it. can have print lines, etc. BUt only after it.
        this("00000", "Default name", "Default address", "Default phone",
                0);     // Special use of this to call another constructor inside a constructor. Pretty much means if you do not give me any parameters
                                // When creating your object. I will use my own here. So essentially this will run the constructor below first. Then print the line
                                // After this. So print out would be. "Account constructor with parameters called" first followed by "Empty constructor called".
        System.out.println("Empty constructor called");
    }


    public Account(String customerName, String email, String phoneNumber) {     // If we only wanted or asked someone to put in these fields
        this("11111", phoneNumber, customerName, email, 111);
        // This makes sure the constructor that has all fields (initialises all fields) is run still like the Account().
        System.out.println("Half filled constructor called");
    }


    public Account(String account, String customerName, String email, String phoneNumber, double balance) {
//        Just save fields directly.
        System.out.println("Account constructor with parameters called");
        this.account = account;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
//        setBalance(balance);      // This code also works and can be used if setBalance() has more than just the defining field and has validation, etc.
//        However supposedly is bad and other way is better because it can skip code (later video will find out).
    }



//    Setter:
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public void setAccount(String accountNumber) {
//        this.account = accountNumber;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
    }

    public void withdrawal(double withdrawalAmount) {
        System.out.println((this.balance - withdrawalAmount < 0) ? (this.balance + " available. Withdrawal not processed")
                : (this.balance -= withdrawalAmount));

//        if(this.balance - withdrawalAmount < 0) {
//            System.out.println(this.balance + " available. Withdrawal not processed");
//        } else {
//            this.balance -= withdrawalAmount;
//            System.out.println(this.balance);
//        }
    }



//    Getter
    public double getBalance() {
        return balance;
    }

    public String getAccount() {
        return account;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
