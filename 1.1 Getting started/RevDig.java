import java.util.Scanner;

public class RevDig {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int dig = 0; 
        int m = n;
        while(n!=0){
            n = n/10;
            dig++;
        }
        while(dig!=0){
            System.out.println(m%10);
            m = m/10;
            dig--;
        }
    }
}