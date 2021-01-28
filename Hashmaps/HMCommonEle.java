import java.io.*;
import java.util.*;

//Program to print all elements of a2 which are also present in a1 
//(in order of their occurence in a2)

public class HMCommonEle {

//take one, accepted

    public static void getCommon(HashMap<Integer,Integer> h1, int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (h1.containsKey(arr[i])) {
                System.out.println(arr[i]);
                h1.remove(arr[i]);
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