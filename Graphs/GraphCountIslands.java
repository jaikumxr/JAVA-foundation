import java.io.*;
import java.util.*;

//Program to count islands from a 2D array. '0' is land and '1' is water.

public class GraphCountIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        //take one, using GraphConnectedComponents, accepted

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    drawTree(i, j, visited, arr);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void drawTree(int i, int j, boolean[][] visited, int[][] arr) {
        if (i < 0 || j < 0 || i == arr.length || j == arr.length || arr[i][j] != 0) {
            return;
        }
        if (!visited[i][j]) {
            visited[i][j] = true;
            drawTree(i + 1, j, visited, arr);
            drawTree(i, j - 1, visited, arr);
            drawTree(i - 1, j, visited, arr);
            drawTree(i, j + 1, visited, arr);
        }

    }

}