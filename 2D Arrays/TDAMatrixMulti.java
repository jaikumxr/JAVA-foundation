import java.io.*;
import java.util.*;

public class TDAMatrixMulti {
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
        int m = scn.nextInt();
                int n = scn.nextInt();
                int[][] arr2 = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        arr2[i][j]=scn.nextInt();
                    }
                }
                if (m!=l) {
                    System.out.println("Invalid input");
                } else {
                    int[][] arr3 = new int[arr.length][arr2[0].length];
        
                    for (int i = 0; i < arr3.length; i++) {
                        for (int j = 0; j < arr3[0].length; j++) {
                            int ele = 0;
                            for (int i1 = 0; i1<m; i1++) {
                                ele+=arr[i][i1]*arr2[i1][j];
                            }
                            arr3[i][j] = ele;
                        }
                    }
        
                    for (int i = 0; i < arr3.length; i++) {
                        for (int j = 0; j < arr3[0].length; j++) {
                            System.out.print(arr3[i][j]+" ");
                        }
                        System.out.println();
                    }
                }
    }

}
