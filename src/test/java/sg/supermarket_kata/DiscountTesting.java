/**
 * 
 */
package sg.supermarket_kata;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import sg.supermarket_kata.enums.OfferType;
import sg.supermarket_kata.enums.ProductUnit;
/**
 * @author Badis
 *
 */

public class DiscountTesting extends TestCase{

	private MarketCatalogue catalog = new MarketCatalogue();
    private Product canOfBeans = new Product("canOfBeans", ProductUnit.Each);
    private Cart cart = new Cart();
    private MarketOwner marketOwner = new MarketOwner(catalog);

    
    @Test
    public void testThreeForTwoOffer(){
    	Bill bill = setCaracteristicsForTestOffer(3, OfferType.ThreeForTwo, 800.0);
        Double expectedResult = 2*400.0;
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
    
    @Test
    public void testThreeForTwoOfferIfQuantityInferiorTo2(){
    	Bill bill = setCaracteristicsForTestOffer(1, OfferType.ThreeForTwo, 400.0);
        Double expectedResult = 400.0;
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
     
    @Test
    public void testThreeForAmountOffer(){
    	Bill bill = setCaracteristicsForTestOffer(4, OfferType.ThreeForAmount, 1000.0);
        Double expectedResult = 1400.0;
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
    
    @Test
	public void testThreeForAmountIfQuantityInferiorTo3 () {
    	Bill bill = setCaracteristicsForTestOffer(1, OfferType.ThreeForAmount,400.0);
        Double expectedResult = 400.0;
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
	}
  
    @Test
    public void testDiscountIsNull () {
    	catalog.addProduct(canOfBeans, 400.0);
        cart.addItemQuantity(canOfBeans, 5);        
        Bill bill = marketOwner.extractBill(cart);
        List<Discount> discounts = bill.getDiscounts();
        Assertions.assertTrue(discounts.isEmpty());
    }
    
    @Test
    public void testWithoutDiscount () {
    	catalog.addProduct(canOfBeans, 400.0);
        cart.addItemQuantity(canOfBeans, 5);        
        Bill bill = marketOwner.extractBill(cart);
        Double expectedResult = 2000.0;
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
    
    private Bill setCaracteristicsForTestOffer(double quantity, OfferType offerType, double discountPrice) {
    	catalog.addProduct(canOfBeans, 400);
        cart.addItemQuantity(canOfBeans, quantity);
        marketOwner.addOffer(offerType, canOfBeans, discountPrice);
        Bill bill = marketOwner.extractBill(cart);
        
        return bill;
    }
}
