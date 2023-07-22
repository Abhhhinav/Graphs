package Graphs;
import java.util.*;
public class CheapestFlight {

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.des = d;
            this.wt = wt;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static void CreateGrph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int des = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src, des, wt);
            graph[src].add(e);
        }
    }

    public static int CheapestFlight(int n, int flights[][], int src, int des, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        CreateGrph(flights, graph);
        int dis[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.des;
                int wt = e.wt;

                if (curr.cost + wt < dis[v] && curr.stops <= k) {
                    dis[v] = curr.cost + wt;
                    q.add(new Info(v, dis[v], curr.stops + 1));
                }
            }
        }
        if (dis[des] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dis[des];
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dist = 3, k = 1;
        System.out.println(CheapestFlight(n, flights, src, dist, k));
    }
}
