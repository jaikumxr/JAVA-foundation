import java.io.*;
import java.util.*;

//Program for Perfect Friends problem

public class GraphPerfectFriends {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    // take one, using recursion, rejected
    public static void getConnected(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps, boolean[] visited,
            int src, int dest, ArrayList<Integer> atn) {
        if (src == dest) {
            return;
        }
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] != true) {
                atn.add(e.nbr);
                getConnected(graph, comps, visited, e.nbr, dest, atn);
                comps.add(atn);
            }
        }
        getConnected(graph, comps, visited, src + 1, dest, new ArrayList<Integer>());
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
            // int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, 1));
            graph[v2].add(new Edge(v2, v1, 1));
        }
        boolean[] visited = new boolean[vtces];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        // getConnected(graph, comps, visited, 0, vtces, new ArrayList<Integer>());
        for (int i = 0; i < vtces; i++) {
            if (!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTree(graph, i, comp, visited);
                comps.add(comp);
            }
        }
        int ways = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                ways+=comps.get(i).size()*comps.get(j).size();
            }
        }
        System.out.println(ways);
    }

    public static void drawTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                drawTree(graph, e.nbr, comp, visited);
            }
        }
    }
}