import java.io.*;
import java.util.*;

public class ClimbStairsMinimum {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                if(dp[i]==null){
                    dp[i] = dp[i+j];
                } else if(dp[i+j]!=null){
                    dp[i] = Math.min(dp[i], dp[i+j]);
                }
            }
            if(dp[i]!=null){
                dp[i]+=1;
            }
        }
        System.out.println(dp[0]);

    }

}