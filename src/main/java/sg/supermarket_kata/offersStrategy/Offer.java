/**
 * 
 */
package sg.supermarket_kata.offersStrategy;

import sg.supermarket_kata.Discount;
import sg.supermarket_kata.Product;
import sg.supermarket_kata.enums.OfferType;

/**
 * @author Badis
 *
 */
public abstract class Offer {

	private OfferType offerType;
	private final Product product;
	private double amountForDiscount;

	public Offer(OfferType offerType, Product product, double amountForDiscount) {
		this.offerType=offerType;
		this.amountForDiscount=amountForDiscount;
		this.product = product;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the amountForDiscount
	 */
	public double getAmountForDiscount() {
		return amountForDiscount;
	}

	/**
	 * @return the offerType
	 */
	public OfferType getOfferType() {
		return offerType;
	}


	public abstract Discount calculateDiscountAmount(double quantity, double unitPrice);

}
