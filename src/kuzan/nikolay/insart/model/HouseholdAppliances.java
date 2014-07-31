package kuzan.nikolay.insart.model;

/**
 * Created by Nikolay on 15.07.14.
 */
public abstract class HouseholdAppliances {
    private double price;
    private String productName;

    protected HouseholdAppliances(){
    }

    protected HouseholdAppliances(String productName, double price) {
        this.price = price;
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(double price) {
        recalculateTotalPrice(price);
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Recalculates total price of the all products when product price changes
     * by using set-methods
     *
     * @param newPrice new price of the product from set-method
     */
    protected abstract void recalculateTotalPrice(double newPrice);
}
