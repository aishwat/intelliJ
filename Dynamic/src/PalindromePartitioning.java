/**
 * Created by tecso on 12/9/16.
 */
public class PalindromePartitioning {
    public static void getMinPartitions(char a[]) {
        int tmp[][] = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[i][i] = 0;
        }
        for (int l = 1; l < a.length; l++) {
            for (int i = 0; i < a.length - l; i++) {
                int j = i + l;

                if (isPalindrome(a, i, j))
                    tmp[i][j] = 0;
                else if (l == 1) {
                    tmp[i][j] = 1;

                } else {
                    tmp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) { // i to j-1
                        if (tmp[i][j] > 1 + tmp[i][k] + tmp[k + 1][j])
                            tmp[i][j] = 1 + tmp[i][k] + tmp[k + 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isPalindrome(char[] str, int r, int t) {
        while (r < t) {
            if (str[r] != str[t]) {
                return false;
            }
            r++;
            t--;
        }
        return true;
    }

    public static void main(String[] args) {
//        String str = "abcbm";
        String str = "ababbbabbababa";
        getMinPartitions(str.toCharArray());
        //need to get actual partitions - later
    }
}
