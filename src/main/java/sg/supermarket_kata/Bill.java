/**
 * 
 */
package sg.supermarket_kata;

import java.util.ArrayList;
import java.util.List;
import sg.supermarket_kata.utils.DoubleUtil;
/**
 * @author Badis
 *
 */

// Bill is to summerup all items purchased
public class Bill {
	private List<Item> items = new ArrayList<Item>();
	private List<Discount> discounts = new ArrayList<Discount>();

	public Double getTotalPrice() {
		double total = 0.0;
		total+=items.stream()
				  .map(item -> item.getTotalPrice())
				  .reduce((a, b) -> a + b).orElse(0.0);
		total-= discounts.stream()
				  .map(item -> item.getDiscountAmount())
				  .reduce((a, b) -> a - b).orElse(0.0);
		return DoubleUtil.round(total, 2);
	}

	public void addProduct(Product p, double quantity, double price, double totalPrice) {
		this.items.add(new Item(p, quantity, price, totalPrice));
	}

	public List<Item> getItems() {
		return new ArrayList<Item>(this.items);
	}

	public void addDiscount(Discount discount) {
		this.discounts.add(discount);
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}
}
