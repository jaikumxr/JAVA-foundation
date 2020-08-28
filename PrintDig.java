import java.util.Scanner;
import java.lang.Math;

public class PrintDig {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int dig = 0; 
        int m = n;
        while(n!=0){
            n = n/10;
            dig++;
        }
        int pdig;
        int exp = (int)Math.pow(10,dig-1);
        while(exp!=0){
            pdig = m/exp;
            m = m%exp;
            exp = exp/10;            
            System.out.println(pdig);
            
        }
    }
}