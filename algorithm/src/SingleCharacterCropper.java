import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SingleCharacterCropper {
    private final Stream stream;

    private final Set<Character> singleCharacters = new LinkedHashSet<>();
    private final Set<Character> characters = new LinkedHashSet<>();

    public SingleCharacterCropper(Stream stream) {
        this.stream = stream;
    }

    public void cropSingleCharacters() {
        if(stream == null) return;
        while(stream.hasNext()){
            char next = stream.getNext();
            if(characters.contains(next)){
                singleCharacters.remove(next);
            } else{
                characters.add(next);
                singleCharacters.add(next);
            }
        }
    }

    public Character getFirstFromStream() {
        if(singleCharacters.isEmpty()) cropSingleCharacters();
        Character[] array = singleCharacters.toArray(new Character[0]);
        return (array.length == 0)? null : array[0];
    }
}
