package Graphs;
import java.util.*;
public class BellmanF {
    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        
        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
       
    }
    public static void bellmanFOrd(ArrayList<Edge> graph[], int src) {
        int dis[] = new int[graph.length];
        for (int i = 0; i < dis.length; i++) {
            if (i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) {
            // edges
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;
                    // realaaxation
                    if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < dis[v]) {
                        dis[v] = dis[u] + wt;
                    }
                }
            }
        }
        // print
        for (int i = 0; i < dis.length; i++) {
            System.out.println(dis[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bellmanFOrd(graph, 0);
    }
}
