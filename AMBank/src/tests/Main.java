package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import components.Account;
import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;

//1.1.2 Creation of main class for tests

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numClients;
		String name;
		String firstName;
		System.out.println("How many clients do you want to create?");
		numClients = sc.nextInt();
		ArrayList<Client> clients = new ArrayList<>();
		int x=0;
		do{
			x++;
			System.out.println("");
			sc.nextLine();
			System.out.println("Name");
			name = sc.nextLine();
			System.out.println("FirstName");
			firstName = sc.nextLine();
			Client c = new Client(name, firstName, x);
			clients.add(c);
		}while(x==numClients);

		// 1.2.3 Creation of the tablea account
//		System.out.println(loadAccounts(clients));
		displayAccounts(loadAccounts(clients));
//		System.out.println(loadAccounts(clients).getClass());

		Hashtable contenedor = new Hashtable();
	}

	public static ArrayList loadAccounts(ArrayList<Client> clients) {
		ArrayList<Account> accounts = new ArrayList<>();
		for (int i = 0; i < clients.size(); i++) {
			SavingsAccount savingsAccount = new SavingsAccount(0, clients.get(i));
			CurrentAccount currentAccount = new CurrentAccount(0, clients.get(i));
			accounts.add(savingsAccount);
			accounts.add(currentAccount);
		}
		return accounts;
	}

	public static void displayAccounts(ArrayList<Account> accounts) {
		Object[] array = accounts.toArray();
		Arrays.stream(array).forEach(System.out::println);
	}

//1.3.1 Adaptation of the table of accounts
	public static Map<String, Class> hashtable() {

		return null;

	}
}
