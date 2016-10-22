/**
 * Created by tecso on 15/10/16.
 */
//http://code.geeksforgeeks.org/py60Gb
public class ShortestCommonSuperseq {
    public static String getLCS(char[] a, char[] b) {
        int T[][] = new int[a.length + 1][b.length + 1];
        for (int i = 0; i <= a.length; i++) {
            T[i][0] = 0;
        }
        for (int i = 0; i <= b.length; i++) {
            T[0][i] = 0;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1])
                    T[i][j] = T[i - 1][j - 1] + 1;
                else
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
            }
        }
        System.out.println("len:" + T[a.length][b.length]);
        int i = a.length, j = b.length;
        StringBuilder tmp = new StringBuilder();
        while (i >= 1 && j >= 1) {
            if (T[i - 1][j] == T[i][j])
                i--;
            else if (T[i][j - 1] == T[i][j])
                j--;
            else {
                tmp.append(a[i - 1]);
                i--;
                j--;
            }
        }
        tmp = tmp.reverse();
        System.out.println(tmp);
        return tmp.toString();
    }

    public static String getSCS(char[] a, char[] b) {
        String _lcs = getLCS(a, b);
        char[] lcs = _lcs.toCharArray();
        int i = 0, j = 0, k = 0;
        StringBuilder scs = new StringBuilder();
        while (i < a.length && j < b.length) {
            if (a[i] != lcs[k] && b[j] != lcs[k]) {
                scs.append(a[i]);
                scs.append(b[j]);
                i++;
                j++;
            } else if (a[i] != lcs[k] && b[j] == lcs[k]) {
                scs.append(a[i]);
                i++;
            } else if (a[i] == lcs[k] && b[j] != lcs[k]) {
                scs.append(b[j]);
                j++;
            } else if (a[i] == lcs[k] && b[j] == lcs[k]) {
                scs.append(a[i]);
                i++;
                j++;
                k++;
            }
        }
        while (i < a.length) {
            scs.append(a[i]);
            i++;
        }
        while (j < b.length) {
            scs.append(b[j]);
            j++;
        }
        System.out.println(scs.toString());
        return scs.toString();
    }

    public static void main(String[] args) {
//        String X = "geek";
//        String Y = "eke";
//    gekek
        String X = "AGGTAB";
        String Y = "GXTXAYB";
//        AGXGTXAYB
        getSCS(X.toCharArray(), Y.toCharArray());
    }
}
