import java.util.Scanner;

public class PythTrip {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        int g = 0;
        if(a>b){
            if(a>c){
                g = a;
                a = b;
                b = c;
            }
            else if(c>b){
                g = c;
            } else {
                g = b;
                b = c;
            }
        }
        if(g*g==(a*a+b*b)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}