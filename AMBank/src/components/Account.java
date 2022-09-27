package components;
//1.2.1 Creation of the account class

public abstract class Account {
	protected int label;
	protected double balance;
	protected int accountNumber;
	protected Client client;
	
	
	public Account(int label, double balance) {
		super();
		this.label = label;
		this.balance = balance;
	}


	public int getLabel() {
		return label;
	}


	public void setLabel(int label) {
		this.label = label;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Account [label=" + label + ", balance=" + balance + ", accountNumber=" + accountNumber + ", client="
				+ client + "]";
	}


	public Account(int label, double balance, int accountNumber, Client client) {
		super();
		this.label = label;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.client = client;
	}
	
	
	
	
	
}
