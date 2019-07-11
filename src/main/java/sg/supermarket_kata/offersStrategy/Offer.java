/**
 * 
 */
package sg.supermarket_kata.offersStrategy;

import java.math.BigDecimal;

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
	private BigDecimal amountForDiscount;

	public Offer(OfferType offerType, Product product, BigDecimal amountForDiscount) {
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
	public BigDecimal getAmountForDiscount() {
		return amountForDiscount;
	}

	/**
	 * @return the offerType
	 */
	public OfferType getOfferType() {
		return offerType;
	}


	public abstract Discount calculateDiscountAmount(BigDecimal quantity, BigDecimal unitPrice);

}
