/**
 * 
 */
package sg.supermarket_kata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Badis
 *
 */

// Bill is to summerup all items purchased
public class Bill {
	private List<Item> items = new ArrayList<Item>();
	private List<Discount> discounts = new ArrayList<Discount>();

	public BigDecimal getTotalPrice() {
		BigDecimal total = BigDecimal.ZERO;
		total=total.add(items.stream()
				  .map(item -> item.getTotalPrice())
				  .reduce((a, b) -> a.add(b)).orElse(BigDecimal.ZERO));
		total=total.subtract(discounts.stream()
				  .map(item -> item.getDiscountAmount())
				  .reduce((a, b) -> a.subtract(b)).orElse(BigDecimal.ZERO));
		total=total.setScale(2, RoundingMode.CEILING);
		return total;
	}

	public void addProduct(Product p, BigDecimal quantity, BigDecimal price, BigDecimal totalPrice) {
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
