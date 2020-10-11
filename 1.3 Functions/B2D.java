import java.util.*;

public class B2D {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
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
}