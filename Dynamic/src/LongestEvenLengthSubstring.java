/**
 * Created by tecso on 21/10/16.
 */
// LongestEvenLengthSubstring such that sum of first and second half is same
public class LongestEvenLengthSubstring {
    public static int getMaxLengthSubstring_DP(char[] str) {
        int maxLen = 0;
        int n = str.length;
        int sum[][] = new int[n][n];
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l - 1;

                int k = l / 2;
                sum[i][j] = sum[i][i + k] + sum[i + k + 1][j];

                if (l % 2 == 0 && sum[i][i + k] == sum[i + k + 1][j] && l > maxLen) {
                    maxLen = l;
                }
            }
        }
        System.out.println(maxLen);
        return maxLen;
    }

    public static int getMaxLengthSubstring(char[] str) {
        int n = str.length;
        int max =0;
        for (int i = 0; i < n-1; i++) {
            int l = i;
            int r = i + 1;
            int lsum =0;
            int rsum =0;
            while (l>0 && r<n){
                lsum+=str[l];
                rsum+=str[r];
                if(lsum==rsum){
                    max = Math.max(max,r-l+1);
                }
                l--;
                r++;
            }
        }
        System.out.println(max);
        return max;
    }


    public static void main(String[] args) {
        String str = "153803";
        getMaxLengthSubstring_DP(str.toCharArray());
        getMaxLengthSubstring(str.toCharArray());
    }
}
