import java.io.*;
import java.util.*;

//Program to traverse a 2D Array in a Spiral fashion.

public class TDASpiralTraversal {
//take one, close, not accepted
    // public static void spiralTraversal(int[][] arr){
    //     int rows = arr.length;
    //     int cols = arr[0].length;
    //     int dir = 0;
    //     while(rows>0 || cols>0){
    //         if(dir%4==0){
    //             int col = arr[0].length-cols;
    //             for (int i = arr.length-rows; i < rows; i++) {
    //                 System.out.println(arr[i][col]);
    //             }
    //             cols--;
    //             dir++;
    //         } else if(dir%4==1){
    //             int row = rows;
    //             for (int i = cols; i>=0 ; i--) {
    //                 System.out.println(arr[row][i]);
    //             }
    //             rows--;
    //             dir++;
    //         } else if(dir%4==2){
    //             int col = cols;
    //             for (int i = rows; i >= 0; i--) {
    //                 System.out.println(arr[i][col]);
    //             }
    //             cols--;
    //             dir++;
    //         } else {
    //             int row = arr.length-rows;
    //             for (int i = arr[0].length-cols; i < cols; i++) {
    //                 System.out.println(arr[row][i]);
    //             }
    //             rows--;
    //             dir++;
    //         }
    //     }
    // }

//take two - Sumeet Sir's method

    public static void spiralTraversal(int[][] arr){
        int maxr = arr.length-1;
        int maxc = arr[0].length-1;
        int minr = 0;
        int minc = 0;



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
        spiralTraversal(arr);
    }

}