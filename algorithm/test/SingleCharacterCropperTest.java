import org.junit.Test;

import static junit.framework.Assert.*;

public class SingleCharacterCropperTest {

    @Test
    public void shouldRemoveWhenSetContainsCharaceterAndAddWhenNotContains() {
        String word = "aAbBABac";
        SingleCharacterCropper characterCropper = new SingleCharacterCropper(new SimpleStream(word));
        characterCropper.cropSingleCharacters();
    }

    @Test
    public void shouldGetFirstSingleCharacterFromWord1() {
        String word = "aAbBABac";
        SingleCharacterCropper singleCharacterCropper = new SingleCharacterCropper(new SimpleStream(word));
        assertEquals(new Character('b'), singleCharacterCropper.getFirstFromStream());
    }


    @Test
    public void shouldGetFirstSingleCharacterFromWord2() {
        String word = "aAbbbBABac";
        SingleCharacterCropper singleCharacterCropper = new SingleCharacterCropper(new SimpleStream(word));
        assertEquals(new Character('c'), singleCharacterCropper.getFirstFromStream());
    }

    @Test
    public void shouldGetNullFromAllDuplicatedCharacters() {
        String word = "aaaaaaaaAAAAAAAAAAAAAAAAccc";
        SingleCharacterCropper singleCharacterCropper = new SingleCharacterCropper(new SimpleStream(word));
        assertEquals(null, singleCharacterCropper.getFirstFromStream());
    }


}
