/**
 * Created by tecso on 28/9/16.
 */
//Minimum number of squares whose sum equals to given number n
//https://ideone.com/c3KqCm 2nd method
public class MinNumberOfSquares {
    public static int getMinNumberOfSquares(int sum) {
        int T[][] = new int[sum + 1][10];
//        col is numbers, row is sum
//        T[i][j] denotes min number of square factors for given numbers till j and given sum i
        for (int i = 0; i < 10; i++) {
            T[0][i] = 0;
        }
        for (int i = 0; i <= sum; i++) {
            T[i][0] = 99;
            T[i][1] = i;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 2; j < 10; j++) {
                if (j * j > i)
                    T[i][j] = T[i][j - 1]; // new j doesnt contribute in factors
                else
                    T[i][j] = Math.min(T[i][j - 1], T[i - j * j][j] + 1);
//                either not picking next j as factor(T[i][j-1]) or
//                picking j as factor(+1) and then seeing min num of factors for remaining sum
            }
        }
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(T[i][j]+" ");
            }
            System.out.println();
        }
        return T[sum][9];
    }

    public static void main(String[] args) {
        System.out.println(getMinNumberOfSquares(6)); //ans 3
    }
}
