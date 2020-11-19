import java.io.*;
import java.util.*;

public class SlidingWindowMax{
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + "\n");
        }
        System.out.println(sb);
      }    

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
    
    int[] nge = new int[a.length];
    Stack<Integer> st = new Stack<>();
    st.push(a.length-1);
    nge[a.length-1] = a.length;
    for(int i=a.length-2;i>=0;i--){
        while(st.size()>0 && a[i]>=a[st.peek()]){
            st.pop();
        }
        if(st.size()==0){
            nge[i]=a.length;
        } else {
            nge[i]=st.peek();
        }
        st.push(i);
    }
    
    int j = 0;
    int[] max = new int[a.length];
    for(int i = 0;i<max.length-k+1;i++){
        if(j<i){
            j=i;
        }
        while(nge[j]<=i+k-1){
            j=nge[j];
        }
        System.out.println(j);
    }
 }
}