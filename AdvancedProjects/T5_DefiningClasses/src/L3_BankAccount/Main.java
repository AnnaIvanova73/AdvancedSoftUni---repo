package L3_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int id;
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    break;
                case "Deposit":
                    id = Integer.parseInt(tokens[1]);
                    if (hasAccount(bankAccounts, id)) break;

                    double depositToBalance = Double.parseDouble(tokens[2]);
                    BankAccount account = bankAccounts.get(id);
                    account.setBalance(depositToBalance);
                    System.out.printf("Deposited %.0f to ID%s%n", depositToBalance, account.getId());
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    if (hasAccount(bankAccounts, id)) break;
                    BankAccount account1 = bankAccounts.get(id);
                    int period = Integer.parseInt(tokens[2]);
                    System.out.printf("%.2f%n",
                            account1.getInterest(period));
            }

        }
    }

    private static boolean hasAccount(Map<Integer, BankAccount> bankAccounts, int id) {
        if (!bankAccounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return true;
        }
        return false;
    }
}
