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
public class ThreeForTwo extends Offer{
	public ThreeForTwo(OfferType offerType, Product product, BigDecimal amountForDiscount) {
        super(OfferType.ThreeForTwo, product, amountForDiscount);
    }

	@Override
	public Discount calculateDiscountAmount(BigDecimal quantity, BigDecimal unitPrice) {
		int x =3;
		int y =2;
		Discount discount = null;
        int quantityAsInt = quantity.intValue();
        int numberOfXs = quantityAsInt / x;

        if (quantityAsInt >= x) {
        	BigDecimal discountAmount = quantity.multiply(unitPrice).subtract( unitPrice.multiply(new BigDecimal(numberOfXs * y)).add(unitPrice.multiply( new BigDecimal(quantityAsInt % x ))));
            discount = new Discount(this.getProduct(), "3 for 2", discountAmount);
        }

        return discount;
	}
}
