package kuzan.nikolay.insart.model;

/**
 * Created by Nikolay on 15.07.14.
 */
public class Fridge extends HouseholdAppliances {

    // Price of the all created washing machines
    private static double totalPrice;

    // Count of the all created washing machines
    private static double count;

    private boolean freezerPresence;

    public Fridge() {
        count++;
    }

    public Fridge(String productName, double price, boolean freezerPresence) {
        super(productName, price);
        this.freezerPresence = freezerPresence;
        totalPrice = totalPrice + price;
        count++;
    }

    public boolean isFreezerPresence() {
        return freezerPresence;
    }

    public void setFreezerPresence(boolean freezerPresence) {
        this.freezerPresence = freezerPresence;
    }

    /**
     * Returns a string representation of the Fridge object
     */
    @Override
    public String toString() {
        return String.format("%-25s%-13s%-10s%-10s%-20s%-6s", "| Fridge name:", getProductName(),
                "| price:", getPrice(), "| freezer precence:", isFreezerPresence())+" |";
    }

    /**
     * Recalculates total price of the all fridges when fridge
     * price changes by using set-method
     *
     * @param newPrice new price of the fridge from set-method
     */
    @Override
    protected void recalculateTotalPrice(double newPrice) {
        totalPrice = totalPrice - getPrice() + newPrice;
    }

    /**
     * Returns average price of the created fridges if at least
     * one element has been created
     *
     * @return average price of the created fridges
     * @throws Exception if count of the created instances of this class = 0
     */
    public static double getAveragePrice() throws Exception {
        if (count != 0){
            return totalPrice/count;
        } else {
            throw new Exception("Count of created elements = 0. It must be > 0 for calculating average price.");
        }
    }
}
