import java.io.*;
import java.util.*;

public class TopologicalSortDFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
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
            graph[v1].add(new Edge(v1, v2));
        }

        boolean[] visited = new boolean[vtces];
        Stack<Integer> res = new Stack<>();
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == false) {
                topologicalSort(i, graph, visited, res);
            }
        }
        
        while(res.size()>0) {
            System.out.println(res.pop());
        }
    }

    public static void topologicalSort(int v, ArrayList<Edge>[] graph , boolean[] visited, Stack<Integer> res) {
        visited[v] = true;
        for (Edge e : graph[v]) {
            if(visited[e.nbr]==false){
                topologicalSort(e.nbr, graph, visited, res);
            }
        }
        res.push(v);

    }

}