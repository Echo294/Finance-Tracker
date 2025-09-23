
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		FinanceManager manager = new FinanceManager();
		
		while (running) {
			showMenu.showMenu();
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			
			case 1:
				manager.addIncome(scanner);
				break;
				
			case 2:
				manager.addExpense(scanner);
				break;
				
			case 3:
				manager.viewBalance();
				break;
				
			case 4:
				running = false;
				System.out.println("Attempting to save data.");
				manager.saveData();
				break;
			default:
					System.out.println("Invalid Option");
			}
		}
		
		scanner.close();
		System.out.print("Goodbye!");
	}

}
