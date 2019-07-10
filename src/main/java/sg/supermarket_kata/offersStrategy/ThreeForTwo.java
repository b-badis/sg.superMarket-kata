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
public class ThreeForTwo extends Offer{
	public ThreeForTwo(OfferType offerType, Product product, double amountForDiscount) {
        super(OfferType.ThreeForTwo, product, amountForDiscount);
    }

	@Override
	public Discount calculateDiscountAmount(double quantity, double unitPrice) {
		int x =3;
		int y =2;
		Discount discount = null;
        int quantityAsInt = (int) quantity;
        int numberOfXs = quantityAsInt / x;

        if (quantityAsInt >= x) {
            double discountAmount = quantity * unitPrice - ((numberOfXs * y * unitPrice) + quantityAsInt % x * unitPrice);
            discount = new Discount(this.getProduct(), "3 for 2", discountAmount);
        }

        return discount;
	}
}
