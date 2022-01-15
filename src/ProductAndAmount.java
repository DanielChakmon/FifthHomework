public class ProductAndAmount {
    private final Product product;
    private int amount;

    public ProductAndAmount(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public String toString() {
        return product.toString() + " \n" +
                "  -amount: " + amount;
    }
}
