public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(("National Australia Bank"));

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addBranch("Sydney");
        bank.addCustomer("Sydney", "Boyd", 150.54);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
        bank.listCustomers("Sydney", true);

        if(!bank.addCustomer("Melbourne", "Brian", 5.53)) {
            System.out.println("Error Melbourne branch does not exist");
        }

        if(bank.addCustomer("Melbourne", "Brian", 324)) {       // Does not exists so returns false
            System.out.println("Fucking dofgs");
        }
    }
}
