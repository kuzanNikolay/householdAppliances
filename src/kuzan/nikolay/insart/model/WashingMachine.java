package kuzan.nikolay.insart.model;

/**
 * Created by Nikolay on 15.07.14.
 */
public class WashingMachine extends HouseholdAppliances {

    // Price of the all created washing machines
    private static double totalPrice;

    // Count of the all created washing machines
    private static double count;

    private int maxSpinSpeed;

    public WashingMachine() {
        count++;
    }

    public WashingMachine(String productName, double price, int maxSpinSpeed) {
        super(productName, price);
        this.maxSpinSpeed = maxSpinSpeed;
        totalPrice = totalPrice + price;
        count++;
    }

    public int getMaxSpinSpeed() {
        return maxSpinSpeed;
    }

    public void setMaxSpinSpeed(int maxSpinSpeed) {
        this.maxSpinSpeed = maxSpinSpeed;
    }

    /**
     * Returns a string representation of the WashingMachine object
     */
    @Override
    public String toString() {
        String result = String.format("%-25s%-13s%-10s%-10s%-20s%-6s", "| Washing machine name:", getProductName(), "| price:", getPrice(), "| max spin speed:", getMaxSpinSpeed())+" |";
        return result;
    }

    /**
     * Recalculates total price of the all washing machines when washing machine
     * price changes by using set-method
     *
     * @param newPrice new price of the washing machine from set-method
     */
    @Override
    protected void recalculateTotalPrice(double newPrice) {
        totalPrice = totalPrice - getPrice() + newPrice;
    }

    /**
     *  Returns average price of the created washing machines
     *  if at least one element has been created
     *
     * @return average price of the created washing machines
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