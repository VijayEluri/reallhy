public class SimpleStream implements Stream {
    private final char[] word;
    private int position;

    public SimpleStream(String word) {
        this.word = word.toCharArray();
    }

    @Override
    public boolean hasNext() {
        return position != word.length;
    }

    @Override
    public char getNext() {
        return word[position++];
    }
}
