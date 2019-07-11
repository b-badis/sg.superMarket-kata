/**
 * 
 */
package sg.supermarket_kata;

import java.math.BigDecimal;

/**
 * @author Badis
 *
 */
public class Item {
    private final Product product;
    private final BigDecimal price;
    private BigDecimal totalPrice;
    private final BigDecimal quantity;

    public Item(Product p, BigDecimal quantity, BigDecimal price, BigDecimal totalPrice) {
        this.product = p;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

}
