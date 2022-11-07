package ATMProject;

public class Bank {
    static Customer[] arr = new Customer[500];
    static int noOfCustomers;



    public void createCustomer(String name, int accountNumber, int pin, int balance){
        Customer customer = new Customer(name, accountNumber, pin, balance);
        arr[noOfCustomers] = customer;
        noOfCustomers++;
    }
}
