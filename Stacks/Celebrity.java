import java.io.*;
import java.util.*;

public class Celebrity {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr, n);

    }

    public static void findCelebrity(int[][] arr, int n) {
            Stack<Integer> st = new Stack<>();
            for(int i = 0;i<n;i++){
                st.push(i);
            }
            while(st.size()>=2){
                int v1 = st.pop();
                int v2 = st.pop();
                if(arr[v1][v2]==0){
                    st.push(v1);
                } else {
                    st.push(v2);
                }
            }
            int pot = st.pop();
            for(int i = 0;i<n;i++){
                if(i!=pot){
                    if(arr[i][pot]==0 || arr[pot][i]==1){
                        System.out.println("none");
                        return;
                    }
                }
            }
            System.out.println(pot);
    }

}