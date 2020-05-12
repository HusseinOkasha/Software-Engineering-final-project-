import java.util.Date;

/**
 * This class represents a payment for an order
 * with credit card
 */
public class Credit extends Payment {
	private String cardNumber;
	private String cardType;
	private Date expiryDate;
	/**
	 * Card status is decided after valiation with the bank
	 */
	private CardStatus cardStatus;
	/**
	 * User for testing cards without connecting to bank
	 */
	private int randomNumber;

	/**
	 * Setup credit cad information.
	 * @param aCardNumber - the 14 digit num of credit card
	 * @param aCardType - Visa, Mastercard, ....
	 * @param aExpiryDate - is the date on card
	 */
	public Credit(String aCardNumber, String aCardType, Date aExpiryDate, float aAmount) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Deduct the due amount from the given card if possible
	 */
	public boolean deductAmount() {
		throw new UnsupportedOperationException();
	}

	public void displayMessage() {
		throw new UnsupportedOperationException();
	}
}