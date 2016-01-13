import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SetIntersectionTest {
    @Test
    public void shouldExtractIntersection(){
        int[] a1 = {6,7,8,1,2,3};
        int[] a2 = {4,3,2,1,1};
        SetIntersectionPicker sitp = new SetIntersectionPicker(a1, a2);
        assertArrayEquals(new int[]{1,2,3}, sitp.extractIntersection());
    }


    @Test
    public void shouldNotHaveIntersectionFromExclusive2Arrays(){
        int[] a1 = {1,2,3};
        int[] a2 = {4,4,5,5,6,6};
        SetIntersectionPicker sitp = new SetIntersectionPicker(a1, a2);
        assertArrayEquals(new int[0], sitp.extractIntersection());
    }
}
