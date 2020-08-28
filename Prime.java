import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = 0;
        n = scn.nextInt();
        Boolean prime = true;
        for(int i=2;i*i<n;i++){
            if(n%2==0){
                prime = false;
                break;
            }
            if(n%i==0){
                prime = false;
                break;
            }
        }
        if(prime){
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }
    }
}