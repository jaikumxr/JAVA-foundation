import java.util.Scanner;

public class HCFandLCM {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int prod = n1*n2;

        while(n1%n2!=0){
            int rem = n1%n2;
            n1 = n2;
            n2 = rem;
        }

        int lcm = prod/n2;
        System.out.println("LCM: ");
        System.out.println(lcm);
        System.out.println("\n HCF: ");
        System.out.println(n2);

    }
}