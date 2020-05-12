import java.util.*;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/** This class represents a payment for an order
  * with credit card 
  * @author Mohammad El-Ramly
  * @version 1.0
  * @since 11 April 2020
  */

public class Credit extends Payment {
  private String cardNumber;
  private String cardType;
  private Date expiryDate;
  
  /** Card status is decided after valiation with the bank */
  private CardStatus cardStatus;  
  
  /** User for testing cards without connecting to bank */
  private int randomNumber;
  
  /** Setup card information and a random number
    * generator to simulate valid and invalid cards.
    * @param cardNumber - the 14 digit num of credit card
    * @param cardType - Visa, Mastercard, ....
    * @param expiryDate - is the date on card
    * @param amount - is the amount to deduct from card
    */
  public Credit (String cardNumber, String cardType, Date expiryDate, float amount) {
    super (amount);
    this.cardNumber = cardNumber;
    this.cardType   = cardType;
    this.expiryDate = expiryDate;
    Random rand = new Random();
    randomNumber = rand.nextInt(100);
  }
  
  /** Displays a message if credit card payment 
    * was successful or not (invalid, expired or 
    * insufficient money).
    * It simulates card status via a random number
    * If num less than or equal 30, card is invalid, if num 
    * between 30 and 100
    * card is valid.
    * @return true if payment by card was successful and 
    * false otherwise.
    */ 
  public boolean deductAmount() {
    if (randomNumber <= 10)
      cardStatus = CardStatus.INVALID;
    else if (randomNumber <= 20)
      cardStatus = CardStatus.INSUFFICIENT_FUND;
    else if (randomNumber <= 30)
      cardStatus = CardStatus.EXPIRED;
    else {
      System.out.println ("Connecting with the bank .....");
      System.out.println (getAmount() + " where successfully deducted from your card.");
      cardStatus = CardStatus.VALID_SUFFICIENT;
    }  
    return cardStatus == CardStatus.VALID_SUFFICIENT;
  }

  /** Displays a message if credit card payment 
    * was successful or not (invalid, expired or 
    * insufficient money).
    * It simulates card status via a random number
    * If num less than or equal 30, card is invalid, if 
    * num is between 30 and 100.
    * card is valid.
    */ 
  public void displayMessage () {
    String message;
    if (randomNumber <= 30)
      JOptionPane.showMessageDialog(null,
        "I could not process your card payment - " + cardStatus,
        "Unsuccessful Card Payment",
        JOptionPane.ERROR_MESSAGE);
    else
      JOptionPane.showMessageDialog(null,
        "You paid: " + getAmount() + " by Credit Card",
        "Successful Card Payment",
        JOptionPane.INFORMATION_MESSAGE);
  }
}