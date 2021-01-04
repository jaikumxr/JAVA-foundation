import java.io.*;
import java.util.*;

// Program to traverse and print Generic Tree via iteration in both Post and Pre order traversals

public class GTIterativePrePost {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child: node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child: node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack < Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

//take one - using Single stack for Pre and double stack for Post, Not using as Post order can be done with the same stack (Sumeet Sir's Method)

    // public static void IterativePreandPostOrder(Node node) {
    //     Stack<Node> st = new Stack<>();
    //     Stack<Node> st1 = new Stack<>();
    //     Stack<Node> st2 = new Stack<>();

    //     Node pre = node;
    //     st.push(pre);

    //     while(st.size()>0){
    //         pre = st.pop();
    //         for (int i = pre.children.size()-1 ; i>=0 ; i--) {
    //             st.push(pre.children.get(i));
    //         }
    //         System.out.print(pre.data+" ");
    //     }

    //     Node post = node;
    //     st1.push(post);
    //     while(st1.size()>0){
    //         for (int i = post.children.size()-1 ; i>=0 ; i--) {
                
    //         }
    //     }
    // }

//take two - using Pair object

//creating new Pair object

    static class Pair{
        int state;
        Node node;

        Pair(Node node, int state){
            this.state = state;
            this.node = node;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
        String pre = "";
        String post = "";
        while (st.size()>0) {
            Pair top = st.peek();
            if (top.state==-1) {
                pre+=top.node.data+" ";
                top.state++;
            } else if(top.state==top.node.children.size()) {
                post+=top.node.data+" ";
                st.pop();
            } else {
                Pair cp = new Pair(top.node.children.get(top.state), -1);
                st.push(cp);
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        IterativePreandPostOrder(root);
    }

}