/**
 * 
 */
package sg.supermarket_kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sg.supermarket_kata.offersStrategy.Offer;

/**
 * @author Badis
 *
 */

// Cart is what the client has selected to purchase
public class Cart {
	private final List<ProductQuantity> items = new ArrayList<ProductQuantity>();
	Map<Product, BigDecimal> productQuantities = new HashMap<Product, BigDecimal>();

	List<ProductQuantity> getItems() {
		return new ArrayList<ProductQuantity>(items);
	}

	void addItem(Product product) {
		this.addItemQuantity(product, BigDecimal.ONE);
	}

	Map<Product, BigDecimal> productQuantities() {
		return productQuantities;
	}

	public void addItemQuantity(Product product, BigDecimal quantity) {
		items.add(new ProductQuantity(product, quantity));
		if (productQuantities.containsKey(product)) {
			productQuantities.put(product, productQuantities.get(product).add(quantity));
		} else {
			productQuantities.put(product, quantity);
		}
	}

	// update the bill with the discount amount
	void updateOffers(Bill bill, Map<Product, Offer> offers, MarketCatalogue catalog) {
		for (Product p : productQuantities().keySet()) {
			BigDecimal quantity = productQuantities.get(p);
			if (offers.containsKey(p)) {
				Offer offer = offers.get(p);
				BigDecimal unitPrice = catalog.getUnitPrice(p);
				Discount discount = null;
				// using the Strategy pattern to calculate the discount depending on the type of
				// the offer
				discount = offer.calculateDiscountAmount(quantity, unitPrice);
				if (discount != null)
					bill.addDiscount(discount);
			}
		}
	}
}
