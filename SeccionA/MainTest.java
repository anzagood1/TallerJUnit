import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testFindMaxWithPositiveAndNegativeNumbers() {
        int[] arr = {3, -1, 9, -5, 7};
        assertEquals(9, Main.findMax(arr));
    }

    @Test
    public void testFindMaxWithOnlyNegativeNumbers() {
        int[] arr = {-3, -7, -2, -5};
        assertEquals(-2, Main.findMax(arr));
    }

    @Test
    public void testFindMaxWithOneNumber() {
        int[] arr = {4};
        assertEquals(4, Main.findMax(arr));
    }

    @Test
    public void testFindMaxWithEmptyArray() {
        int[] arr = {};
        assertEquals(Integer.MIN_VALUE, Main.findMax(arr));
    }
}
