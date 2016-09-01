import java.util.Arrays;

/**
 * Created by tecso on 27/8/16.
 */
//https://www.youtube.com/watch?v=S9oUiVYEq7E
//https://github.com/mission-peace/interview/blob/master/src/com/interview/array/LongestIncreasingSubSequenceOlogNMethod.java
public class LIS {
    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(" " + A[i]);
        }
        System.out.println();
    }

    public static int getCeilIndex(int s[], int A[], int l, int r, int key) {
        int mid = 0;
        while (r - l > 1) {
            mid = (l + r) >>> 1;
            if (A[s[mid]] < key) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static void getLIS(int[] A) {

        int S[] = new int[A.length];
        int P[] = new int[A.length];
        int len = 0;
        S[0] = 0;
        Arrays.fill(P, -1);

        //parent is always current s being upserted -1
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[S[0]]) {
                S[0] = i;
            } else if (A[S[len]] < A[i]) {
                len++;
                S[len] = i;
                P[i] = S[len - 1];
            } else {
                int ceilIndex = getCeilIndex(S, A, 0, len, A[i]);
                S[ceilIndex] = i;
                P[i] = S[ceilIndex - 1];
            }
        }

        System.out.println("len:" + Integer.valueOf(len+1));
        int tmp = S[len];
        while (tmp != -1) {
            System.out.print(A[tmp]+" ");
            tmp = P[tmp];
        }

    }

    public static void main(String[] args) {
        int input[] = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        getLIS(input);
    }
}
