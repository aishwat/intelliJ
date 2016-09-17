/**
 * Created by tecso on 17/9/16.
 */
public class MaxSquareSubMatrix {
    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int getMaxSquareSubMatrix(int[][] a) {
        int T[][] = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            T[i][0] = a[i][0];
        }
        for (int i = 0; i < a[0].length; i++) {
            T[0][i] = a[0][i];
        }

        int max = 1;
        int max_i = -1;
        int max_j = -1;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][j] == 0)
                    T[i][j] = 0;
                else
                    T[i][j] = min(T[i - 1][j], T[i][j - 1], T[i - 1][j - 1]) + 1;
                if (max < T[i][j]) {
                    max = T[i][j];
                    max_i = i;
                    max_j = j;
                }


            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("max: " + max + " at (" + max_i + "," + max_j + ")");
        return max;
    }

    public static void main(String[] args) {
//        int a[][] = {{0, 1, 1, 0, 1},
//                    {1, 1, 0, 1, 0},
//                    {0, 1, 1, 1, 0},
//                    {1, 1, 1, 1, 0},
//                    {1, 1, 1, 1, 1},
//                    {0, 0, 0, 0, 0}};
//        System.out.println(a[0].length);
//        System.out.println(a.length);
        int arr[][] = {{0, 0, 1, 1, 1}, {1, 0, 1, 1, 1}, {0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}};
        getMaxSquareSubMatrix(arr);

    }
}
