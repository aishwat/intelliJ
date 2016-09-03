/**
 * Created by tecso on 3/9/16.
 */
public class LPS {
    //or feed reverse string in LCS
    public static int[][] getLPS(char[] S) {
        int tmp[][] = new int[S.length][S.length];
        int q = 0;
        for (int i = 0; i < S.length; i++) {
            tmp[i][i] = 1;
        }
        for (int l = 1; l < S.length; l++) {
            for (int i = 0; i < S.length - l; i++) {
                int j = i + l;
                if (S[i] == S[j])
                    tmp[i][j] = 2 + tmp[i + 1][j - 1];
                else {
                    tmp[i][j] = Integer.max(tmp[i + 1][j], tmp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S.length; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(tmp[0][S.length - 1]);
        return tmp;
    }

    public static void printLPS(int tmp[][], char S[]) {
        int i = 0;
        int j = tmp[0].length - 1;
        while (true) {
            if (i == j) {
                System.out.print(S[i]);
                break;
            }
            //check left and down . if not equal move diagonal and print
            if (tmp[i + 1][j] == tmp[i][j])
                i++;
            else if (tmp[i][j - 1] == tmp[i][j])
                j--;
            else {
                System.out.print(S[i]+" ");
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        String s = "agbdba";
//        String s = "geeksforgeeks";
        int tmp[][] = getLPS(s.toCharArray());
        printLPS(tmp, s.toCharArray());
    }

}
