/**
 * Created by tecso on 1/9/16.
 */
public class MatrixChain {
    public static int[][] getMatrixChainOrder(int p[]) {
        int n = p.length - 1;
        int tmp[][] = new int[n][n];

        for (int len = 1; len < n + 1; len++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        tmp[i][j] = 0;
                    else if (i < j) {

                    }
                }
            }
        }

    }
}
