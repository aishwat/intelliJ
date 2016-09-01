import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tecso on 1/9/16.
 */
public class CoinChange {
    public static int[][] getCount(int[] S, int n) {

        int tmp[][] = new int[S.length][n + 1];
        for (int i = 0; i < S.length; i++) {
            tmp[i][0] = 1;
        }
        for (int j = 0; j < n + 1; j++) {
            tmp[0][j] = 1;
        }

        for (int i = 1; i < S.length; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j < S[i])
                    tmp[i][j] = tmp[i - 1][j];
                else
                    tmp[i][j] = tmp[i - 1][j] + tmp[i][j - S[i]];
                //1 up and coin value back steps
            }
        }
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        return tmp;
    }
    public static void printCoins(int[][] tmp){

    }
    public static void main(String[] args) {
        int S[] = {1, 2, 3};
        int tmp[][] = getCount(S, 5);

    }
}
