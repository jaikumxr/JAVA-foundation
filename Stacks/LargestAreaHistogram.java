import java.io.*;
import java.util.*;

public class LargestAreaHistogram{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] ngr = new int[a.length];
    Stack<Integer> st = new Stack<>();
    st.push(a.length-1);
    ngr[a.length-1] = -1;
    for(int i=a.length-2;i>=0;i--){
        while(st.size()>0 && a[i]<=a[st.peek()]){
            st.pop();
        }
        if(st.size()==0){
            ngr[i]=-1;
        } else {
            ngr[i]=st.peek();
        }
        st.push(i);
    }

    int[] ngl = new int[a.length];
    Stack<Integer> st1 = new Stack<>();
    st1.push(a.length-1);
    ngl[a.length-1] = -1;
    for(int i=a.length-2;i>=0;i--){
        while(st1.size()>0 && a[i]>=a[st1.peek()]){
            st1.pop();
        }
        if(st1.size()==0){
            ngl[i]=-1;
        } else {
            ngl[i]=st1.peek();
        }
        st1.push(i);
    }


 }
}