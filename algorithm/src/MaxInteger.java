
public class MaxInteger {
    private final int[] integers;

    public MaxInteger(int[] integers) {
        this.integers = integers;
    }

    public int pickMax() {
        int max = 0;
        for(int i : integers)
            if(max < i)
                max = i;
        return max;
    }
}
