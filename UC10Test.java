import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UC10Test {

    private List<UC10.Bogie> getBogies() {
        List<UC10.Bogie> list = new ArrayList<>();
        list.add(new UC10.Bogie("Sleeper", 72));
        list.add(new UC10.Bogie("AC Chair", 56));
        list.add(new UC10.Bogie("First Class", 24));
        list.add(new UC10.Bogie("Sleeper", 70));
        return list;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int result = UC10.calculateTotalCapacity(getBogies());
        assertEquals(222, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int result = UC10.calculateTotalCapacity(getBogies());
        assertTrue(result > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UC10.Bogie> list = new ArrayList<>();
        list.add(new UC10.Bogie("Sleeper", 50));

        int result = UC10.calculateTotalCapacity(list);
        assertEquals(50, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = UC10.calculateTotalCapacity(new ArrayList<>());
        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<UC10.Bogie> list = getBogies();
        int result = UC10.calculateTotalCapacity(list);

        int expected = 72 + 56 + 24 + 70;
        assertEquals(expected, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int result = UC10.calculateTotalCapacity(getBogies());
        assertEquals(222, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UC10.Bogie> original = getBogies();
        List<UC10.Bogie> copy = new ArrayList<>(original);

        UC10.calculateTotalCapacity(original);

        assertEquals(copy.size(), original.size());
    }
}