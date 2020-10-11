import java.util.*;

public class AnyBaseAddition {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2) {
        int carry = 0;
        int pwr = 1;
        int ans = 0;
        while(n1!=0 || n2!=0 || carry!=0){
            int val = carry;
            if(n1>0){
                val+=n1%10;
                n1=n1/10;
            }
            if(n2>0){
                val+=n2%10;
                n2=n2/10;
            }
            carry = val/b;
            ans += pwr*(val%b);
            pwr = pwr*10;
        }
        return ans;
    }
}