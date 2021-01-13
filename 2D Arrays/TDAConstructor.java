import java.io.*;
import java.util.*;

public class TDAConstructor {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int l = scn.nextInt();
        int[][] arr = new int[k][l];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                arr[i][j]=scn.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}