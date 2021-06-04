import java.io.*;
import java.util.*;

public class TargetSumSubset {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int t = scn.nextInt();


        Boolean[][] dp = new Boolean[n+1][t+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j==0){
                    dp[i][j] = true;
                } else if(i>0){
                    if(dp[i-1][j]==true){
                        dp[i][j] = true;
                    } else if(j>=arr[i-1]){
                        if(dp[i-1][j-arr[i-1]]==true){
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if(dp[i][t]==true){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

}