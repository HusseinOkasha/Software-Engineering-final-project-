import java.util.HashSet;

/**
 * One user transaction consisting of purchases of potentially many kinds of products
 */
public class Order {
	private float orderTotal;
	private String deliveryAddress;
	/**
	 * Rate of tax applicable to this order as xx%
	 */
	private float taxPercentage;
	private int orderID;
	private OrderStatus orderStatus;
	/**
	 * Order payment can be in cash or credit
	 */
	private Payment payment;
	public HashSet<OrderDetail> unnamed_OrderDetail_ = new HashSet<OrderDetail>();

	/**
	 * Constructor requires tax rate applicable to the order
	 * @param aDeliveryAddress the address where order is delivered
	 */
	public Order(float aTaxPercentage, String aDeliveryAddress, int aOrderID) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculates the total of the order from the order details
	 * @return total of the order
	 */
	public float calculateOrderTotal() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Adds a line item for a quantity of a type of item
	 * @param aProduct the type of item being sold
	 * @param aQuantity the quantity of the item being sold
	 */
	public void addOrderDetail(Product aProduct, int aQuantity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Pays the amount due for an order by cash or credit
	 * @param aPayment is payment made for the order
	 * @return the quantity of the item being sold
	 */
	public boolean payOrder(Payment aPayment) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a string representation of the order.
	 */
	public String toString() {
		throw new UnsupportedOperationException();
	}

	public int getOrderID() {
		return this.orderID;
	}

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}
}