import java.util.ArrayList;

// BOOLEANS are being used because it can return false and validation can be done accordinly in main.java

public class Bank {
    private String name;
    private ArrayList<Branch> branches;     // Contains customer.

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String nameBranch) {       // Output Prints in main instead.
        if(findBranch(nameBranch) == null) {
            branches.add(new Branch(nameBranch));       // Cannot just add String nameBranch because it only takes type Branch. Would have need this method to take parameter "Branch nameBranch" but it states need to take String in exercise.
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String nameBranch, String nameCustomer, double initialTrans) {   // use newCustomer method. after finding branch??
        Branch branch = findBranch(nameBranch);     // Better coding practice
        if(branch != null) {
            return branch.newCustomer(nameCustomer, initialTrans);

        }

        return false;
    }

    public boolean addCustomerTransaction(String nameBranch, String nameCustomer, double transaction) {
        Branch branch = findBranch(nameBranch);
        if(branch != null) {
            return branch.addCustomerTransaction(nameCustomer, transaction);
        }

        return false;

//        OLD CODE:
//        if(findBranch(nameBranch) == null) {
//            return false;
//        } else {
//            int branchIndex = this.branches.indexOf(findBranch(nameBranch));
//            int customerIndex = this.branches.get(branchIndex).getCustomers().indexOf(nameCustomer);  // should have done: this.branches.get(branchIndex).addCustomerTransaction(nameCustomer, transaction)
//            this.branches.get(branchIndex).getCustomers().get(customerIndex).addTransaction(transaction);
//            return true;
//        }
    }

    private Branch findBranch(String nameBranch) {   // Done Is private because main will never check this. addBranch, etc. Will.
        for(int i = 0; i < this.branches.size(); i ++) {
            Branch branch = this.branches.get(i);
            if(branch.getName().equals(nameBranch)) {           // Would this work --> (this.branches.get(i).getName().equals(nameBranch)) --> Yes it would no object then needed
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String nameBranch, boolean printTrans) {       // FIX UP
//        if(findBranch(nameBranch) == null) {
//            return false;
//        } else if(printTrans){
//            Branch branch = findBranch(nameBranch);
//            ArrayList<Customer> customer = branch.getCustomers();
//            for(int i = 0; i < customer.size(); i ++) {
//                System.out.println("Customer: " + customer.get(i).getName() + "[" + (i + 1) + "]");
//                for(int j = 0; j < customer.get(i).getTransactions().size(); j ++) {
//                    System.out.println("[" + (j + 1) + "] Amount " + customer.get(i).getTransactions().get(j));
//                }
//            }
//            return true;
//        } else {
//            Branch branch = findBranch(nameBranch);
//            ArrayList<Customer> customer = branch.getCustomers();
//            for(int i = 0; i < customer.size(); i ++) {
//                System.out.println("Customer: " + customer.get(i).getName() + "[" + (i + 1) + "]");
//            }
//            return true;
//        }

//        His code:
        Branch branch = findBranch(nameBranch);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i = 0; i < branchCustomers.size(); i ++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if(printTrans) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j = 0; j < transactions.size(); j ++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
