import java.util.Arrays;

/**
 * Created by tecso on 23/9/16.
 */
public class MaxSumRectangle {
    public static int[] kadane(int[] a) {
        int sum = 0;
        int total_sum = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
                start++;
            }

            if (total_sum < sum) {
                total_sum = sum;
                end = i;
            }

        }
        int res[] = {total_sum, start, end};
        return res;
    }

    public static void getMaxSumRectangle(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int T[] = new int[rows]; //row length //vertical
        Arrays.fill(T, 0);
        int max = 0;
        int left = 0, right=0, up = 0, down=0;

        for (int L = 0; L < cols; L++) { //Left column pointer
            Arrays.fill(T, 0);

            for (int R = L; R < cols; R++) { //Right column pointer

                for (int i = 0; i < arr.length; i++) { //column elements or rows //vertical
//                    T[i] += getSum(arr, i, L, R);
//                    dont get confused and put sum everytime
                    T[i]+=arr[i][R];
                }

                int res[] = kadane(T);
                int sum = res[0];
                if (max < sum) {
                    max = sum;
                    left = L;
                    right = R;
                    up = res[1];
                    down = res[2];
                }
            }
        }
        System.out.println("sum: "+max);
        System.out.println("L:"+left+" R:"+right+" U:"+ up+" D:"+down);

    }

    public static int getSum(int[][] arr, int i, int L, int R) {
        int sum = 0;
        for (int k = L; k < R; k++) {
            sum += arr[i][k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int input[][] = {{ 2,  1, -3, -4,  5},
                { 0,  6,  3,  4,  1},
                { 2, -2, -1,  4, -5},
                {-3,  3,  1,  0,  3}};
        getMaxSumRectangle(input);
    }
}
