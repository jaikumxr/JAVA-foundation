import java.io.*;
import java.util.*;

//Program to print the longest consecutive sequence of numbers present in an Array
//The sequence need NOT be in the correct order in the array and it can be random 
//but the numbers have to be present

public class HMLongestConsSeq {

    public static void lcs(int[] arr) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int x: arr) {
            hm.put(x, true);
        }
        for (int x : arr) {
            if(hm.containsKey(x-1)){
                hm.put(x, false);
            }
        }
        int maxc = 0;
        int maxi = 0;
        for (int x : arr) {
            if(hm.get(x)==true){
                int count = 1;
                int i = x;
                while(hm.containsKey(i+count)){
                        count++;
                }
                if(count>maxc){
                    maxc = count;
                    maxi = x;
                }
            }
        }
        for (int i = maxi; i < maxi+maxc; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        lcs(arr);
    }

}