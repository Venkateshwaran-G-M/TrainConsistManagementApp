import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UC9Test {

    private List<UC9.Bogie> getBogies() {
        List<UC9.Bogie> list = new ArrayList<>();
        list.add(new UC9.Bogie("Sleeper", 72));
        list.add(new UC9.Bogie("AC Chair", 56));
        list.add(new UC9.Bogie("First Class", 24));
        list.add(new UC9.Bogie("Sleeper", 70));
        list.add(new UC9.Bogie("AC Chair", 60));
        return list;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<UC9.Bogie>> result =
                UC9.groupBogiesByType(getBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<UC9.Bogie>> result =
                UC9.groupBogiesByType(getBogies());

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<UC9.Bogie>> result =
                UC9.groupBogiesByType(getBogies());

        assertEquals(3, result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<UC9.Bogie>> result =
                UC9.groupBogiesByType(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<UC9.Bogie> list = new ArrayList<>();
        list.add(new UC9.Bogie("Sleeper", 72));
        list.add(new UC9.Bogie("Sleeper", 70));

        Map<String, List<UC9.Bogie>> result =
                UC9.groupBogiesByType(list);

        assertEquals(1, result.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<UC9.Bogie>> result =
                UC9.groupBogiesByType(getBogies());

        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<UC9.Bogie>> result =
                UC9.groupBogiesByType(getBogies());

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<UC9.Bogie> original = getBogies();
        List<UC9.Bogie> copy = new ArrayList<>(original);

        UC9.groupBogiesByType(original);

        assertEquals(copy.size(), original.size());
    }
}