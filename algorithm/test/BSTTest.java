import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BSTTest {
    BST bst = new BST();
    @Test
    public void bstPutAndGet(){
        bst.put(1,10);
        bst.put(3,30);
        bst.put(5,50);
        bst.put(2,20);
        bst.put(-1,-10);
        assertEquals(20, bst.get(2));
    }
}
