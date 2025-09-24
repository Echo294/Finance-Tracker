
import javax.swing.*;

import java.awt.GridLayout;
import java.io.*;

public class PopUp {
	public static void main(String[] args) {
		
		FinanceManager manager = new FinanceManager();
		
		
		//creating a window
		JFrame frame = new JFrame("Finance Tracker");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 2, 10, 10));
		
		//buttons
		JButton addIncomeButton = new JButton("Add Income");
		JButton addExpenseButton = new JButton ("Add Expense");
		JButton viewBalanceButton = new JButton("View Balance");
		JButton exitButton = new JButton("Exit");

		frame.add(addIncomeButton);
		frame.add(addExpenseButton);
		frame.add(viewBalanceButton);
		frame.add(exitButton);
		
		frame.setVisible(true);
		
		
		//button functions
		addIncomeButton.addActionListener(e -> {
			String input = JOptionPane.showInputDialog(frame, "Enter income amount: ");
			if (input != null) {
				double amount = Double.parseDouble(input);
				manager.addIncome(amount);
			}
		});
		
		addExpenseButton.addActionListener(e -> {
			String input = JOptionPane.showInputDialog(frame, "Enter expense amount");
			if (input != null) {
				double amount = Double.parseDouble(input);
				manager.addExpense(amount);
			}
		});

		viewBalanceButton.addActionListener(e -> {
			double balance = manager.viewBalance();
			JOptionPane.showMessageDialog(frame, "Your balance is: " + balance);
		});
		
		exitButton.addActionListener(e -> {
			manager.saveData();
			JOptionPane.showMessageDialog(frame, "Data Saved. Goodbye.");
			frame.dispose();
		});
		
		frame.setVisible(true);;
	}

}
