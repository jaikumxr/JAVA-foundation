import java.util.*;

public class AnyBaseMultiplication {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {
        int ans = 0;
        int pwr = 1;

        while(n2>0){
            int d2 = n2%10;
            n2=n2/10;
            int val = getProductSingleDigit(b, n1, d2);
            ans = getSum(b, val*pwr, ans);
            pwr*=10;
        }
        return ans;


    }

    public static int getProductSingleDigit(int b, int n1, int d2){
        int rv = 0;
        int pwr = 1;
        int carry = 0;
        while(n1>0 || carry>0){
            int d1 = n1%10;
            n1 = n1/10;
            int val = d1*d2+carry;
            carry = val/b;
            val = val%b;

            rv+=pwr*val;
            pwr*=10;
        }
        return rv;

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