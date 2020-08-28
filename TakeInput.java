import java.util.Scanner;

public class TakeInput {
    public static void main(String[] args) {
        // initialize scanner using this statement:
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i=0;i<=n;i++){
            System.out.println(i);
        }
        scn.close();
        // scn.nextLine() for string input
        // Integer.parseInt(scn.nextInt()) to use both Int and String inputs1 in one program - i.e in almost every case.
    }
}