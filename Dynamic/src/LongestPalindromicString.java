/**
 * Created by tecso on 20/9/16.
 */
//Manachers
//understand from
//https://www.youtube.com/watch?v=V-sEwsca1akhttps://www.youtube.com/watch?v=V-sEwsca1ak
//code from
//https://www.youtube.com/watch?v=nbTSfrEfo6M
public class LongestPalindromicString {
    public static void getLongestPalindromicString(char a[]) {
        char[] T = new char[2 * a.length + 3];
        T[0] = '$';
        T[a.length * 2 + 2] = '@';
        for (int i = 0; i < a.length; i++) {
            T[2 * i + 1] = '#';
            T[2 * i + 2] = a[i];
        }
        T[a.length * 2 + 1] = '#';

        int[] P = new int[T.length];
        int R = 0, C = 0;

        for (int i = 1; i < T.length - 1; i++) {
            int mirr = 2 * C - i;

            if (i < R) //if r lies in boundary
                P[i] = Math.min(P[mirr], R - i);

            while (T[i + P[i] + 1] == T[i - (P[i] + 1)]) // calculate len beyound P[i]
                P[i]++;

            if (i + P[i] > R) {
                //check if new palindrome len going beyond R
                //make this i center and shift R
                C = i;
                R = i + P[i];
            }
        }

        print_array(P);
        int len = 0, center = 0;
        for (int i = 1; i < P.length - 1; i++) {
            if (P[i] > len) {
                len = P[i];
                center = i;
            }
        }
        System.out.println(len + " " + center);
        for (int i = (C - 1 - len) / 2; i < (C - 1 + len) / 2; i++) {
            System.out.print(a[i]);
        }
    }

    public static void main(String[] args) {
        String s = "abababa";
        getLongestPalindromicString(s.toCharArray());
    }

    public static void print_array(int[] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
