import java.util.*;
import javax.swing.JOptionPane;
/** This class to test Corona Store core logic
  * @author Mohammad El-Ramly
  * @version 1.0
  * @since 10 Aptil 2020
  */ 
public class Main{
  /** This is the main method.
    * It is for testing purposes to test 
    * the work of Corona Store program.
    */
  public static void main (String args[]) {
    OrderManager store = new OrderManager (new String ("Ali Baba"), "Corona Logo.png", 10);
    store.addProduct ("001", "Ma3mool", 10);
    store.addProduct ("002", "Waffer", 5);
    store.addProduct ("003", "Bimbo", 4);
    
    int orderID1 = store.createOrder(10, "Abbassia ");
    store.addProductToOrder(orderID1, "001", 3);  
    store.addProductToOrder(orderID1, "002", 2);  
    
    float orderTotal1 = store.getOrder(orderID1).calculateOrderTotal();
    String cashString = JOptionPane.showInputDialog(store.getOrder(orderID1)
                      + "\nPlease enter cash to pay for your prder: ");
    float paidCash = Float.parseFloat(cashString);
      
    Payment payment1_1 = new Cash (orderTotal1 , paidCash);
    store.getOrder(orderID1).payOrder(payment1_1);

    Payment payment1_2 = new Credit ("0000000001", "VISA", new Date (2023, 12,12),  orderTotal1);
    store.getOrder(orderID1).payOrder(payment1_2);

    int orderID2 = store.createOrder(10, "Abbassia ");
    store.addProductToOrder(orderID2, "001", 3);  
    store.addProductToOrder(orderID2, "002", 2);  
  }
}