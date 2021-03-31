import java.io.*;
import java.util.*;

public class ClimbStairs {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(countPaths(n));
    }

    public static int countPaths(int n) {
        if(n==1){
            return 1;
        } else if(n==2){
            return 2;
        } else if(n==3){
            return 4;
        }

        int nm1 = countPaths(n-1);
        int nm2 = countPaths(n-2);
        int nm3 = countPaths(n-3);
        int cp = nm1 + nm2 + nm3;

        return cp;
    }

}