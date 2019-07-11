/**
 * 
 */
package sg.supermarket_kata;

import java.math.BigDecimal;

/**
 * @author Badis
 *
 */
public class ProductQuantity {
    private final Product product;
    private final BigDecimal quantity;

    public ProductQuantity(Product product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
