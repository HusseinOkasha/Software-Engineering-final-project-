/**
 * Cash payment that can be used to pay a due amount and take the change.
 */
public class Cash extends Payment {
	private float cash;
	private float change;

	/**
	 * A constructor to set the cash amount and the due amount.
	 */
	public Cash(float aAmount, float aCash) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Deduct the due amount from the given cash and return true is cash was enough.
	 */
	public boolean deductAmount() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Display a message showing if payment was successful or cash was not enough.
	 */
	public void displayMessage() {
		throw new UnsupportedOperationException();
	}
}