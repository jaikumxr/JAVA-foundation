import java.io.*;
import java.util.*;

//Program to find all the hamiltonian paths in a graph. Hamiltonian paths are represented by '.' ...
//... and Hamiltonian cycles are represented by '*'.

public class GraphHamiltonianPath {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   //take one, accepted

   public static void printHamilPaths(ArrayList<Edge>[] graph, int src, int vtn, boolean[] visited, String psf ) {
    if(vtn == visited.length-1){
        for (Edge e : graph[src]) {
            if(e.nbr==psf.charAt(0)-48){
                System.out.println(psf+src+"*");
                return;
            }
        }
        System.out.println(psf+src+".");
        return;
    }
    visited[src] = true;
    for (Edge e : graph[src]) {
        if(visited[e.nbr]!=true){
            printHamilPaths(graph, e.nbr, vtn+1, visited, psf+e.src );
        }
    }
    visited[src] = false;
}

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      boolean[] visited = new boolean[vtces];
      printHamilPaths(graph, src, 0, visited, "");
   }


}