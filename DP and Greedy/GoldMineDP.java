import java.io.*;
import java.util.*;

public class GoldMineDP {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();        
            }
        }

        for (int x = 0; x < n; x++) {
            dp[x][m-1] = arr[x][m-1];
        }


        for (int j = m-2; j>=0; j--) {
            for (int i = n-1; i>=0; i--) {
                if(i==n-1){
                    dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j+1]) + arr[i][j];
                } else if(i==0){
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1]) + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1])) + arr[i][j];
                }
            }
        }

        int max = dp[0][0];

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i][0], max);
        }

        System.out.println(max);

    }

}