import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UC14Test {

    @Test
    void testException_ValidCapacityCreation() {
        try {
            UC14.PassengerBogie bogie =
                    new UC14.PassengerBogie("Sleeper", 70);

            assertNotNull(bogie);
            assertEquals(70, bogie.capacity);

        } catch (Exception e) {
            fail("Exception should not be thrown for valid capacity");
        }
    }

    @Test
    void testException_ZeroCapacity() {
        Exception exception = assertThrows(
                UC14.InvalidCapacityException.class,
                () -> {
                    new UC14.PassengerBogie("General", 0);
                }
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_NegativeCapacity() {
        Exception exception = assertThrows(
                UC14.InvalidCapacityException.class,
                () -> {
                    new UC14.PassengerBogie("AC", -10);
                }
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_MessageValidation() {
        Exception exception = assertThrows(
                UC14.InvalidCapacityException.class,
                () -> {
                    new UC14.PassengerBogie("Test", 0);
                }
        );

        assertTrue(exception.getMessage().contains("greater than zero"));
    }
}