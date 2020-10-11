import java.io.*;
import java.util.*;

public class DifferenceOfArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for(int i = 0;i<n1;i++){
            a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for(int i = 0;i<n2;i++){
            a2[i] = scn.nextInt();
        }

        int[] diff = new int[n2];

        int c = 0;
        int i = a1.length-1;
        int j = a2.length-1;
        int k = diff.length-1;

        while(k>=0){
            int d = c;
            if(i>=0){
                d -= a1[i];
            }

            d += a2[j];

            if(d<0){
                d = d+10;
                c=-1;
            } else {
                c = 0;
            }

            diff[k] = d;
            i--;
            j--;
            k--;
        }

        if(c>0){
            System.out.println(c);
        }
        
        int leadremove = 0;
        for(int val: diff){
            if(val==0){
                if(leadremove==0){
                    leadremove = 1;
                } else {
                    System.out.println(val);
                }
            } else {
                System.out.println(val);
            }
        }

    }

}