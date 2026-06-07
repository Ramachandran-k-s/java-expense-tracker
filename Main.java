import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static double balance = 0;

    static ArrayList<Transaction> transactions =
            new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter income amount: ");
                    double income = sc.nextDouble();

                    balance += income;

                    transactions.add(
                            new Transaction("Income", income)
                    );

                    System.out.println("Income added!");
                    break;

                case 2:

                    System.out.print("Enter expense amount: ");
                    double expense = sc.nextDouble();

                    balance -= expense;

                    transactions.add(
                            new Transaction("Expense", expense)
                    );

                    System.out.println("Expense added!");
                    break;

                case 3:

                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 4:

                    if (transactions.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {

                        System.out.println("\nTransaction History:");

                        for (Transaction t : transactions) {
                            System.out.println(
                                    t.type + " : ₹" + t.amount
                            );
                        }
                    }
                    break;

                case 5:

                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}