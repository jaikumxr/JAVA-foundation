import java.io.*;
import java.util.*;

//Program to sort a K-sorted array. (using Heap)
//complexity - Space: K, Time: nlog(K)

public class HeapKSorted {

//take one- accepted

    public static void kSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k+1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        while(pq.size()>0){
            System.out.println(pq.remove());
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        kSorted(arr, k);
    }

}