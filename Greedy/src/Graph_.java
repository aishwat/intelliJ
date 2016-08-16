import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by tecso on 14/8/16.
 */
public class Graph_ {
    int V, E;

    class Edge implements Comparable<Edge> {
        int src, dst, weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    class Subset {
        int parent;
        int rank;
    }

    Edge edge[];

    Graph_(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    int find(Subset subset[], int i) {
        if (subset[i].parent != i)
            subset[i].parent = find(subset, subset[i].parent);
        return subset[i].parent;
    }

    void Union(Subset subset[], int x, int y) {
        int x_set = find(subset, x);
        int y_set = find(subset, y);
        if (subset[x_set].rank < subset[y_set].rank)
            subset[x_set].parent = y_set;
        else if (subset[x_set].rank > subset[y_set].rank)
            subset[y_set].parent = x_set;
        else //equal rank
        {
            subset[x_set].parent = y_set;
            subset[y_set].rank++;
        }
    }

    int isCycle(Graph_ graph) {

        Subset subset[] = new Subset[graph.V];
        for (int i = 0; i < graph.V; i++) {
            subset[i].parent = i;
            subset[i].rank = 0;
        }
        for (int i = 0; i < graph.E; i++) {
            int x = graph.find(subset, graph.edge[i].src);
            int y = graph.find(subset, graph.edge[i].dst);
            if (x == y)
                return 1;
            Union(subset, x, y);
        }
        return 0;
    }

    void kruskalMST() {
        Edge result[] = new Edge[V];
        int e=0;

//        for (int i = 0; i < V; i++) {
//            result[i] = new Edge();
//        }
        Arrays.sort(edge);

        Subset subsets[] = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i =0;
        while (e < V - 1) {
            Edge next_edge = edge[i++];

            System.out.println("edge chose: "+next_edge.src+"--"+next_edge.dst);
            int x = find(subsets,next_edge.src);
            int y = find(subsets,next_edge.dst);

            if(x!=y){
                result[e++] = next_edge;
                Union(subsets,x,y);
            }
        }

        for(i=0 ;i<e;i++){
            System.out.println("src: "+result[i].src+" dst: "+result[i].dst+" wt: "+result[i].weight);
        }

    }

    public static void main(String[] args) {
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph_ graph = new Graph_(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dst = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dst = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dst = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dst = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dst = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }


}
