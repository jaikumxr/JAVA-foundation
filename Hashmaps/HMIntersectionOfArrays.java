import java.io.*;
import java.util.*;

//Program to print the intersection of 2 arrays in the order of elements in 2nd array

public class HMIntersectionOfArrays {

//take one

    public static void getCommon(HashMap<Integer,Integer> h1, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (h1.containsKey(arr[i])) {
                if(h1.get(arr[i])>0){
                    System.out.println(arr[i]);
                    h1.put(arr[i], h1.get(arr[i]) - 1 );
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = scn.nextInt();
            if(!h1.containsKey(x)){
                h1.put(x, 1);
            } else {
                h1.put(x, h1.get(x)+1);
            }
        }
        int nn = scn.nextInt();
        int[] arr = new int[nn];
        for (int i = 0; i < nn; i++) {
            arr[i] = scn.nextInt();
        }
        getCommon(h1, arr);
    }

}