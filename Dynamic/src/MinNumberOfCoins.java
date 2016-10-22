/**
 * Created by tecso on 28/9/16.
 */
//Find minimum number of coins that make a given value, not number of ways
//https://www.youtube.com/watch?v=Y0ZqKpToTic
public class MinNumberOfCoins {
    public static int getNumberOfCoins(int coins[], int n) {
        int T[][] = new int[coins.length][n + 1];
//        T[i][j] is min number of coins needed to get 'n' given coins of value coins[0] till coins[i]
        for (int i = 0; i < coins.length; i++) {
            T[i][0] = 0;
            T[i][1] = 1;
        }
        for (int i = 0; i <= n; i++) {
            T[0][i] = i;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 2; j <= n; j++) {
                if (j < coins[i])
                    T[i][j] = T[i - 1][j];
                else
                    T[i][j] = Math.min(T[i - 1][j], 1 + T[i][j - coins[i]]);
                //if we pick ith coin 1+ remaining min coins for remaining value
            }
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        return T[coins.length - 1][n];
    }

    public static void main(String[] args) {
        int coins[] = {1,5,6,8};
        System.out.println(getNumberOfCoins(coins, 11));
    }

}
