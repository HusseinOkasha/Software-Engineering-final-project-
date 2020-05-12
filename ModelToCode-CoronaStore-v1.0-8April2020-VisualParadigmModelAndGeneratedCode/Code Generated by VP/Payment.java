/**
 * This class represents a payment that can be used to settle a due amount.
 */
public abstract class Payment {
 private float amount;

 /**
  * Constructor sets the amount to be paid
  */
 public Payment(float aAmount) {
  throw new UnsupportedOperationException();
 }

 public boolean settlePayment() {
  throw new UnsupportedOperationException();
 }

 /**
  * Abstract method that deduces the due amount from the payment method.
  */
 public abstract boolean deductAmount();

 public abstract void displayMessage();

 public float getAmount() {
   return this.amount;
 }
}