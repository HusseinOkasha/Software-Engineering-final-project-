/**
 * Instances represent products available at Corona
 * Store ready to be ordered. This class does not
 * keep track of the inventory and item availability
 * @author Mohammad El-Ramly
 * @version 1.0
 * @since 10 April 2020
 * entries in the inventory catalog
 */
public class Product {
  /** UPC */
  private String code;

  /** Human friendly product name */
  private String name;

  /** current price of a unit of the product */
  private float unitPrice;

  /**
   * mandatory values constructor requires values for all attributes needed to
   * leave the object in a valid state
   * @param code the UPC
   * @param name short human friendly name for the product
   * @param unitPrice the price of one unit of the product
   */
  public Product(String code, String name, float unitPrice) {
    this.code   = code;
    this.name   = name;
    this.unitPrice = unitPrice;
  }

  /**
   * calculates the current cost of a quantity of the product
   * @param quantity is the num of units bought
   * @return cost of the line item supplied = qunatity * unit price
   */
  public double calcTotal(int quantity) {
    return (unitPrice * quantity);
  }
  
  /**
   * @return a string with product details
   */
  public String toString () {
    return ("Name: " + name + " - Code: " 
            + code + " - Price: " + unitPrice + "  ");
  } 
} 

