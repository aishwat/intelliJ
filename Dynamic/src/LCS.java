import java.util.Arrays;

/**
 * Created by tecso on 27/8/16.
 */
public class LCS {
    //    https://www.youtube.com/watch?v=NnD96abizww
    public static int[][] getLCS(char X[], char Y[]) {

        int L[][] = new int[X.length + 1][Y.length + 1];

        for (int[] row : L)
            Arrays.fill(row, 0);

        for (int i = 1; i <= X.length; i++) {
            for (int j = 1; j <= Y.length; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
                }
            }
        }
        for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= Y.length; j++) {
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("LCS length: " + L[X.length][Y.length]);
        return L;
    }

    public static void printSeq(int[][] L, char[] X, char[] Y) {
        int j = Y.length; //swap i&j if out of bound
        int i = X.length;
        System.out.println(i + " " + j);
        //print at diagonal

        while (i >=1 && j >=1) {
            if (L[i][j] == L[i - 1][j]) { //move on equal if possible //up or down
                i = i - 1;
            }
            else if (L[i][j] == L[i][j - 1]){
                j = j - 1;
            }
            else { //else move diagonal and print
                System.out.print(X[i - 1]+" ");//or j-1
                i--;
                j--;
            }
        }

    }

    public static void main(String[] args) {
        String X = "abcdaf";
        String Y = "acbcf";
//        String X = "agbdba"; //for longest palindromic substring
//        String Y = "abdbga";
        int[][] L = getLCS(X.toCharArray(), Y.toCharArray());
        printSeq(L, X.toCharArray(), Y.toCharArray());
    }
}
