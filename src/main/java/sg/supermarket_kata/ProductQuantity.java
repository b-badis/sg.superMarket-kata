/**
 * 
 */
package sg.supermarket_kata;

/**
 * @author Badis
 *
 */
public class ProductQuantity {
    private final Product product;
    private final double quantity;

    public ProductQuantity(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }
}
