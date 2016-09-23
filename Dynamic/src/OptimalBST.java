/**
 * Created by tecso on 20/9/16.
 */
public class OptimalBST {
    public static void getOptimalBST(int[] keys, int[] freq) {
        int T[][] = new int[keys.length][keys.length];
        int root[] = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            T[i][i] = freq[i];
        }
        for (int l = 1; l < keys.length; l++) {
            for (int i = 0; i + l < keys.length; i++) {
                int j = i + l;
                T[i][j] = Integer.MAX_VALUE;
                int sum = getSum(freq, i, j);
//                System.out.println("l:" + l + " i:" + i + " j:" + j + " sum:" + sum);
                for (int k = i; k <= j; k++) {
                    int cost = ((k - 1 < i) ? 0 : T[i][k - 1]) + ((k + 1) > j ? 0 : T[k + 1][j]);
//                    System.out.println("\tcost:" + cost);
                    int val = cost + sum;
                    if (val < T[i][j]) {
                        T[i][j] = val;
                        root[l] = k;
                    }

                }
            }
        }


//        for (int i = 0; i < T.length; i++) {
//            for (int j = 0; j < T.length; j++) {
//                System.out.print(T[i][j] + "\t");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < keys.length; i++) {
            System.out.println(root[i]);
        }
    }

    //skipped answer printing , can be done by maintaining decision at each matrix point
    public static int getSum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum = sum + freq[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int keys[] = {10, 12, 16, 21};
        int freq[] = {4, 2, 6, 3};
        getOptimalBST(keys, freq);
    }

}
