package tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import classes.WriteFile;

import java.util.Map.Entry;
import components.*;

//1.1.2 Creation of main class for tests

public class Main {

	public static void main(String[] args) {
		// 1.2.3 Creation of the tablea account
//		displayAccounts(loadAccounts(createClients()));
		ArrayList<Client> clients = new ArrayList<>();
		clients = createClients();
		displayFlows(loadFlow(loadAccounts(clients)));
		// Here I create the hastable

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
		int x = 1;
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
//	Create a method with a stream to display this Map in ascending order according to the balance
	public static HashMap<Integer, Double> hashtable(ArrayList<Account> accounts) {
		HashMap<Integer, Double> hashMap = new HashMap<>();

		for (Account account : accounts) {

			hashMap.put(account.getAccountNumber(), account.getBalance());

		}
		// list of keys
		List<Integer> list = new LinkedList<>(hashMap.keySet());
		// list of values
		List<Double> listOfValue = new LinkedList<>(hashMap.values());

		return hashMap;

	}

//	1.3.4 Creation of the flow array
	public static ArrayList<Flow> loadFlow(ArrayList<Account> accounts) {
		ArrayList<Flow> flows = new ArrayList<>();
		int id = 0;
		Debit debt1 = null;
		Credit crd = null;
		Transfert trf = null;
		double newbalance = 0;
		for (Account account : accounts) {
			System.out.println(account.getAccountNumber());
			if (account.getAccountNumber() == 1) {
				debt1 = new Debit("a debit of 50€ from account n°1", id++, 50, 1, false, LocalDate.now().plusDays(2));
				newbalance = account.getBalance() - 50;
				account.setBalance(newbalance, debt1);
			}
			if (account.getLabel() == "Current Account") {
				crd = new Credit("A credit of 100.50€ on all current accounts in the array of accounts", id++, 100.50,
						account.getAccountNumber(), false, LocalDate.now().plusDays(2));
				account.setBalance(account.getBalance() + 100.50, crd);
			} else if (account.getLabel() == "Saving Account") {
				crd = new Credit("A credit of 1500€ on all savings accounts in this same array", id++, 1500,
						account.getAccountNumber(), false, LocalDate.now().plusDays(2));
				account.setBalance(account.getBalance() + 1500, crd);
			}

		}

		System.out.println(accounts);
		// We add the credits and debits to flows
		flows.add(debt1);
		flows.add(crd);
		// Here I take the array of accounts, I take 1st and 2nd position(the
		// numofaccount 1 and 2) to do the transfert
		flows.add(doTransfert(id++, accounts.get(0), accounts.get(1)));
		System.out.println(flows);
		System.out.println(hashtable(accounts));
		generateJSON(accounts);
		WriteFile ob = new WriteFile();
		ob.writeXmlFile(accounts);
		return flows;

	}

	public static Transfert doTransfert(int id, Account acThatGive, Account acThatRecieve) {
		Transfert trf = new Transfert("A transfer of 50 € from account n ° 1 to account n ° 2", id++, 50,
				acThatRecieve.getAccountNumber(), false, LocalDate.now(), acThatGive.getAccountNumber());
		acThatGive.setBalance(acThatGive.getBalance() - 50, trf);
		acThatRecieve.setBalance(acThatRecieve.getBalance() + 50, trf);
		return trf;
	}

	public static void generateJSON(ArrayList arrayList) {
		String nomFichero = "jsondata.txt";
		File arch_salida = new File(nomFichero);
		FileWriter fw;
		if (!arch_salida.exists()) {
			Path file = Paths.get(nomFichero);

			List<String> salida;

			try {
				fw = new FileWriter(nomFichero);
				BufferedWriter bfw = new BufferedWriter(fw);
				var i = 1;
				for (Object ac : arrayList) {

					bfw.write("" + ac + "\n");
				}
				bfw.close();
			} catch (IOException e) {
				// TODO Bloque catch generado autom�ticamente
				e.printStackTrace();
			}
		}
	}

}
