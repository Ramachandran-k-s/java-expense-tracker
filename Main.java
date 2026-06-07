import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Expense Tracker");

        System.out.print("Enter income: ");
        double income = sc.nextDouble();

        System.out.print("Enter expense: ");
        double expense = sc.nextDouble();

        double balance = income - expense;

        System.out.println("Balance = " + balance);
    }
}