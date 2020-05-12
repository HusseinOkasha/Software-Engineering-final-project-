/**
 * one line in an order of potentially many kinds of products
 */
public class OrderDetail {

  /** the kind of product purchased */
  private Product product;

  /** cached value of this order detail */
  private double productTotal;

  /** number of units being purchased */
  private int quantity;

 /** A constructor to set a line in an order
   * @param product the kind of item being purchased
   * @param quantity of the product being purchased
   */

  public OrderDetail(Product product, int quantity) {
    this.product  = product;
    this.quantity = quantity;
  }

  /**
   * calculates the cost of this amount of this product
   * @param taxPercentage is the applicable tax %
   * @return the cost of this amount of the product
   */
  public double getTotal(float taxPercentage) {
    if (product == null)
      productTotal = 0;
    else {
      productTotal = product.calcTotal(quantity);
      productTotal *= (1 + (taxPercentage/100));  
    }
    return productTotal;
  }

  /**
   * accessor method for quantity
   * @return the quanity of the item being purchased
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * setter method for quantity
   * @param quantity the quanity of the item being purchased
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  /** Return a string with the details of this 
    * line in the order
    * @return - A string represeting an order line.
    */
  public String toString () {
    return product + "Quantity: " + quantity + "\n"; 
  }
}
