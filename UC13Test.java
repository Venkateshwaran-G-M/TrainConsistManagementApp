import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class UC13Test {

    @Test
    void testLoopFilteringLogic() {
        List<UC13.Bogie> list = new ArrayList<>();
        list.add(new UC13.Bogie("A", 50));
        list.add(new UC13.Bogie("B", 70));

        List<UC13.Bogie> result =
                UC13.filterUsingLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<UC13.Bogie> list = new ArrayList<>();
        list.add(new UC13.Bogie("A", 40));
        list.add(new UC13.Bogie("B", 80));

        List<UC13.Bogie> result =
                UC13.filterUsingStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testResultsConsistencyBetweenLoopAndStream() {
        List<UC13.Bogie> list = new ArrayList<>();
        list.add(new UC13.Bogie("A", 30));
        list.add(new UC13.Bogie("B", 90));

        List<UC13.Bogie> loopResult =
                UC13.filterUsingLoop(list);

        List<UC13.Bogie> streamResult =
                UC13.filterUsingStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testEmptyListHandling() {
        List<UC13.Bogie> list = new ArrayList<>();

        List<UC13.Bogie> loopResult =
                UC13.filterUsingLoop(list);

        List<UC13.Bogie> streamResult =
                UC13.filterUsingStream(list);

        assertTrue(loopResult.isEmpty());
        assertTrue(streamResult.isEmpty());
    }
}