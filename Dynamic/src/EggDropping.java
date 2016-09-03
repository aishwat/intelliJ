import java.util.Arrays;

/**
 * Created by tecso on 3/9/16.
 */
public class EggDropping {
    //if given 2 eggs
    //use direct formula
    //https://www.youtube.com/watch?v=ZuyUh3pegVo
    //x^2+x-100 = 0 , 100 floors or whatever
    //to scale for n eggs use DP
    public static int getMaxAttempts(int egg, int floor) {
        int tmp[][] = new int[egg + 1][floor + 1]; //tmp or eggFloor
        int q = 0;
        //no use of 0th row and 0th col

        for (int i = 1; i <= egg; i++) {
            tmp[i][1] = 1;
            tmp[i][0] = 0;
        }
        for (int i = 1; i <= floor; i++) {
            tmp[1][i] = i;
        }

        for (int i = 2; i <= egg; i++) {
            for (int j = 2; j <= floor; j++) {
                tmp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++){
                    q = 1 + Integer.max(tmp[i - 1][k - 1], tmp[i][j - k]);
                    if (q < tmp[i][j])
                        tmp[i][j] = q;
                }
            }
        }
        for (int i = 0; i <= egg; i++) {
            for (int j = 0; j <= floor; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        return tmp[egg][floor];
    }

    public static void main(String[] args) {
        getMaxAttempts(2,6 );
    }
}
