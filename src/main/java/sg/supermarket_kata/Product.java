/**
 * 
 */
package sg.supermarket_kata;

import sg.supermarket_kata.enums.ProductUnit;

/**
 * @author Badis
 *
 */
public class Product {
	private final String name;
	private final ProductUnit unit;

	public Product(String name, ProductUnit unit) {
		this.name = name;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public ProductUnit getUnit() {
		return unit;
	}
}
