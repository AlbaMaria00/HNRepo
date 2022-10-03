package tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import components.*;

//1.1.2 Creation of main class for tests

public class Main {

	public static void main(String[] args) {
		// 1.2.3 Creation of the tablea account
//		displayAccounts(loadAccounts(createClients()));

		Hashtable contenedor = new Hashtable();
		displayFlows(loadFlow(loadAccounts(createClients())));

	}

	public static ArrayList createClients() {
		Scanner sc = new Scanner(System.in);
		int numClients;
		String name;
		String firstName;
		System.out.println("How many clients do you want to create?");
		numClients = sc.nextInt();
		ArrayList<Client> clients = new ArrayList<>();
		int x = 0;
		for (int i = 0; i < numClients; i++) {
			x++;
			System.out.println("Another");
			sc.nextLine();
			System.out.println("Name");
			name = sc.nextLine();
			System.out.println("FirstName");
			firstName = sc.nextLine();
			Client c = new Client(name, firstName, x);
			clients.add(c);
		}
		return clients;
	}

	public static ArrayList loadAccounts(ArrayList<Client> clients) {
		ArrayList<Account> accounts = new ArrayList<>();
		for (int i = 0; i < clients.size(); i++) {
			SavingsAccount savingsAccount = new SavingsAccount("Saving Account", clients.get(i));
			CurrentAccount currentAccount = new CurrentAccount("Current Account", clients.get(i));
			accounts.add(savingsAccount);
			accounts.add(currentAccount);
		}
		int x = 0;
		for (Account account : accounts) {
			account.setAccountNumber(x++);
		}

		return accounts;
	}

	public static void displayAccounts(ArrayList<Account> accounts) {
		Object[] array = accounts.toArray();
		Arrays.stream(array).forEach(System.out::println);
	}

	// Method to show flow array
	public static void displayFlows(ArrayList<Flow> flows) {
		Object[] array = flows.toArray();
		Arrays.stream(array).forEach(System.out::println);
	}

//1.3.1 Adaptation of the table of accounts
	public static Map<String, Class> hashtable() {

		return null;

	}

//	1.3.4 Creation of the flow array
	public static ArrayList<Flow> loadFlow(ArrayList<Account> accounts) {
		System.out.println("HOLA");
		ArrayList<Flow> flows = new ArrayList<>();
		int id = 0;
		Debit debt1 = null;
		Credit crd = null;
		double newbalance = 0;
		for (Account account : accounts) {
			System.out.println(account.getAccountNumber());
			if (account.getAccountNumber() == 1) {
				debt1 = new Debit("a debit of 50€ from account n°1", id++, 50, 1, false, LocalDate.now());
				newbalance = account.getBalance() - 50;
				account.setBalance(newbalance, debt1);
			}
			if (account.getLabel() == "Current Account") {
				crd = new Credit("A credit of 100.50€ on all current accounts in the array of accounts", id++, 100.50,
						account.getAccountNumber(), false, LocalDate.now());
				account.setBalance(account.getBalance() + 100.50, crd);
			}else if(account.getLabel() == "Saving Account") {
				crd = new Credit("A credit of 1500€ on all savings accounts in this same array", id++, 1500,
						account.getAccountNumber(), false, LocalDate.now());
				account.setBalance(account.getBalance() + 1500, crd);
			}
		}
		System.out.println(accounts);
		flows.add(debt1);
		flows.add(crd);
		return flows;

	}
}
