import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContestTableTest {
    @Test
    public void test(){
        // Mth line has M length
        // Lth symbol : M이 L을 이기면 '+', 지면 '-'
        String[] lines = {"#","+#", "-+#", "-+-#"}; // 2번은 1번을 이김, 3번은 1번에 지고, 2번에 이김, 4번은 1번에 지고, 2번에 이기고, 3번에 짐
        ContestTable ct = new ContestTable(lines);

        assertEquals("1 3 4 2", ct.contest());
    }
    @Test
    public void test2(){
        // Mth line has M length
        // Lth symbol : M이 L을 이기면 '+', 지면 '-'
        String[] lines = {"#","+#", "-+#", "-+-#"};
        ContestTable ct = new ContestTable(lines);

        assertEquals("1 3 4 2", ct.contest());
    }

}
