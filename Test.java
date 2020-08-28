// import java.util.*;
import java.util.Scanner;


  public class Test{
  
  public static void main(String[] args) {
  
       Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        Boolean prime = true;
        for(int i=0;i<t;i++){
            int n = scn.nextInt();
            for(int j=2;j*j<=n;j++){
            if(n%2==0){
                prime = false;
                break;
            }
            if(n%j==0){
                prime = false;
                break;
            }
        }
        if(prime){
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
  
        }
       
   }
  }