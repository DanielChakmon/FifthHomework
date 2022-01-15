public class Product {
    private String productTitle;
    private double price;
    private double percentageOfDiscountForCustomerClubMembers;
    private boolean inStock;

    public Product(String productTitle, double price, double percentageOfDiscountForCustomerClubMembers) {
        this.inStock = true;
        this.percentageOfDiscountForCustomerClubMembers = percentageOfDiscountForCustomerClubMembers;
        this.productTitle = productTitle;
        this.price = price;
    }

    public double getPrice(User buyer) {
        if (buyer instanceof Worker) {
            return (price - price * (((Worker) buyer).getWorkerRank()) * 0.10);
        } else {
            if (((Customer) buyer).isInCustomerClub()) {
                return price - price * percentageOfDiscountForCustomerClubMembers*0.01;
            } else {
                return price;
            }
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getPercentageOfDiscountForCustomerClubMembers() {
        return percentageOfDiscountForCustomerClubMembers;
    }

    public void setPercentageOfDiscountForCustomerClubMembers(double percentageOfDiscountForCustomerClubMembers) {
        this.percentageOfDiscountForCustomerClubMembers = percentageOfDiscountForCustomerClubMembers;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String toString() {
        return "*" + productTitle + "*" + ": \n" +
                "  -price: " + price + " \n" +
                "  -discount rate for customer club members:  " + percentageOfDiscountForCustomerClubMembers;
    }
}
