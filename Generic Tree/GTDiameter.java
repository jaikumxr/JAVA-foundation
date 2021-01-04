import java.io.*;
import java.util.*;

//program to find the Diameter of a Generic Tree i.e. the maximum distance between two nodes in a GT

public class GTDiameter {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
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

//take one, using recursion, rejected - fundamental flaws in diamHelper function.
    // static int dia = 0;

    // public static int diamHelper(Node node) {
    //     if (node.children.size()==0) {
    //         return 1;
    //     }
    //     Node mnode = null;
    //     int m1 = -1;
    //     int m2 = -1;
    //     for (Node child : node.children) {
    //         int dist = diamHelper(child)+1;
    //         if (dist>m1) {
    //             m1 = dist;    
    //             mnode = child;
    //         }
    //     }
    //     for (Node child : node.children) {
    //         int dist = diamHelper(child)+1;
    //         if (dist>m2 && mnode!=child) {
    //             m2 = dist;
    //         }
    //     }
    //     return m1+m22;
    // }

    // public static void calDiam(Node node) {
    //     for (Node child : node.children) {
    //         int diam = diamHelper(child);
    //         if (diam>dia) {
    //             dia = diam;
    //         }
    //     }
    // }

//take two - Sumit Sir's method

    static int dia;

    static int calDiam(Node node){
        int dch = -1;
        int sdch = -1;
        for (Node child : node.children) {
            int ch = calDiam(child);
            if (ch>dch) {
                sdch = dch;
                dch = ch;
            } else if(ch>sdch) {
                sdch = ch;
            }
        }
        if (dch + sdch + 2 > dia) {
            dia = dch + sdch + 2;
        }
        return dch+1;
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
        calDiam(root);
        System.out.println(dia);
    }

}