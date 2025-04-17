// JUnit 5 test class for MathUtils
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MathUtilsTest {
    @Test
    void testReverse() {
        assertEquals(321, MathUtils.reverse(123));
    }
    @Test
    void testReverseString() {
        assertEquals("olleh", MathUtils.reverseString("hello"));
    }
}
