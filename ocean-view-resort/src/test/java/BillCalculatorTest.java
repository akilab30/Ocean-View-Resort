

import com.oceanview.util.BillCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillCalculatorTest {

    @Test
    void testSingleRoomBill() {
        double bill = BillCalculator.calculateBill(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 4),
                "Single");

        assertEquals(15000, bill);
    }

    @Test
    void testDeluxeRoomBill() {
        double bill = BillCalculator.calculateBill(
                LocalDate.of(2025, 2, 10),
                LocalDate.of(2025, 2, 12),
                "Deluxe");

        assertEquals(24000, bill);
    }
}