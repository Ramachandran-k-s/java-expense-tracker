import java.util.Scanner;

public class Main {

    static double balance = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter income amount: ");
                    double income = sc.nextDouble();
                    balance += income;
                    System.out.println("Income added!");
                    break;

                case 2:
                    System.out.print("Enter expense amount: ");
                    double expense = sc.nextDouble();
                    balance -= expense;
                    System.out.println("Expense added!");
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}