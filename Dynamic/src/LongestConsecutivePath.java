/**
 * Created by tecso on 28/9/16.
 */
//https://ideone.com/c3KqCm
//    depth first search basically
public class LongestConsecutivePath {
    public static int R = 3;
    public static int C = 3;

    public static int[][] T = new int[R][C];

    public static boolean isValid_i_j(int i, int j) {
        if (i < 0 || j < 0 || i >= R || j >= C)
            return false;
        return true;
    }

    public static boolean isNextChar(char prev, char curr) {
        return ((curr - prev) == 1);
    }

    public static void initT() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                T[i][j] = -1;
            }
        }
    }

    public static int getLongestConsecutivePath(char[][] a, int i, int j, char prev) {

//        System.out.println("prev: " + prev + " curr:" + a[i][j]);
        if (!isValid_i_j(i, j) || !isNextChar(prev, a[i][j]))
            return 0;
        if (T[i][j] != -1)
            return T[i][j];

        int ans = 0;
//        top left then clockwise
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i - 1, j - 1, a[i][j]));
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i - 1, j, a[i][j]));
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i - 1, j + 1, a[i][j]));
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i, j + 1, a[i][j]));
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i + 1, j + 1, a[i][j]));
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i + 1, j, a[i][j]));
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i + 1, j - 1, a[i][j]));
        ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i, j - 1, a[i][j]));

        T[i][j] = ans;
        return ans;
    }

    public static int getLen(char[][] a, char c) {
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i][j] == c) {
//                  top left then clockwise
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i - 1, j - 1, a[i][j]));
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i - 1, j, a[i][j]));
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i - 1, j + 1, a[i][j]));
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i, j + 1, a[i][j]));
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i + 1, j + 1, a[i][j]));
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i + 1, j, a[i][j]));
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i + 1, j - 1, a[i][j]));
                    ans = Math.max(ans, 1 + getLongestConsecutivePath(a, i, j - 1, a[i][j]));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char mat[][] = {{'a', 'c', 'd'},
                {'h', 'b', 'a'},
                {'i', 'g', 'f'}};
        initT();
        System.out.println(getLen(mat, 'a'));
        initT();
        System.out.println(getLen(mat, 'e'));
        initT();
        System.out.println(getLen(mat, 'b'));
        initT();
        System.out.println(getLen(mat, 'f'));
    }


}
