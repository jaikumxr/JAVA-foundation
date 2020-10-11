import java.io.*;
import java.util.*;

public class FindIndex{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] x;
        x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = scn.nextInt();
        }
        int f = scn.nextInt();
        for(int i = 0; i<n;i++){
            if(x[i]==f){
                System.out.println(i);
                break;
            }
        }
    }

}