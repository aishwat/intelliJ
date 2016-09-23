/**
 * Created by tecso on 20/9/16.
 * //
 */
//Kadane’s Algorithm:
public class LargestSumContiguous {
    public static int getLargestSumContiguousArray(int a[]) {
        int max_so_far = 0;
        int max_ending_here = 0;
        for (int i = 0; i < a.length; i++) {
            max_ending_here = a[i] + max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_ending_here > max_so_far)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max = getLargestSumContiguousArray(a);
        System.out.println("max: " + max);
    }
}
