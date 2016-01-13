package partsum;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if(sum < 0) sum = arr[i];
            else sum += arr[i];
            if (sum > max) max = sum;

        }
        System.out.println(max);
    }
}
