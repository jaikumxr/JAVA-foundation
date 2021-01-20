import java.io.*;
import java.util.*;

//Program to traverse a 2D Array in a Wave fashion.

public class TDAWaveTraversal {
    public static void waveTraversal(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < cols; i++) {
            if(i%2==0){
                for (int j = 0; j < rows; j++) {
                    System.out.println(arr[j][i]);
                }
            } else {
                for (int j = rows-1; j>=0; j--) {
                    System.out.println(arr[j][i]);
                }
            }
        }
    }
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
        waveTraversal(arr);
    }

}