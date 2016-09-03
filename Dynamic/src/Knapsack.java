/**
 * Created by tecso on 3/9/16.
 */
public class Knapsack {
    public static int[][] getMaxVal(int W, int wt[], int val[]) {
        int tmp[][] = new int[val.length][W + 1];
        for (int i = 0; i < val.length; i++) {
            tmp[i][0] = 0;
        }
        for (int i = 1; i < W + 1; i++) {
            tmp[0][i] = val[0];
        }
        for (int i = 1; i < val.length; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (j < wt[i])
                    tmp[i][j] = tmp[i - 1][j];
                else
                    tmp[i][j] = Math.max((val[i] + tmp[i - 1][j - wt[i]]), tmp[i - 1][j]);
            }
        }

        System.out.println();
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(tmp[val.length - 1][W]);
        return tmp;
    }

    public static void getItems(int tmp[][], int wt[], int val[]) {
        int i = tmp.length - 1;
        int j = tmp[0].length - 1;

        while (true) {
            if (i < 1 || j < 1)
                break;
            if (tmp[i - 1][j] == tmp[i][j]) {
                i = i - 1;
            } else {
                System.out.println("val:" + val[i] + " wt:" + wt[i]);
                j = j - wt[i];
            }
        }
    }

    public static void main(String[] args) {
        int val[] = new int[]{1, 4, 5, 7};
        int wt[] = new int[]{1, 3, 4, 5};
        int W = 7;
        int tmp[][] = getMaxVal(W, wt, val);
        getItems(tmp, wt, val);
    }

}
