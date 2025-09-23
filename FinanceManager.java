
import java.io.*;
import java.util.Scanner;

public class FinanceManager {
	private double totalIncome;
	private double totalExpenses;
	private Scanner scanner;
	private final String filename = "finance.txt";
	
	public FinanceManager() {
		this.totalIncome = 0;
		this.totalExpenses = 0;
		scanner = new Scanner(System.in);
		loadData();
	}
	
	public void addIncome(Scanner scanner) {
		System.out.print("Add income amount: ");
		double income = scanner.nextDouble();
		totalIncome += income;
		System.out.println("Added income: " + income);
	}

	public void addExpense(Scanner scanner) {
		System.out.print("Enter expense amount: ");
		double expense = scanner.nextDouble();
		totalExpenses += expense;
		System.out.println("Added expense: " + expense);
	}
	
	public void viewBalance() {
		double balance = totalIncome - totalExpenses;
		System.out.print("Your balance is: " + balance);
	}
	
	// Now we save and load the input number for the expenses
	public void saveData() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.println(totalIncome);
			writer.println(totalExpenses);
			System.out.println("Data saved successfully");
		} catch (IOException e) {
			System.out.println("Error saving data: " + e.getMessage());
		}	
	}

	private void loadData() {
		File file = new File(filename);
		if (!file.exists()) {
			return;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			totalIncome = Double.parseDouble(reader.readLine());
			totalExpenses = Double.parseDouble(reader.readLine());
			System.out.println("Data loaded succefully.");
		} catch (IOException | NumberFormatException e) {
			System.out.print("Error loading data: " + e.getMessage());
		}
	}
	
}
	
