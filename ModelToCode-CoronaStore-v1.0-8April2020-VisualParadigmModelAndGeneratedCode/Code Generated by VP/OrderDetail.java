/**
 * One line in an order of potentially many kinds of products
 */
public class OrderDetail {
	/**
	 * cached value of this order detail
	 */
	private double productTotal;
	/**
	 * number of units being purchased
	 */
	private int quantity;
	/**
	 * is this item taxable or not?
	 */
	private boolean taxable = false;
	/**
	 * the kind of product purchased
	 */
	private Product product;

	/**
	 * Mandatory value constructor requires values for all attributes needed to
	 * set the initial values of this line of the order
	 * @param aProduct the kind of item being purchased
	 * @param aQuantity of the product being purchased
	 */
	public OrderDetail(Product aProduct, int aQuantity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Calculates the cost of this amount of this product
	 * @return the cost of this amount of the product
	 */
	public double getTotal(float aTaxRate) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a string representation of this line in the order.
	 */
	public String toString() {
		throw new UnsupportedOperationException();
	}
}