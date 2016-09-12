

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tecso on 12/9/16.
 */
public class LongestBiotonic {
    public static int[] getLIS(int a[]) {
        int T[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            T[i] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && T[i] < T[j] + 1)
                    T[i] = T[j] + 1;
            }
        }
//        int max = Integer.MIN_VALUE;
//        int max_index = -1;
//        for (int i = 0; i < a.length; i++) {
//            if (max < T[i]) {
//                max = T[i];
//                max_index = i;
//            }
//            System.out.print(T[i] + " ");
//        }
        return T;
    }

    //right to left
    public static int[] getLIS_(int a[]) {
        int T[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            T[i] = 1;
        }
        for (int i = a.length - 2; i >= 0; i--) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[i] && T[i] < T[j] + 1)
                    T[i] = T[j] + 1;
            }
        }

        return T;
    }

    public static int getMaxIndex(int[] a) {
        int max = Integer.MIN_VALUE;
        int max_index = -1;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                max_index = i;
            }
        }
        return max_index;
    }

    //longest biotonic sub seq
    public static void getLBSS(int a[]) {
        int T[] = getLIS(a);
        int T_[] = getLIS_(a);
        print_array(T);
        print_array(T_);

        int T_sum[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            T_sum[i] = T[i] + T_[i] - 1;
        }
        print_array(T_sum);
        int tmp = getMaxIndex(T_sum);
        System.out.println();
        System.out.println(T_sum[tmp]);
    }

    public static void print_array(int[] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int a[] = {2, -1, 4, 3, 5, -1, 3, 2};
        getLBSS(a);
        //can get actual seq by maintaining parent in LIS
    }
}
