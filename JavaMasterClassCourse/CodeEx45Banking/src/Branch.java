import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String nameCustomer, double initialTrans) {      // Did I screw this one by swapping around.
        if(findCustomer(nameCustomer) == null) {
            this.customers.add(new Customer(nameCustomer, initialTrans));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String nameCustomer, double trans) {
        Customer existingCustomer = findCustomer(nameCustomer);     // it returns a customer, should already have a name and inital trans... so that's why you can.

        if(existingCustomer != null) {
            existingCustomer.addTransaction(trans);
            return true;
        }

        return false;

//            OLD CODE:

//            if(existingCustomer == null) {
//                return false;
//            } else {
//                for (int i = 0; i < this.customers.size(); i++) {
//                    Customer customer = this.customers.get(i);
//                    if (customer.getName().equals(nameCustomer)) {           // Could also do no object and this.customers.get(i).getName().equals(nameCustomer))
//                        customer.addTransaction(trans);
//                    }
//                }
//                return true;
//            }
    }

    private Customer findCustomer(String nameCustomer) {      // Same reason private is as findBranch()
        for(int i = 0; i < this.customers.size(); i ++) {
            Customer customer = this.customers.get(i);      // Do not need if you do not want to
            if(customer.getName().equals(nameCustomer)) {
                return customer;
            }
        }

        return null;
    }
}
