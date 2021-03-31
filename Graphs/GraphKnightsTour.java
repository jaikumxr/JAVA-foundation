import java.io.*;
import java.util.*;

//Program to print all possible moves of a knight in an n x n chessboard such that every cell ...
// ... of the chessboard is covered.

//Output is correct but will be shown as rejected on the portal because of different order

public class GraphKnightsTour {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[][] chess = new int[n][n];

        printKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int mov) {
        if(r>=chess.length || c>=chess.length || r<0 || c<0 || chess[r][c] > 0){
            return;
        } else if(mov == chess.length * chess.length){
            chess[r][c] = mov;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = mov;
        printKnightsTour(chess, r-2, c+1, mov+1);
        printKnightsTour(chess, r-1, c+2, mov+1);
        printKnightsTour(chess, r-2, c-1, mov+1);
        printKnightsTour(chess, r-1, c-2, mov+1);
        printKnightsTour(chess, r+2, c+1, mov+1);
        printKnightsTour(chess, r+1, c+2, mov+1);
        printKnightsTour(chess, r+2, c-1, mov+1);
        printKnightsTour(chess, r+1, c-2, mov+1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}