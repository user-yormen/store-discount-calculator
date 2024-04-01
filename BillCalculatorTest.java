import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillCalculatorTest {
    private final BillCalculator calculator = new BillCalculator();

    @Test
    public void testEmployeeDiscount() {
        double actual = calculator.calculateNetPayableAmount(100, true, 
false, false, false);
        assertEquals(70, actual);
    }

    @Test
    public void testAffiliateDiscount() {
        double actual = calculator.calculateNetPayableAmount(100, false, 
true, false, false);
        assertEquals(90, actual);
    }

    @Test
    public void testCustomerDiscount() {
        double actual = calculator.calculateNetPayableAmount(100, false, 
false, true, false);
        assertEquals(95, actual);
    }

    @Test
    public void testAmountDiscount() {
        double actual = calculator.calculateNetPayableAmount(1000, false, 
false, false, false);
        assertEquals(950, actual);
    }

    @Test
    public void testGroceryDiscount() {
        double actual = calculator.calculateNetPayableAmount(100, false, 
false, false, true);
        assertEquals(100, actual);
    }

    @Test
    public void testMultipleDiscounts() {
        double actual = calculator.calculateNetPayableAmount(1000, true, 
false, true, false);
        assertEquals(850, actual);
    }
}

