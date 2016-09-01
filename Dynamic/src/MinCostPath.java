/**
 * Created by tecso on 1/9/16.
 */
public class MinCostPath {
    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int[][] minCost(int cost[][]) {
        int row = cost.length;
        int col = cost[0].length;
        int tc[][] = new int[row][col];
        tc[0][0] = cost[0][0];
        for (int i = 1; i < row; i++) {
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j < col; j++) {
            tc[0][j] = tc[0][j - 1] + cost[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                tc[i][j] = cost[i][j] + min(tc[i - 1][j], tc[i][j - 1], tc[i - 1][j - 1]);
            }
            System.out.println();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(tc[i][j] + " ");
            }
            System.out.println();
        }
        return tc;
    }

    public static void getPath(int[][] tc) {
        int i = tc.length - 1;
        int j = tc[0].length - 1;
        System.out.println("point: " + i + " " + j);
        while (true) {
            if (i == 0 && j == 0)
                break;
            if (i - 1 < 0 || j - 1 < 0)
                break;

            int min = min(tc[i - 1][j], tc[i][j - 1], tc[i - 1][j - 1]);
            if (min == tc[i - 1][j]) {
                i--;
            } else if (min == tc[i][j - 1]) {
                j--;
            } else if (min == tc[i - 1][j - 1]) {
                i--;
                j--;
            }
            System.out.println("point: " + i + " " + j);
        }

    }

    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        int tc[][] = minCost(cost);
        getPath(tc);
    }
}
