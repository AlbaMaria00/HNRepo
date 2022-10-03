package components;

import java.util.Date;

public class Transfert extends Flow {

	private int accountThatTransfer;

	public Transfert(String comment, int identifier, double amount, int accountNumber, boolean effect, Date dateOfFlow,
			int accountThatTransfer) {
		super(comment, identifier, amount, accountNumber, effect, dateOfFlow);
		this.accountThatTransfer = accountThatTransfer;
	}

}
