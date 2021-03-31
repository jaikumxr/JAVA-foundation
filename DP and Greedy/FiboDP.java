import java.io.*;
import java.util.*;

public class FiboDP {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(fibo(n));
        int[] qb = new int[n+1];
        System.out.println(fiboMemoized(n, qb));
    }

    public static int fibo(int n) {
        if(n==0 || n==1){
            return n;
        }

        int fib1 = fibo(n-1);
        int fib2 = fibo(n-2);

        return fib1+fib2;
    }

    public static int fiboMemoized(int n, int[] qb) {
        if(n==0 || n==1){
            return n;
        }

        if(qb[n]!=0){
            return qb[n];
        }

        int fib1 = fiboMemoized(n-1, qb);
        int fib2 = fiboMemoized(n-2, qb);

        int fibn = fib1 + fib2;

        qb[n] = fibn;

        return fibn;

    }
}