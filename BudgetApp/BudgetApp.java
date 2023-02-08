import java.util.Scanner;
import java.util.ArrayList;

public class BudgetApp {
    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expense");
            System.out.println("3. Quit");
            System.out.println("Enter choice");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addExpense();
            } else if (choice == 2) {
                viewExpenses();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }

    static void addExpense() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter desciption: ");
        String description = sc.nextLine();

        System.out.println("Enter amount: ");
        double amount = sc.nextInt();

        expenses.add(new Expense(description, amount));

        System.out.println("Expense added");
    }

    static void viewExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            System.out.println(expense.description + ": \u20B9" + expense.amount);
            total += expense.amount;
        }
        System.out.println("Total: \u20B9" + total);
    }
}

class Expense {
    String description;
    double amount;

    Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}
