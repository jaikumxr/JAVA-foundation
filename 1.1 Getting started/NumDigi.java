import java.util.Scanner;

public class NumDigi {
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n;
      n = scn.nextInt();
      int dig = 0;
      while(n!=0){
          n = n/10;
          dig++;
      }
      System.out.println(dig);
  }  
}