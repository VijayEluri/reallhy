import org.junit.Test;

import static org.junit.Assert.*;

public class MaxIntegerTest {
    @Test
    public void shouldGetMaxInteger() {
        int[] integers = new int[]{1,2,3,4,5,1};
        MaxInteger mi = new MaxInteger(integers);
        assertEquals(5, mi.pickMax());
    }
}
