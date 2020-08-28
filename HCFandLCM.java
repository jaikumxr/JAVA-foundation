import java.util.Scanner;

public class HCFandLCM {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int s,g;
        s = g = 0;
        if(num1>num2){
            g = num1;
            s = num2;
        } else {
            g = num2;
            s = num1;
        }
        int temp;
        int div = s;
        int rem = g%s;
        while(rem!=0){
            temp = 
            rem = div%rem;
            
        }
        

    }
}