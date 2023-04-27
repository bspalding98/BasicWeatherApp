public class Main {

    public static void main(String[] args) {
////        Account boydsAccount = new Account("12345", "Boyd Spalding", "boyd98@outlook.com",
////                "0478819222", 0);       // Now creates all in one go instead of doing below.
//        Account boydsAccount = new Account();   // This will print "Account constructor with parameters called" first because that "this" line
//                                                // Actually calls and runs the other account constructor we have with the parameters.
//
////        boydsAccount.setAccount("12345");
////        boydsAccount.setCustomerName("Boyd Spalding");
////        boydsAccount.setEmail("boyd98@outlook.com");
////        boydsAccount.setPhoneNumber("0478879222");
////        boydsAccount.setBalance(0);
//
////        Instead of above. Can use constructors when first initialising variables so you do not need to write them out. Imagine if you had like 30.
////        Java automatically creates a constructor. example here is new "Account()" THis is the constructor. So in Account Class
////        We can create the constructor and add our own stuff and Java will see that we are trying to make our own and will then not use default one.
////        CONSTRUCTOR MUST BE SAME SYNTAX TO CLASS NAME.
////        Constructor made in class
////        Just replaces Setters so you won't need them anymore
////        This is seen in the above part when you create an object with the blueprint/template (class).
//
//
//        boydsAccount.withdrawal(100);
//
//        boydsAccount.deposit(50);
//        boydsAccount.withdrawal(100);
//
//        boydsAccount.deposit(51);
//        boydsAccount.withdrawal(100);
//        System.out.println("********************");
//
//        Account billsAccount = new Account();
//        System.out.println(billsAccount.getAccount() + "\n" + billsAccount.getCustomerName() + "\n" + billsAccount.getPhoneNumber() +
//                 "\n" + billsAccount.getBalance() + "\n" + billsAccount.getEmail());
//        System.out.println("********************");
//
//        Account bobsAccount = new Account("Bob", "bob@co", "0456069434");
//        System.out.println(bobsAccount.getAccount() + "\n" + bobsAccount.getCustomerName() + "\n" + bobsAccount.getPhoneNumber() +
//                "\n" + bobsAccount.getBalance() + "\n" + bobsAccount.getEmail());
//        System.out.println("********************");
//
//        Account travisAccount = new Account("22222", "Travis", "travis@co", "0447072516", 333);
//        System.out.println(travisAccount.getAccount() + "\n" + travisAccount.getCustomerName() + "\n" +travisAccount.getPhoneNumber() +
//                "\n" + travisAccount.getBalance() + "\n" + travisAccount.getEmail());

        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());

        VipCustomer person2 = new VipCustomer("Bob", 25000);
        System.out.println(person2.getName());

        VipCustomer person3 = new VipCustomer("Tim", 100, "tim@email.com");
        System.out.println(person3.getName());
    }
}
