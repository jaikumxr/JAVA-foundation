import java.util.Scanner;

// In this program, if we solve the problem manually for a few numbers (pref>16), we find that all the bulbs which are ON are at a place which is a perfect square. This is because perfect square have an odd number of factors. Iterating and touching the bulb odd number of times will leave the bulb on and even number of times will leave it off, thus the outcome.

public class BenjiBulbs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(1);
        for(int i=2;i<=Math.sqrt(n);i++){
            if(i*i<=n){
                System.out.println(i*i);
            }
        }
    }
}