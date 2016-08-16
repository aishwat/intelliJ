/**
 * Created by tecso on 13/8/16.
 */
public class Graph {
    int V,E;
    class Edge{
        int src,dst;
    }

    Edge edge[];

    Graph(int v,int e){
        V =v;
        E = e;
        edge = new Edge[e];
        for(int i=0;i<e;i++){
            edge[i] = new Edge();
        }
    }

    //need to pass parent array ref
    int find(int parent[],int i){
        if(parent[i] == -1)
            return i;
        return find(parent,parent[i]);
    }
    void Union(int parent[],int x, int y){
        int x_set= find(parent,x);
        int y_set = find(parent,y);
        parent[x_set] = y_set;
    }

    int isCycle(Graph graph){
        int parent[] = new int[graph.V];
        for(int i=0;i<graph.V;i++){
            parent[i]= -1;
        }
        for(int i=0;i<graph.E;i++){
            int x= graph.find(parent,graph.edge[i].src);
            int y = graph.find(parent,graph.edge[i].dst);
            if(x==y){
                return 1;
            }
            graph.Union(parent,x,y);
        }
        return 0;
    }

    public static void main(String[] args) {
        int V=3,E=3;
        Graph graph = new Graph(V,E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dst = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dst = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dst = 2;

        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
