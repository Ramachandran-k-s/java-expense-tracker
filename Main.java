import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static double balance = 0;
    static int transactionId = 1;

    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Income Amount: ");
                    double income = sc.nextDouble();

                    System.out.print("Enter Category: ");
                    String incomeCategory = sc.next();

                    balance += income;

                    transactions.add(
                            new Transaction(
                                    transactionId++,
                                    "Income",
                                    incomeCategory,
                                    income
                            )
                    );

                    System.out.println("Income Added Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Expense Amount: ");
                    double expense = sc.nextDouble();

                    System.out.print("Enter Category: ");
                    String expenseCategory = sc.next();

                    balance -= expense;

                    transactions.add(
                            new Transaction(
                                    transactionId++,
                                    "Expense",
                                    expenseCategory,
                                    expense
                            )
                    );

                    System.out.println("Expense Added Successfully!");
                    break;

                case 3:

                    System.out.println("\nCurrent Balance: ₹" + balance);
                    break;

                case 4:

                    if (transactions.isEmpty()) {
                        System.out.println("\nNo Transactions Found.");
                    } else {

                        System.out.println("\n===== Transaction History =====");

                        for (Transaction t : transactions) {

                            System.out.println("-----------------------------");
                            System.out.println("ID       : " + t.id);
                            System.out.println("Type     : " + t.type);
                            System.out.println("Category : " + t.category);
                            System.out.println("Amount   : ₹" + t.amount);
                            System.out.println("Time     : " + t.time);
                        }
                    }
                    break;

                case 5:

                    System.out.println("Thank you for using Expense Tracker!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}