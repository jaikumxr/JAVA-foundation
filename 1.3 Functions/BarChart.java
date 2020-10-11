import java.io.*;
import java.util.*;

public class BarChart{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] x;
        x = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            x[i] = scn.nextInt();
            if(x[i]>max){
                max = x[i];
            }
        }
        for(int i = 0;i<max;i++){
            for(int j = 0;j<n;j++){
                if(x[j]>=max-i){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

 }

}