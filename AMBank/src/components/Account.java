package components;
//1.2.1 Creation of the account class

public abstract class Account {
	protected String label;
	protected double balance;
	protected int accountNumber;
	protected Client client;
	
	

	public Account(String label, Client client) {
		super();
		this.label = label;
		this.client = client;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance,Object Flow) {
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


	
	
	
	
	
}
