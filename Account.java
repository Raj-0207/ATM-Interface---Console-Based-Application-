import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account implements Bank {
    Scanner input = new Scanner(System.in);
    Map<Double,String> ministmt=new HashMap<>();

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /* Set the customer number */

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    /* Get the customer number */

    public int getCustomerNumber() {
        return customerNumber;
    }

    /* Set the pin number */

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* Get the pin number */

    public int getPinNumber() {
        return pinNumber;
    }

    /* Get Current Account Balance */

    public double getCurrentBalance() {
        return CurrentBalance;
    }

    /* Get Saving Account Balance */

    public double getSavingBalance() {
        return savingBalance;
    }

    /* Calculate Current Account withdrawal */

    public double calcCurrentWithdraw(double amount) {
        ministmt.put(amount, " Amount Withdrawn");
        System.out.println("Collect the Cash " + amount);
        CurrentBalance = (CurrentBalance - amount);
        return CurrentBalance;
    }

    /* Calculate Saving Account withdrawal */

    public double calcSavingWithdraw(double amount) {
        ministmt.put(amount, " Amount Withdrawn");
        System.out.println("Collect the Cash " + amount);
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    /* Calculate Current Account deposit */

    public double calcCurrentDeposit(double amount) {
        ministmt.put(amount," Amount Deposited");
        System.out.println(amount+" Deposited Successfully !!");
        CurrentBalance = (CurrentBalance + amount);
        return CurrentBalance;
    }

    /* Calculate Saving Account deposit */

    public double calcSavingDeposit(double amount) {
        ministmt.put(amount," Amount Deposited");
        System.out.println(amount+" Deposited Successfully !!");
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    /* Customer Current Account Withdraw input */

    public void getCurrentWithdrawInput() {
        System.out.println("Current Account Balance: " + moneyFormat.format(CurrentBalance));
        System.out.print("Amount you want to withdraw from Current Account: ");
        double amount = input.nextDouble();

        if(amount%100==0) {
            if ((CurrentBalance - amount) >= 0) {
                System.out.println("Collect the Cash " + CurrentBalance);
                calcCurrentWithdraw(amount);
                System.out.println("New Current Account balance: " + CurrentBalance + "\n");
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multiples of 100");
        }
    }

    /* Customer Saving Account Withdraw input */

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();
        if(amount%100==0) {
            if ((savingBalance - amount) >= 0) {
                System.out.println("Collect the Cash " + savingBalance);
                calcSavingWithdraw(amount);
                System.out.println("New Saving Account balance: " + savingBalance + "\n");
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multiples of 100");
        }
    }

    /* Customer Current Account Deposit input */

    public void getCurrentDepositInput() {
        System.out.println("Current Account Balance: " + moneyFormat.format(CurrentBalance));
        System.out.print("Amount you want to deposit from Current Account: ");
        double amount = input.nextDouble();

        if (amount%100==0) {
            calcCurrentDeposit(amount);
            System.out.println("New Current Account balance: " + moneyFormat.format(CurrentBalance) + "\n");
        } else {
            System.out.println("Please enter the amount in multiples of 100" + "\n");
            getCurrentDepositInput();
        }
    }

    /* Customer Saving Account Deposit input */

    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit from Saving Account: ");
        double amount = input.nextDouble();

        if (amount%100==0) {
            calcSavingDeposit(amount);
            System.out.println("New Current Account balance: " + moneyFormat.format(savingBalance) + "\n");
        } else {
            System.out.println("Please enter the amount in multiples of 100" + "\n");
        }
    }
    public void viewMiniStatement() {
        for (Map.Entry<Double, String> m : ministmt.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }
    private int customerNumber;
    private int pinNumber;
    private double CurrentBalance = 0;
    private double savingBalance = 0;
}