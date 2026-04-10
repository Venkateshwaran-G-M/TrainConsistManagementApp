import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UC11Test {


    @Test
    void testValidTrainId() {
        assertTrue(UC11.isValidTrainId("TRN-1234"));
    }

    @Test
    void testInvalidTrainId_WrongFormat() {
        assertFalse(UC11.isValidTrainId("TRN1234"));
    }

    @Test
    void testInvalidTrainId_LessDigits() {
        assertFalse(UC11.isValidTrainId("TRN-123"));
    }

    @Test
    void testInvalidTrainId_ExtraDigits() {
        assertFalse(UC11.isValidTrainId("TRN-12345"));
    }

    // Cargo Code Tests

    @Test
    void testValidCargoCode() {
        assertTrue(UC11.isValidCargoCode("PET-AB"));
    }

    @Test
    void testInvalidCargoCode_Lowercase() {
        assertFalse(UC11.isValidCargoCode("PET-ab"));
    }

    @Test
    void testInvalidCargoCode_MoreLetters() {
        assertFalse(UC11.isValidCargoCode("PET-ABC"));
    }

    @Test
    void testInvalidCargoCode_WrongPrefix() {
        assertFalse(UC11.isValidCargoCode("CAR-AB"));
    }
}