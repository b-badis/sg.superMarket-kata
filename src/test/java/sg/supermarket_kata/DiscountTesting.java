/**
 * 
 */
package sg.supermarket_kata;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    	Bill bill = setCaracteristicsForTestOffer(new BigDecimal(3), OfferType.ThreeForTwo, new BigDecimal(800.0));
    	BigDecimal expectedResult = new BigDecimal(2*400.0);
    	expectedResult=expectedResult.setScale(2, RoundingMode.CEILING);
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
    
    @Test
    public void testThreeForTwoOfferIfQuantityInferiorTo2(){
    	Bill bill = setCaracteristicsForTestOffer(new BigDecimal(1), OfferType.ThreeForTwo, new BigDecimal(400.0));
    	BigDecimal expectedResult = new BigDecimal(400.0);
    	expectedResult=expectedResult.setScale(2, RoundingMode.CEILING);
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
     
    @Test
    public void testThreeForAmountOffer(){
    	Bill bill = setCaracteristicsForTestOffer(new BigDecimal(4), OfferType.ThreeForAmount, new BigDecimal(1000.0));
    	BigDecimal expectedResult = new BigDecimal(1400.0);
    	expectedResult=expectedResult.setScale(2, RoundingMode.CEILING);
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
    
    @Test
	public void testThreeForAmountIfQuantityInferiorTo3 () {
    	Bill bill = setCaracteristicsForTestOffer(new BigDecimal(1), OfferType.ThreeForAmount,new BigDecimal(400.0));
    	BigDecimal expectedResult = new BigDecimal(400.0);
    	expectedResult=expectedResult.setScale(2, RoundingMode.CEILING);
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
	}
  
    @Test
    public void testDiscountIsNull () {
    	catalog.addProduct(canOfBeans, new BigDecimal(400.0));
        cart.addItemQuantity(canOfBeans, new BigDecimal(5));        
        Bill bill = marketOwner.extractBill(cart);
        List<Discount> discounts = bill.getDiscounts();
        Assertions.assertTrue(discounts.isEmpty());
    }
    
    @Test
    public void testWithoutDiscount () {
    	catalog.addProduct(canOfBeans, new BigDecimal(400.0));
        cart.addItemQuantity(canOfBeans, new BigDecimal(5));        
        Bill bill = marketOwner.extractBill(cart);
        BigDecimal expectedResult = new BigDecimal(2000.0);
        expectedResult=expectedResult.setScale(2, RoundingMode.CEILING);
        Assertions.assertEquals(expectedResult, bill.getTotalPrice());
    }
    
    private Bill setCaracteristicsForTestOffer(BigDecimal quantity, OfferType offerType, BigDecimal discountPrice) {
    	catalog.addProduct(canOfBeans, new BigDecimal(400));
        cart.addItemQuantity(canOfBeans, quantity);
        marketOwner.addOffer(offerType, canOfBeans, discountPrice);
        Bill bill = marketOwner.extractBill(cart);
        
        return bill;
    }
}
