package components;

import java.time.LocalDate;
import java.util.Date;

public abstract class Flow {
	private String comment;
	private int identifier;
	private double amount;
	private int accountNumber;
	private boolean effect;
	private LocalDate dateOfFlow;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isEffect() {
		return effect;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	public LocalDate getDateOfFlow() {
		return dateOfFlow;
	}

	public void setDateOfFlow(LocalDate localDate) {
		this.dateOfFlow = localDate;
	}

	public Flow(String comment, int identifier, double amount, int accountNumber, boolean effect, LocalDate dateOfFlow) {
		super();
		this.comment = comment;
		this.identifier = identifier;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.effect = effect;
		this.dateOfFlow = dateOfFlow;
	}

}
