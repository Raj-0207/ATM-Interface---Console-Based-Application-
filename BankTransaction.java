

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BankTransaction extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validate Login information customer number and pin number */

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                /*
                 * Accounts in a HashMap, key = customer number, value = pin
                 * number
                 */
                data.put(1,1);
                data.put(2,2);
                data.put(3,3);
                data.put(4,4);
                data.put(5,5);
                data.put(6,6);
                data.put(7,7);
                data.put(8,8);
                data.put(9,9);


                System.out.println("Welcome to the ATM Project!");

                System.out.print("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }

                }
            System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
        } while (x == 1);
    }

    /* Display Account Type Menu with selection */

    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Current Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getCurrent();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this ATM, bye.");
                System.exit(0);

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    /* Display Current Account Menu with selections */

    public void getCurrent() {
        System.out.println("Current Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Mini-statement");
        System.out.println("Type 5 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()) + "\n");
                getCurrent();


            case 2:
                getCurrentWithdrawInput();
                getCurrent();


            case 3:
                getCurrentDepositInput();
                getCurrent();

            case 4:
                viewMiniStatement();
                getCurrent();

            case 5:
                System.out.println("Thank You for using this ATM, bye.");
                System.exit(0);

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getCurrent();
        }
    }

    /* Display Saving Account Menu with selections */

    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Mini-statement");
        System.out.println("Type 5 - Exit");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()) + "\n");
                getSaving();
                break;

            case 2:
                getSavingWithdrawInput();
                getSaving();
                break;

            case 3:
                getSavingDepositInput();
                getSaving();
                break;
            case 4:
                viewMiniStatement();
                getSaving();
            case 5:
                System.out.println("Thank You for using this ATM, bye.");
                System.exit(0);

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSaving();
        }
    }

    int selection;
}