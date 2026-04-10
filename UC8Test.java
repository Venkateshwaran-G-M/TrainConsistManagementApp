import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UC8 {

    private List<UseCase8TrainConsistMgmnt.Bogie> getSampleBogies() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("General", 90));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogiesByCapacity(getSampleBogies(), 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogiesByCapacity(getSampleBogies(), 72);

        assertTrue(result.stream().noneMatch(b -> b.capacity == 72));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogiesByCapacity(getSampleBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogiesByCapacity(getSampleBogies(), 50);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogiesByCapacity(getSampleBogies(), 200);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogiesByCapacity(getSampleBogies(), 10);

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmnt.Bogie> result =
                UseCase8TrainConsistMgmnt.filterBogiesByCapacity(new ArrayList<>(), 50);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmnt.Bogie> original = getSampleBogies();
        List<UseCase8TrainConsistMgmnt.Bogie> copy = new ArrayList<>(original);

        UseCase8TrainConsistMgmnt.filterBogiesByCapacity(original, 60);

        assertEquals(copy.size(), original.size());
    }
}