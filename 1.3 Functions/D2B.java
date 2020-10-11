import java.util.*;

public class D2B{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
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