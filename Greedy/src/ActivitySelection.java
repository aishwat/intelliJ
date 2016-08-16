/**
 * Created by tecso on 13/8/16.
 */
public class ActivitySelection {
    public static void printMaxActivities(int[] s, int[] f, int n) {
        //assuming activities r sorted according to their finish time
        System.out.println("activities: ");
        int i = 0;
        System.out.println(i);
        for (int j = 1; j < n; j++) {

            if (s[j] > f[i]) {
                System.out.println(j);
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 8, 5};
        int f[] = {2, 4, 6, 7, 9, 9};
        int n = s.length;

        printMaxActivities(s, f, n);
    }
}
