import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * This is control class that allows making orders,
 * and paying for them via credit or with cash
 * upon deliver.
 */
public class OrderManager {

  /** A hashtable stores (orderID, order) pairs */
  private Hashtable <Integer, Order> orders;

  /** A hashtable stores (product code, product) pairs */
  private Hashtable <String, Product> products;
  
  private final String storeName;
  private int orderIDGenerator;
  
  /** Constructor to set up a store
    * with store name, logo and applicable tax rate 
    * @param storeName is the name give to the store
    * @param logoFile is the file name of logo file
    * @param taxPercentage is the % of tax applicable
    */
  public OrderManager (String storeName, String logoFile, float taxPercentage) {
    this.storeName = storeName;
    orderIDGenerator = 0;
    orders   = new Hashtable <Integer, Order> ();
    products = new Hashtable <String, Product> ();
    JOptionPane.showMessageDialog(null, 
        "Welcome to Corona Store", 
        "Corona Store", 
        JOptionPane.PLAIN_MESSAGE,
        new ImageIcon(logoFile));
  }
  
  /** Add an new product to store for sale
    * @param code is a string representing product code
    * @param name is a string representing product name
    * @param unitPrice is a float representing unit price
    */
  public void addProduct (String code, String name, float unitPrice) {
    products.put(code, new Product(code, name, unitPrice));
  }  

  /** A getter for all products in the store
    * @return a hashtable of (Code, Product) pairs
    */
  public Hashtable<String, Product> getProducts () {
    return products;
  }  

  /** Create a new order
    * @param taxPercentage is the applicable tax %
    * @param deliveryAddress is the address to deliver order to 
    * @return the ID of the newly created order
    */
  public int createOrder (float taxPercentage, String deliveryAddress) {
    ++orderIDGenerator;
    Order order = new Order(taxPercentage, deliveryAddress, orderIDGenerator);
    orders.put (orderIDGenerator, order);
    return orderIDGenerator;
  }  

  /** Accessor method for order
    * @param orderID is the ID of this order
    * @return the Order whose ID is given
    */
  public Order getOrder (int orderID) {
    return orders.get(orderID);
  }

  /** Add a new item to an order.
    * @param orderID is the ID of the order to add item to
    * @param productCode is the code of the product to add
    * @param quantity is the amount of that product to add
    */
  public void addProductToOrder (int orderID, String productCode, int quantity) {
    Order order = orders.get (orderID);
    order.addOrderDetail (products.get(productCode), quantity);
  }

  /** Pay for an order.
    * @param payment - the payment to pay for the order
    * @param order - the order to pay for.
    */ 
  public void payOrder (Payment payment, Order order) {
    order.payOrder (payment);
  }
  
  /** Cancel an open order
    * @param orderID - is the id of the order 
    * to delete from the store.
    */
  public void cancelOrder (int orderID) {
    if (orders.get(orderID).getStatus() == OrderStatus.OPEN)
      orders.remove(orderID);
  }
}


