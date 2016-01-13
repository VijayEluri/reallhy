import org.junit.Test;

import static junit.framework.Assert.*;

public class StreamTest {

    @Test
    public void shouldHasNextReturnFalseWhenWordILength0() {
        Stream stream2 = new SimpleStream("");
        assertFalse(stream2.hasNext());
    }

    @Test
    public void shouldHasNextReturnFalseWhenEndOfCharactersReached() {
        String word = "aAbBABac";
        Stream stream = new SimpleStream(word);
        for(int i = 0; i < word.length(); i++){
            assertTrue(stream.hasNext());
            stream.getNext();
        }
        assertFalse(stream.hasNext());
    }

    @Test
    public void shouldGetNextReturnCharacterAtTheRightPosition() {
        String word = "aAbBABac";
        Stream stream = new SimpleStream(word);
        assertEquals('a', stream.getNext());
        assertEquals('A', stream.getNext());
        assertEquals('b', stream.getNext());
        assertEquals('B', stream.getNext());
        assertEquals('A', stream.getNext());
        assertEquals('B', stream.getNext());
        assertEquals('a', stream.getNext());
        assertEquals('c', stream.getNext());
    }


}
