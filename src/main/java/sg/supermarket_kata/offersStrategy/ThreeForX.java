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
public class ThreeForX extends Offer{
	public ThreeForX(OfferType offerType, Product product, BigDecimal amountForDiscount) {
        super(OfferType.ThreeForAmount, product, amountForDiscount);
    }

    @Override
    public Discount calculateDiscountAmount(BigDecimal quantity, BigDecimal unitPrice){
        int x =3;
        Discount discount = null;
        int quantityAsInt = quantity.intValue();

        if (quantityAsInt >= x) {
        	BigDecimal total = this.getAmountForDiscount() .multiply(new BigDecimal(quantityAsInt / x)).add(unitPrice.multiply(new BigDecimal(quantityAsInt % x)));
        	BigDecimal discountN = unitPrice.multiply(quantity).subtract(total);
            discount = new Discount(this.getProduct(), "3 for " + this.getAmountForDiscount(), discountN);
        }

        return discount;
    }


}
