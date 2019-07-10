/**
 * 
 */
package sg.supermarket_kata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Badis
 *
 */
public class MarketCatalogue {
	private Map<String, Product> products = new HashMap<String, Product>();
	private Map<String, Double> prices = new HashMap<String, Double>();

	public void addProduct(Product product, double price) {
		this.products.put(product.getName(), product);
		this.prices.put(product.getName(), price);
	}

	public double getUnitPrice(Product p) {
		return this.prices.get(p.getName());
	}
}
