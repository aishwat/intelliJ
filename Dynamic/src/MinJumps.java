import java.util.Arrays;

/**
 * Created by tecso on 17/9/16.
 */
public class MinJumps {
    public static int getMinJumpsToReachEnd(int[] a) {
        int T[] = new int[a.length];
        int P[] = new int[a.length];
        Arrays.fill(T, 999);
        T[0] = 0;
        P[0] = 0;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + a[j] && T[i] > T[j] + 1) {
                    T[i] = T[j] + 1;
                    P[i] = j;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(T[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(P[i] + " ");
        }
        System.out.println();

        int index = a.length - 1;
        while (index != 0) {
            System.out.print(index+" ");
            index = P[index];
        }
        System.out.print("0");
        System.out.println();

        return T[a.length-1];
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        getMinJumpsToReachEnd(a);
    }
}
