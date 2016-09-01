/**
 * Created by tecso on 24/8/16.
 */
public class Ugly {
    public static  int getNthUgly(int n) {
        int ugly[] = new int[n];
        ugly[0] = 1;
        int next_ugly;
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = ugly[i2] * 2;
        int next_multiple_of_3 = ugly[i3] * 3;
        int next_multiple_of_5 = ugly[i5] * 5;

        for (int i = 1; i < n; i++) {

            next_ugly = Math.min(Math.min(next_multiple_of_2, next_multiple_of_3), next_multiple_of_5);
            ugly[i] = next_ugly;
            System.out.println("min(" + next_multiple_of_2 + "," + next_multiple_of_3 + "," + next_multiple_of_5 + ") = "+next_ugly );

            if (next_ugly == next_multiple_of_2) {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly == next_multiple_of_3) {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly == next_multiple_of_5) {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(getNthUgly(13));
    }
}
