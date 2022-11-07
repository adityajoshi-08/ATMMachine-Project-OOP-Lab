package ATMProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank SBI = new Bank();
        SBI.createCustomer("Aditya", 219302415, 1234, 50000);
        SBI.createCustomer("Harshit", 219301213, 1234, 50000);
        SBI.createCustomer("Ritik", 219202044, 1234, 50000);
        SBI.createCustomer("Shorya", 219303151, 1234, 50000);

        ATMMachine SBIAtm1 = new ATMMachine(500000, 1111);


        SBIAtm1.displayFeatures();
        System.out.println("Enter your choice");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == 1){
            System.out.println("Enter amount");
            int amount = in.nextInt();
            SBIAtm1.withdraw(amount);
        }

        else if(choice == 2){
            System.out.println("Enter amount");
            int amount = in.nextInt();
            SBIAtm1.deposit(amount);
        }

        else if(choice == 3){
            SBIAtm1.checkbalance();
        }

        else if(choice == 4){
            System.out.println("Enter master pin");
            int pin = in.nextInt();
            System.out.println("Enter amount");
            int amount = in.nextInt();
            SBIAtm1.setAmount(pin, SBIAtm1.getAmount(pin)+amount);
            System.out.println("Money added. \nAvailable amount = "+SBIAtm1.getAmount(pin));
        }

        else{
            System.out.println("Invalid choice!!");
        }
    }
}
