import java.util.*;

public class AnyBaseSubtraction {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2) {
        int pwr = 1;
        int ans = 0;
        int carry = 0;
        while(n2>0){
            int s1 = n1%10;
            int s2 = n2%10;
            n1 = n1/10;
            n2 = n2/10;
            int val = s1*s2;
            if(val>b){
                carry+=val/b;
                val = val%b;
            }
            ans+=pwr*val;
            pwr*=10;
        }
        return ans;
    }
}