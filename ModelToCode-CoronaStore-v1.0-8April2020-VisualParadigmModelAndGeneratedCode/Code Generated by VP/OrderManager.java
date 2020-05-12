import java.util.HashSet;

/**
 * This is control class that allows making orders, delivering them and paying for them.
 */
public class OrderManager {
	private final String storeName;
	private static int orderIDGenerator;
	/**
	 * This is a string of the file name of the image file with the logo of the company.
	 */
	private Object logoFile;
	public HashSet<Order> unnamed_Order_ = new HashSet<Order>();
	public HashSet<Product> has = new HashSet<Product>();

	public OrderManager(String aStoreName, float aTaxPercentage) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a product to the store.
	 */
	public void addProduct(String aCode, String aName, double aUnitPrice) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Create a new order and assign to it an order ID and delivery address.
	 */
	public int createOrder(float aTaxPercentage, String aDeliveryAddress) {
		throw new UnsupportedOperationException();
	}

	public Order getOrder(int aOrderID) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add an item to the order and the quantity needed.
	 */
	public void addProductToOrder(int aOrderID, String aProductCode, int aQuantity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Pay for an order with a payment.
	 */
	public void payOrder(Payment aPayment, Order aOrder) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Cancel an OPEN order.
	 */
	public void cancelOrder(int aOrderID) {
		throw new UnsupportedOperationException();
	}
}