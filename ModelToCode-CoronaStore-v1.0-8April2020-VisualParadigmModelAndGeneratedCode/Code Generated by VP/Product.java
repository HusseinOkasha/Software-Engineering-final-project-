/**
 * Instances represent entries in the inventory catalog
 */
public class Product {
	/**
	 * UPC
	 */
	private String code;
	/**
	 * Human friendly product name
	 */
	private String name;
	/**
	 * current price of a unit of the product
	 */
	private double unitPrice;

	/**
	 * mandatory values constructor requires values for all attributes needed to
	 * leave the object in a valid state
	 * @param aCode the UPC
	 * @param aName short human friendly name for the product
	 */
	public Product(String aCode, String aName, double aUnitPrice) {
		throw new UnsupportedOperationException();
	}

	/**
	 * calculates the current cost of a quantity of the product
	 * @return cost of the line item supplied
	 */
	public double calcTotal(int aQuantity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a string representation of the product.
	 * @return a string with product details
	 */
	public String toString() {
		throw new UnsupportedOperationException();
	}
}