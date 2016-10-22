/**
 * Created by tecso on 28/9/16.
 */

//http://algods-cracker.blogspot.in/2015/09/minimum-initial-points-to-reach.html
public class MinInititalPoints {
    public static int getMinInitialPoints1(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        int T[][] = new int[row][col];
        T[0][0] = 0;

        for (int i = 1; i < row; i++) {
            if (points[i - 1][0] < 0)
                T[i][0] = -points[i - 1][0] + T[i - 1][0];
            else
                T[i][0] = T[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            if (points[0][i - 1] < 0)
                T[0][i] = -points[0][i - 1] + T[0][i - 1];
            else
                T[0][i] = T[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int pi, pj;
                //i-1,j
                if (points[i - 1][j] < 0)
                    pi = -points[i - 1][j] + T[i - 1][j];
                else
                    pi = T[i - 1][j];
                //i,j-1
                if (points[i][j - 1] < 0)
                    pj = -points[i][j - 1] + T[i][j - 1];
                else
                    pj = T[i][j - 1];

                if (pi < pj)
                    T[i][j] = pi;
                else
                    T[i][j] = pj;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        return T[row - 1][col - 1] + 1;
        //if at some cell it goes 0
        //not a correct approach , but vl approximate aand easy to understand
    }

    public static int getMinInitialPoints2(int[][] points) {
        // dp[i][j] represents the minimum initial points player
        // should have so that when starts with cell(i, j) successfully
        // reaches the destination cell(row-1, col-1)
        int R = points.length;
        int C = points[0].length;
        int dp[][] = new int[R][C];

        // Base case
        dp[R - 1][C - 1] = points[R - 1][C - 1] > 0 ? 1 :
                Math.abs(points[R - 1][C - 1]) + 1;

        // Fill last row and last column as base to fill
        // entire table
        for (int i = R - 2; i >= 0; i--)
            dp[i][C - 1] = Math.max(dp[i + 1][C - 1] - points[i][C - 1], 1);
        for (int j = C - 2; j >= 0; j--)
            dp[R - 1][j] = Math.max(dp[R - 1][j + 1] - points[R - 1][j], 1);

        // fill the table in bottom-up fashion
        for (int i = R - 2; i >= 0; i--) {
            for (int j = C - 2; j >= 0; j--) {
                int min_points_on_exit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min_points_on_exit - points[i][j], 1);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        int points[][] = {
                {-2, -3, -3, 4},
                {-5, -10, 1, 5},
                {10, 30, -5, 6},
                {11, 3, 5, 7},
        };
        System.out.println(getMinInitialPoints2(points));

    }
}






