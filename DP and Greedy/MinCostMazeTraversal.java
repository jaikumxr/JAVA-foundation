import java.io.*;
import java.util.*;

public class MinCostMazeTraversal {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scn.nextInt();        
            }
        }

        dp[n-1][m-1] = maze[n-1][m-1];

//take one - accepted, 1.3s

        for (int i = n-1; i>=0; i--) {
            for (int j = m-1; j>=0; j--) {
                int x,y;
                if(i+1==n){
                    x = Integer.MAX_VALUE;
                } else {
                    x = dp[i+1][j];
                }
                if(j+1==m){
                    y = Integer.MAX_VALUE;
                } else {
                    y = dp[i][j+1];
                }
                if(!(i==n-1 && j==m-1)){
                    dp[i][j] = Math.min(x, y) + maze[i][j];
                }
            }
        }

        //prefer using 4 if-else blocks 

        System.out.println(dp[0][0]);

    }

}