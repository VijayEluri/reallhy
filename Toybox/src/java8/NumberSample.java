package java8;

public class NumberSample {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        long maxUnsignedInt = (1L << 32) - 1;
        System.out.println(maxUnsignedInt);
        String string = String.valueOf(maxUnsignedInt);
        int unsignedInt = Integer.parseUnsignedInt(string, 10);
        System.out.println(unsignedInt);
        try {
            Integer.parseInt(string, 10);
        } catch(NumberFormatException e){
            System.err.println("could not parse signed int of " + maxUnsignedInt);
        }

        String string2 = Integer.toUnsignedString(unsignedInt, 10);
        System.out.println(string2);

    }
}
