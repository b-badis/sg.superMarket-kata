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
public class ThreeForX extends Offer{
	public ThreeForX(OfferType offerType, Product product, double amountForDiscount) {
        super(OfferType.ThreeForAmount, product, amountForDiscount);
    }

    @Override
    public Discount calculateDiscountAmount(double quantity, double unitPrice){
        int x =3;
        Discount discount = null;
        int quantityAsInt = (int) quantity;

        if (quantityAsInt >= x) {
            double total = this.getAmountForDiscount() * (quantityAsInt / x) + (quantityAsInt % x) * unitPrice;
            double discountN = unitPrice * quantity - total;
            discount = new Discount(this.getProduct(), "3 for " + this.getAmountForDiscount(), discountN);
        }

        return discount;
    }


}
