import java.io.*;
import java.util.*;

public class HeapPriorityQ {
    public static class PriorityQueue {
        ArrayList<Integer> data;
        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size()-1);
        }

        private void upheapify(int i) {
            if(i==0){
                return;
            }
            
            int pi = (i-1)/2;
            if(data.get(pi)>data.get(i)){
                swap(i, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j) {
            int temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        private void downheapify(int i) {
            int mini = i;
            int c1 = (2*i)+1;
            if(c1 < data.size() && data.get(c1)<data.get(mini)){
                mini = c1;
            }
            int c2 = (2*i)+2;
            if(c2 < data.size() && data.get(c2)<data.get(mini)){
                mini = c2;
            }
            if(mini!=i){
                swap(i, mini);
                downheapify(mini);
            }
        }

        public int remove() {
            if(this.size()==0){
                System.out.println("Underflow");
                return -1;
            }
            swap(0, data.size()-1);
            int val = data.remove(data.size()-1);
            downheapify(0);
            return val;
        }


        public int peek() {
            if (this.size()==0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size() - 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}