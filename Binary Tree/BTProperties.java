import java.io.*;
import java.util.*;

// Program to display height, size, maximum and sum of a Binary Tree

public class BTProperties {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

//take one - using recursion, accepted

    public static int size(Node node) {
        int s = 1;
        if(node.right!=null){
            s+=size(node.right);
        }
        if(node.left!=null){
            s+=size(node.left);
        }
        return s;
    }

    public static int sum(Node node) {
        int s = node.data;
        if(node.right!=null){
            s+=sum(node.right);
        }
        if (node.left!=null) {
            s+=sum(node.left);
        }
        return s;
    }

    public static int max(Node node) {
        int m = node.data;
        if(node.right!=null){
            m = Math.max(m, max(node.right));
        }
        if(node.left!=null){
            m = Math.max(m, max(node.left));
        }
        return m;
    }

    public static int height(Node node) {
        int h = -1;
        if(node.right!=null){
            h = Math.max(h, height(node.right));
        }
        if(node.left!=null){
            h = Math.max(h, height(node.left));
        }
        h+=1;
        return h;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }

}