import java.util.Arrays;

/**
 * Created by tecso on 17/10/16.
 */
public class MinCostUsingTrain {
    public static int INF = 9999;

    public static int getMinCost(int[][] cost) {
        int n = cost.length;
        int dist[] = new int[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //remember j<i , j is intermediate station, so cost[j][i]
                if (dist[i] > dist[j] + cost[j][i]) //like normalizing a graph
                    dist[i] = dist[j] + cost[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
        System.out.println(dist[n - 1]);
        return dist[n - 1];
    }

    public static void main(String[] args) {
        int cost[][] = {{0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        getMinCost(cost);

    }

}
