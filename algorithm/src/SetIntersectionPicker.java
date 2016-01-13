import java.util.Arrays;

public class SetIntersectionPicker {
    private final int[] a1;
    private final int[] a2;

    public SetIntersectionPicker(int[] a1, int[] a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public int[] extractIntersection() {
        int[] intersection = new int[a1.length];
        int ind = 0;
        for(int i = 0; i < a1.length; i++){
            if(contains(a1[i], a2) && !contains(a1[i], intersection)){
                intersection[ind++] = a1[i];
            }
        }
        int[] result = new int[ind];
        System.arraycopy(intersection, 0, result, 0, ind);
        return result;
    }

    private boolean contains(int i, int[] a) {
        for(int e : a){
            if(i == e) {
                return true;
            }
        }
        return false;
    }
}
