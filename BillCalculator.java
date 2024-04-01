public class BillCalculator {
    private static final double EMPLOYEE_DISCOUNT_RATE = 0.30;
    private static final double AFFILIATE_DISCOUNT_RATE = 0.10;
    private static final double CUSTOMER_DISCOUNT_RATE = 0.05;
    private static final double AMOUNT_DISCOUNT_RATE = 0.05;
    private static final double AMOUNT_DISCOUNT_THRESHOLD = 100.0;

    public double calculateNetPayableAmount(double billAmount, boolean 
isEmployee, boolean isAffiliate, boolean isCustomer, boolean isGrocery) {
        double netAmount = billAmount;

        if (isEmployee)
            netAmount = applyEmployeeDiscount(netAmount);
        else if (isAffiliate)
            netAmount = applyAffiliateDiscount(netAmount);
        else if (isCustomer)
            netAmount = applyCustomerDiscount(netAmount);

        if (!isGrocery) {
            netAmount = applyAmountDiscount(netAmount);
        }

        return netAmount;
    }

    private double applyEmployeeDiscount(double amount) {
        return amount - (amount * EMPLOYEE_DISCOUNT_RATE);
    }

    private double applyAffiliateDiscount(double amount) {
        return amount - (amount * AFFILIATE_DISCOUNT_RATE);
    }

    private double applyCustomerDiscount(double amount) {
        return amount - (amount * CUSTOMER_DISCOUNT_RATE);
    }

    private double applyAmountDiscount(double amount) {
        return amount - ((int) (amount / AMOUNT_DISCOUNT_THRESHOLD) * 
AMOUNT_DISCOUNT_RATE * AMOUNT_DISCOUNT_THRESHOLD);
    }

    private double applyGroceryDiscount(double amount) {
        return amount;
    }
}

