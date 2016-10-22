import java.util.Vector;

/**
 * Created by tecso on 24/9/16.
 */
public class tmp {
    public static int max_points(int[][] a) {
        int m, n;
        m = a.length;
        n = a[0].length;
        int tool_c[] = {-1, 0, 1};
        int dp[][][] = new int[m][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[m - 1][i][j] = 0;
            }
        }
        dp[m - 1][0][n - 1] = a[m - 1][0] + a[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    if (j1 != j2) {
                        dp[i][j1][j2] = 0;
                        for (int fj = 0; fj < 3; fj++) {
                            for (int sj = 0; sj < 3; sj++) {
                                int c1 = j1 + tool_c[fj];
                                int c2 = j2 + tool_c[sj];
                                if (c1 >= 0 && c1 < n && c2 >= 0 && c2 < n && c1 != c2) {
                                    dp[i][j1][j2] = Math.max(dp[i + 1][c1][c2], dp[i][j1][j2]);
                                }
                            }
                        }
                        dp[i][j1][j2] += a[i][j1] + a[i][j2];
                    }
                }
            }
        }

        for (int i = 0; i <m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    System.out.print(dp[i][j1][j2]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return dp[0][0][n - 1];
    }

    public static void main(String[] args) {
        int arr[][] = {{3, 6, 8, 2},
                {5, 2, 4, 3},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
        };
        System.out.println(max_points(arr));

    }


    public static void print_array(long[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
