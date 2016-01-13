import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    int[] array = {1, 12, 5, 26, 7, 14, 8, 2, 3, 7};
    QuickSort qs = new QuickSort();
    @Test
    public void sort(){
        System.out.println(Arrays.toString(array));
        qs.sort(array);
        System.out.println(Arrays.toString(array));
        assertEquals(26, array[array.length - 1]);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
    }
}
