import java.util.*;
import javax.swing.JOptionPane;
/**
 * One user transaction consisting of purchases of potentially many kinds of products
 * @author Mohammed El-Ramly
 * @version 1.0
 * @since 9 April 2020
 */
public class Order {

  private OrderStatus status = OrderStatus.OPEN;
  private float orderTotal;
  private String deliveryAddress;

  /** Order payment can be in cash or credit */
  private Payment payment;
  private ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
  
  /** Rate of tax applicable to this order as xx% */
  private float taxPercentage;
  
  private int orderID;
 
  /**
   * constructor requires tax rate applicabl 
   * to the order
   * @param taxPercentage the applicable tax rate
   * @param deliveryAddress the address where order is delivered
   * @param ID the unique identifier for the order
   */
  public Order(float taxPercentage, String deliveryAddress, int ID) {
    this.taxPercentage = taxPercentage;
    this.deliveryAddress = deliveryAddress;
    this.orderID = ID;
  }
  
  /** Get the order ID of this order
    * @return an integer representing the auto
    * generated order ID
    */
  public int getOrderID () {
    return orderID;
  }

  /** Get the order status of this order
    * @return an enumerated value OPEN or CLOSED
    * representing the order status.
    */
  public OrderStatus getStatus () {
    return status;
  }

  /**
   * calculates the total of the order from the order details
   * @return total of the order
   */
  public float calculateOrderTotal() {
    orderTotal = 0;
    Iterator<OrderDetail> i = orderDetails.iterator();
    while (i.hasNext()) 
      orderTotal += (i.next()).getTotal(taxPercentage);
    return orderTotal;
  }

  /**
   * adds a line item for a quantity of a type of item
   * @param product the type of item being sold
   * @param quantity the quantity of the item being sold
   */
  public void addOrderDetail (Product product, int quantity) {
    if (status == OrderStatus.OPEN)
      orderDetails.add(new OrderDetail(product, quantity));
    else
      JOptionPane.showMessageDialog(null,
          "You cannot added items to a closed order",
          "Order error",
          JOptionPane.ERROR_MESSAGE);
  }

  /**
   * pays the amount due for an order by cash or credit
   * @param payment is payment made for the order
   * @return  the quantity of the item being sold
   */
  public boolean payOrder (Payment payment) {   
    if (status == OrderStatus.CLOSED) {
     JOptionPane.showMessageDialog(null,
          "Order is already paid for:",
          "Order Payment",
          JOptionPane.INFORMATION_MESSAGE);
      return true;
    }
    else {
      boolean paidOrder = payment.settlePayment ();
      if (paidOrder == true) 
         status = OrderStatus.CLOSED;
      return paidOrder;
    }
  }

  /** Return a string with order details
    * @return a string with order details
    */
  public String toString () {
    String orderString = "ID: " + orderID + "\n";
    for (OrderDetail i: orderDetails)
      orderString += i.toString();
    orderString += "Total: " + calculateOrderTotal();
    orderString += " - Status: " + status;
    return orderString;
  } 
}
