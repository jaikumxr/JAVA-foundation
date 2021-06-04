import java.io.*;
import java.util.*;

//This algorithm uses BFS in Graph to find out the number of infected people within a given time frame.

public class GraphInfectionSpread {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int v;
        int level;

        Pair(int v, int level) {
            this.v = v;
            this.level = level;
        }
    }

    static int count;
    static int lvl;

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
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));
        count = 0;
        lvl = 0;
        while (q.size() > 0 && t > 0) {
            Pair rem = q.removeFirst();
            if (visited[rem.v] == false) {
                visited[rem.v] = true;
                count++;
            }
            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] != true) {
                    q.add(new Pair(e.nbr, rem.level + 1));
                }
            }
            if (rem.level > lvl) {
                lvl = rem.level;
                t--;
            }
        }

        System.out.println(count);

    }

}