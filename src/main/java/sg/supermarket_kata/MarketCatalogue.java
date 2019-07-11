/**
 * 
 */
package sg.supermarket_kata;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Badis
 *
 */
public class MarketCatalogue {
	private Map<String, Product> products = new HashMap<String, Product>();
	private Map<String, BigDecimal> prices = new HashMap<String, BigDecimal>();

	public void addProduct(Product product, BigDecimal price) {
		this.products.put(product.getName(), product);
		this.prices.put(product.getName(), price);
	}

	public BigDecimal getUnitPrice(Product p) {
		return this.prices.get(p.getName());
	}
}
