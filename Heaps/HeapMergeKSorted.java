import java.io.*;
import java.util.*;

//Program to merge K sorted lists.
//Space - O(K), Time - n*log(K)
//where k is the number of lists and n is number of elements across all lists.

public class HeapMergeKSorted {
    
    public static class Pair implements Comparable<Pair> {
        int li, di, val;
        Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair other){
            return this.val-other.val;
        }

    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i<lists.size(); i++) {
            pq.add(new Pair(i, 0 , lists.get(i).get(0)));
        }
        while(pq.size()>0){
            Pair ele = pq.remove();
            rv.add(ele.val);
            ele.di++;
            if(ele.di<lists.get(ele.li).size()){
                pq.add(new Pair(ele.li, ele.di, lists.get(ele.li).get(ele.di)));
            }
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}