import java.util.Scanner;
import java.lang.Math;
public class RotateNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int powr = (int)Math.pow(10,k);
        int m = n;
        int dig = 0;
        while(n!=0){
            n = n/10;
            dig++;
        }
        k = k%dig;
        int rem = m%powr;
        m = m/powr;
        powr = (int)Math.pow(10,dig-k);
        rem = powr*rem;
        m = m+rem;
        System.out.println(m);
    }
}