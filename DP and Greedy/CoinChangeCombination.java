import java.io.*;
import java.util.*;

public class CoinChangeCombination {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int amt = scn.nextInt();


        int[] dp = new int[amt+1];

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                if(j==arr[i]){
                    dp[j]++;
                } else if(dp[j-arr[i]]>0){
                    dp[j]++;
                }
            }
        }

        System.out.println(dp[amt]);

    }

}