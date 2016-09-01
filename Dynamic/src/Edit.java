import java.util.Arrays;

/**
 * Created by tecso on 27/8/16.
 */
public class Edit {
    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int[][] getEditDistance(char[] X, char[] Y) {
        int L[][] = new int[X.length + 1][Y.length + 1];
        
        for (int i = 0; i <= X.length; i++)
            L[i][0] = i;
        for (int j = 0; j <= Y.length; j++)
            L[0][j] = j;

        for (int i = 1; i <= X.length; i++) {
            for (int j = 1; j <= Y.length; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1]; //no change
                } else {
                    //remove//insert//replace
                    L[i][j] = 1 + min(L[i - 1][j], L[i][j - 1], L[i - 1][j - 1]);
                }
            }
        }
        for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= Y.length; j++) {
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(L[X.length][Y.length]);
        return L;
    }

    public static void printEdits(int[][] L, char[] X, char[] Y) {
        int i = X.length; //swap i&j if out of bound
        int j = Y.length;
        System.out.println(i + " " + j);
        System.out.println(L[i][j]);

        while (true) {
            if (i == 0 || j == 0) {
                break;
            }
            else if (X[i-1] == Y[j-1]) { //move on equal if possible //up or down
                System.out.println("equal chars");
                i--;
                j--;
            } else if (L[i][j] == L[i - 1][j - 1] + 1) {
                System.out.println("edit " + Y[j - 1] + " int str2 to " + X[i - 1]);
                i--;
                j--;
            } else if (L[i][j] == L[i - 1][j] + 1) {
                System.out.println("delete in str1 " + X[i - 1]);//or j-1
                i--;
            } else if (L[i][j] == L[i][j - 1] + 1) {
                System.out.println("delete in str2 " + Y[j - 1]);//or j-1
                j--;
            }
//            System.out.println(i + " " + j);
        }
    }

    public static void main(String[] args) {
        String X = "saturday";
        String Y = "sunday";
        int[][] L = getEditDistance(X.toCharArray(), Y.toCharArray());
        printEdits(L, X.toCharArray(), Y.toCharArray());

    }
}
