import java.util.Arrays;

/**
 * Created by tecso on 28/9/16.
 */
public class CollectMaxPoints {
    public static int R = 5;
    public static int C = 4;
    public static int T[][][] = new int[R][C][C];

    public static boolean isValid(int x, int y1, int y2) {
        if (x < 0 || x >= R || y1 < 0 || y1 >= C || y2 < 0 || y2 >= C)
            return false;
        else
            return true;
    }

    public static int getMaxPoints(int[][] a, int x, int y1, int y2) {
        if (!isValid(x, y1, y2))
            return Integer.MIN_VALUE;
        if (x == R - 1 && y1 == 0 && y2 == C - 1)
            return a[x][y1] + a[x][y2];
        if (x == R - 1) return Integer.MIN_VALUE;

        if (T[x][y1][y2] != 0) // or fill by -1 and check for -1
            return T[x][y1][y2];

        int ans = Integer.MIN_VALUE;

        int temp; //gain of current row
        if (y1 == y2)
            temp = a[x][y1];
        else
            temp = a[x][y1] + a[x][y2];

        //cases on next row
        //9 cases (-1,0,1)(-1,0,1)
        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1 - 1, y2 - 1));
        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1 - 1, y2));
        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1 - 1, y2 + 1));

        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1, y2 - 1));
        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1, y2));
        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1, y2 + 1));

        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1 + 1, y2 - 1));
        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1 + 1, y2));
        ans = Math.max(ans, temp + getMaxPoints(a, x + 1, y1 + 1, y2 + 1));
        T[x][y1][y2] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{3, 6, 8, 2},
                {5, 2, 4, 3},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
        };
//        Arrays.fill(T,-1);
        System.out.println(getMaxPoints(arr, 0, 0, C - 1));

    }
}
