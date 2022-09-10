package app;

import model.entities.Account;
import model.exceptions.AccountException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account data");

        System.out.print("Number: ");
        int n = sc.nextInt();

        System.out.print("Holder: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Initial balance: ");
        Double balance = sc.nextDouble();

        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();

        Account acc = new Account(n, name, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter a withdraw amount: ");
        Double withdrawAmount = sc.nextDouble();

        try {
            acc.withdraw(withdrawAmount);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
        }
        catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}