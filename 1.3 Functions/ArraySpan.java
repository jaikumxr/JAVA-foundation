import java.io.*;
import java.util.*;

public class ArraySpan {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] x;
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scn.nextInt();
        }
        int s;
        int g;
        s = g = x[0];
        for (int i = 0; i < n; i++) {
            if (x[i] > g) {
                g = x[i];
            }
            if (x[i] < s) {
                s = x[i];
            }
        }
        System.out.println(g - s);

    }

}