package components;

import java.time.LocalDate;
import java.util.Date;

public class Transfert extends Flow {

	private int accountThatTransfer;

	public Transfert(String comment, int identifier, double amount, int accountNumber, boolean effect, LocalDate dateOfFlow,
			int accountThatTransfer) {
		super(comment, identifier, amount, accountNumber, effect, dateOfFlow);
		this.accountThatTransfer = accountThatTransfer;
	}

}
