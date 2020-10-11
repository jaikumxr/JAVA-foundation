import java.util.*;

public class AnyB2B {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        int dec = getValueIndecimal(n, sourceBase);
        int ans = getValueInBase(dec, destBase);
        System.out.println(ans);
    }

    public static int getValueIndecimal(int n, int b) {
        int pwr = 1;
        int ans = 0;
        while(n!=0){
            ans+=(pwr*(n%10));
            n = n/10;
            pwr = pwr*b;
        }
        return ans;
    }

    public static int getValueInBase(int n, int b) {
        int pwr = 1;
        int ans = 0;
        while(n!=0){
            ans+=(pwr*(n%b));
            n = n/b;
            pwr = pwr*10;
        }
        return ans;
    }
}