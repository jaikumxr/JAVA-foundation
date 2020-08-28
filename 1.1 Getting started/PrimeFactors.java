import java.util.Scanner;
public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int pf = 2;
        while(n!=1){
            if(n%pf==0){
                n = n/pf;
                System.out.println(pf);
            } else {
                pf++;
            }
        }
    }
}