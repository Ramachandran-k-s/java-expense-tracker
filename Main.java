import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;

public class Main {

    static double balance = 0;
    static int transactionId = 1;

    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {

        loadTransactions();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Search By Category");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Income Amount: ");
                    double income = sc.nextDouble();

                    System.out.print("Enter Category: ");
                    String incomeCategory = sc.next();

                    balance += income;

                    Transaction incomeTransaction =
                            new Transaction(
                                    transactionId++,
                                    "Income",
                                    incomeCategory,
                                    income);

                    transactions.add(incomeTransaction);

                    saveTransaction(incomeTransaction);

                    System.out.println("Income Added Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Expense Amount: ");
                    double expense = sc.nextDouble();

                    System.out.print("Enter Category: ");
                    String expenseCategory = sc.next();

                    balance -= expense;

                    Transaction expenseTransaction =
                            new Transaction(
                                    transactionId++,
                                    "Expense",
                                    expenseCategory,
                                    expense);

                    transactions.add(expenseTransaction);

                    saveTransaction(expenseTransaction);

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

                    System.out.print("Enter Category: ");
                    String searchCategory = sc.next();

                    boolean found = false;

                    System.out.println("\n===== Search Results =====");

                    for (Transaction t : transactions) {

                        if (t.category.equalsIgnoreCase(searchCategory)) {

                            found = true;

                            System.out.println("-----------------------------");
                            System.out.println("ID       : " + t.id);
                            System.out.println("Type     : " + t.type);
                            System.out.println("Category : " + t.category);
                            System.out.println("Amount   : ₹" + t.amount);
                            System.out.println("Time     : " + t.time);
                        }
                    }

                    if (!found) {
                        System.out.println("No Transactions Found.");
                    }

                    break;

                case 6:

                    System.out.println("Thank you for using Expense Tracker!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void saveTransaction(Transaction t) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(
                                    "transactions.txt",
                                    true));

            writer.write(
                    t.id + "," +
                    t.type + "," +
                    t.category + "," +
                    t.amount + "," +
                    t.time);

            writer.newLine();

            writer.close();

        } catch (Exception e) {

            System.out.println("Error Saving Transaction!");
        }
    }

    static void loadTransactions() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "transactions.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String type = data[1];
                String category = data[2];
                double amount = Double.parseDouble(data[3]);

                Transaction t =
                        new Transaction(
                                id,
                                type,
                                category,
                                amount);

                t.time = LocalDateTime.parse(data[4]);

                transactions.add(t);

                if (type.equals("Income")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }

                if (id >= transactionId) {
                    transactionId = id + 1;
                }
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("No Previous Transactions Found.");
        }
    }
}