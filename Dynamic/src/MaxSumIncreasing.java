import java.util.Arrays;

/**
 * Created by tecso on 11/9/16.
 */
public class MaxSumIncreasing {
    public static void getMaxSumIncreasingSubSeq(int[] a) {
        int T[] = new int[a.length]; //tmp
        int P[] = new int[a.length]; //parent
        for (int i = 0; i < a.length; i++) {
            T[i] = a[i];
            P[i] = i;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && T[i] < T[j] + a[i]) {
                    T[i] = T[j] + a[i];
                    P[i] = j;
                }
            }
        }
        //just prinitng
//        System.out.print("A:\t");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + "\t");
//        }
//        System.out.println();
//        System.out.print("T:\t");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(T[i] + "\t");
//        }
//        System.out.println();
//        System.out.print("P:\t");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(P[i] + "\t");
//        }
//        System.out.println();

        int max = Integer.MIN_VALUE;
        int max_index = -1;
        for (int i = 0; i < a.length; i++) {
            if (max < T[i]) {
                max = T[i];
                max_index = i;
            }
        }
        System.out.print("Seq:\t");
        while (max_index > 0) {
            System.out.print(a[max_index] + " ");
            max_index = P[max_index];
            if (max_index == 0)
                System.out.print(a[max_index] + " ");
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 6, 1, 3, 8, 4, 6};
        getMaxSumIncreasingSubSeq(a);
    }
}
