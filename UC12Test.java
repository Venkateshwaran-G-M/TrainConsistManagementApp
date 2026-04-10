import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class UC12Test {

    @Test
    void testSafety_AllBogiesValid() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();
        list.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new UseCase12TrainConsistMgmt.GoodsBogie("Open", "Coal"));

        boolean result = UseCase12TrainConsistMgmt.isTrainSafe(list);

        assertTrue(result);
    }

    @Test
    void testSafety_InvalidCylindricalCargo() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();
        list.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal"));

        boolean result = UseCase12TrainConsistMgmt.isTrainSafe(list);

        assertFalse(result);
    }

    @Test
    void testSafety_MixedBogiesOneInvalid() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();
        list.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Petroleum"));
        list.add(new UseCase12TrainConsistMgmt.GoodsBogie("Cylindrical", "Coal"));

        boolean result = UseCase12TrainConsistMgmt.isTrainSafe(list);

        assertFalse(result);
    }

    @Test
    void testSafety_NonCylindricalFlexible() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();
        list.add(new UseCase12TrainConsistMgmt.GoodsBogie("Box", "Anything"));

        boolean result = UseCase12TrainConsistMgmt.isTrainSafe(list);

        assertTrue(result);
    }

    @Test
    void testSafety_EmptyList() {
        List<UseCase12TrainConsistMgmt.GoodsBogie> list = new ArrayList<>();

        boolean result = UseCase12TrainConsistMgmt.isTrainSafe(list);

        assertTrue(result); // no violations
    }
}