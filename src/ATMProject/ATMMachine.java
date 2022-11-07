package ATMProject;

import java.util.Scanner;

public class ATMMachine extends Bank {
    float amount;
    int adminPin;
    Scanner in = new Scanner(System.in);

//    Constructor
    public ATMMachine(float amount, int adminPin) {
        this.amount = amount;
        this.adminPin = adminPin;
    }

    public float getAmount(int pin) {
        if (pin == this.adminPin){
            return amount;
        }
        return -1;
    }

    public int setAmount(int pin, float amount) {
        if (pin == this.adminPin){
            this.amount = amount;
            return 1;
        }
        else {
            System.out.println("Wrong pin");
        }
        return -1;
    }

    //    Operations on an ATM machine
    
//    Get Customer
    
    private Customer getCustomer(int account){
        Customer currentCustomer = null;
        for (int i = 0; i < noOfCustomers; i++) {
            if (arr[i].getAccountNumber() == account){
                currentCustomer = arr[i];
            }
        }
        return currentCustomer;
    }

    public void displayFeatures(){
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Enter money in ATM");
    }

//    Greet the customer
    public void greet(Customer customer){
        System.out.println("Welcome "+customer.getName());
    }

//    Pin verification
    public boolean pinCheck(Customer customer, int pin){
        return (customer.getPin() == pin);
    }

//    Withdraw amount
    public int withdraw(int amount){
        System.out.println("Kindly enter your account no:");
        int account = in.nextInt();
        Customer customer = getCustomer(account);
        greet(customer);
        System.out.println("Kindly enter your pin");
        int pin = in.nextInt();
        if (!pinCheck(customer, pin)){
            System.out.println("Wrong pin!!");
            return -1;
        } else {
            if (amount > this.amount){
                System.out.println("ATM running short of cash");
                return -1;
            } else{
                customer.setBalance(customer.getBalance() - amount);
                this.amount -= amount;
                System.out.println("Kindly collect "+amount +" from the dispatch area \nThanks for using the service. \nCurrent balance is " + customer.getBalance());
            }
        }
        return 1;
    }

    public int deposit(int amount){
        System.out.println("Kindly enter your account no:");
        int account = in.nextInt();
        Customer customer = getCustomer(account);
        greet(customer);
        System.out.println("Kindly enter your pin");
        int pin = in.nextInt();
        if (!pinCheck(customer, pin)){
            System.out.println("Wrong pin!!");
            return -1;
        } else {
            customer.setBalance(customer.getBalance() + amount);
            this.amount += amount;
            System.out.println(amount +" succesfully deposited \nThanks for using the service. \nCurrent balance is" + customer.getBalance());
            return 1;
        }
    }

    public int checkbalance(){
        System.out.println("Kindly enter your account no:");
        int account = in.nextInt();
        Customer customer = getCustomer(account);
        greet(customer);
        System.out.println("Kindly enter your pin");
        int pin = in.nextInt();
        if (!pinCheck(customer, pin)){
            System.out.println("Wrong pin!!");
            return -1;
        } else{
            System.out.println("You have " + customer.getBalance() + " in your account");
            return customer.getBalance();
        }
    }
}
