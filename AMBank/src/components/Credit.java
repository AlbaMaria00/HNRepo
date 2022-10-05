package components;

import java.time.LocalDate;
import java.util.Date;

public class Credit extends Flow{

	public Credit(String comment, int identifier, double amount, int accountNumber, boolean effect, LocalDate dateOfFlow) {
		super(comment, identifier, amount, accountNumber, effect, dateOfFlow);
		// TODO Esbozo de constructor generado automáticamente
	}

	@Override
	public String toString() {
		return "Credit [getComment()=" + getComment() + ", getIdentifier()=" + getIdentifier() + ", getAmount()="
				+ getAmount() + ", getAccountNumber()=" + getAccountNumber() + ", isEffect()=" + isEffect()
				+ ", getDateOfFlow()=" + getDateOfFlow() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
