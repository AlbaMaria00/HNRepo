package tests;

import java.util.ArrayList;
import java.util.Scanner;

import components.Client;

//1.1.2 Creation of main class for tests
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int numClients;
		String name;
		String firstName;
		System.out.println("How many clients do you want to create?");
		numClients=sc.nextInt();
		ArrayList<Client> clients=new ArrayList<>();
		for(int i=1;i<=numClients;i++) {
			System.out.println("");
			System.out.println("Name");
			name=sc.nextLine();
			System.out.println("FirstName");
			firstName=sc.nextLine();
			Client c=new Client(name, firstName, i);
			clients.add(c);
			System.out.println(c.toString());
		}
	}

}
