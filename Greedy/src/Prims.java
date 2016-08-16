/**
 * Created by tecso on 16/8/16.
 */
public class Prims {
    public int minKey(int key[], Boolean mstSet[], int n) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < n; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public void print_mst(int parent[], int graph[][], int n) {
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + "-" + i + "   " + graph[i][parent[i]]);
        }
    }

    public void primMST(int graph[][]) {
        int V = graph.length;
        int key[] = new int[V];
        Boolean mstSet[] = new Boolean[V];
        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
            parent[i] = -1;
        }
        key[0] = 0;

        for (int i = 0; i < V - 1; i++) {
            //at end , u=v-1 , v= last vertice
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                //adjacent, new val < key, not in mst
                if (graph[u][v] != 0 && graph[u][v] < key[v] && mstSet[v] == false) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }

        }
        print_mst(parent, graph, V);
    }

    public static void main(String[] args) {
        int graph[][]=new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };
        Prims mst = new Prims();
        mst.primMST(graph);
    }

}
