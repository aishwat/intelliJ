/**
 * Created by tecso on 20/9/16.
 */
//shortest path b/w pairs for -ive weight edges
class Graph {
    Edge[] edge;
    int V, E;

    class Edge {
        int src, dest, weight;

        Edge() {
            src = 0;
            dest = 0;
            weight = 0;
        }
    }

    Graph(int v, int e) {
        E = e;
        V = v;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }
}

public class BellmanFord {
    public static void bellmanFord(Graph graph, int src) {
        int V = graph.V;
        int E = graph.E;
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            //normalize or all vertices
            for (int j = 0; j < E; j++) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int wt = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        //check -ive cycles
        for (int i = 0; i < E; i++) {
            int u = graph.edge[i].src;
            int v = graph.edge[i].dest;
            int wt = graph.edge[i].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                System.out.println("-ive wt cycle at edge " + u + "-" + v);
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + " - " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;  // Number of vertices in graph
        int E = 8;  // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        bellmanFord(graph, 0);
    }
}
