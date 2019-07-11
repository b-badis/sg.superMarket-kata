/**
 * 
 */
package sg.supermarket_kata;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import sg.supermarket_kata.enums.OfferType;
import sg.supermarket_kata.offersStrategy.Offer;
import sg.supermarket_kata.offersStrategy.ThreeForTwo;
import sg.supermarket_kata.offersStrategy.ThreeForX;

/**
 * @author Badis
 *
 */

public class MarketOwner {
	private final MarketCatalogue catalog;
	Map<Product, Offer> offers = new HashMap<Product, Offer>();

	public MarketOwner(MarketCatalogue catalog) {
        this.catalog = catalog;
    }

	public void addOffer(OfferType offerType, Product product, BigDecimal discountPrice) {
		if (offerType == OfferType.ThreeForAmount) {
			this.offers.put(product, new ThreeForX(offerType, product, discountPrice));
		}else {
			this.offers.put(product, new ThreeForTwo(offerType, product, discountPrice));

		}
	}

// generate the Bill for the client purchases (including the discounts)
	public Bill extractBill(Cart cart) {
		Bill bill = new Bill();
		for (ProductQuantity pq : cart.getItems()) {
			Product p = pq.getProduct();
			BigDecimal quantity = pq.getQuantity();
			BigDecimal unitPrice = this.catalog.getUnitPrice(p);
			BigDecimal price = quantity.multiply(unitPrice);
			bill.addProduct(p, quantity, unitPrice, price);
		}
		cart.updateOffers(bill, this.offers, this.catalog);

		return bill;
	}
}
