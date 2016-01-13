package java8;


public class MathSamples {
    public static void main(String[] args) {
        try {
            Math.addExact(Integer.MAX_VALUE, 1);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

        try {
            Math.toIntExact(Long.MAX_VALUE);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }

    }
}
