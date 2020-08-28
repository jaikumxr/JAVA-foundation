import java.util.Scanner;
import java.lang.Math;
public class InvNum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int dig = 0; 
        int m = n;
        while(n!=0){
            n = n/10;
            dig++;
        }
        int new1 = 0;
        for(int i=dig-1;i>=0;i--){
            int newnum = m%10;
            int exp = (int)Math.pow(10,newnum-1);
            int something = (dig-i)*exp;
            new1 = new1 + something;
            m = m-newnum;
            m = m/10;
        }
        System.out.println(new1);
        
    }
}