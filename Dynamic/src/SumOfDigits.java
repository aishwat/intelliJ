/**
 * Created by tecso on 28/9/16.
 */
//count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum
//count
//remember pattern
//http://disq.us/p/19u8kss
//    direct formula (s+n-2)C(n-1). http://disq.us/p/10x37n9
//http://math.stackexchange.com/questions/1635838/find-numbers-whose-sum-of-digits-equals-a-value
public class SumOfDigits {

    public static long getCountOfWays(int sum, int n) {
        long T[][] = new long[sum][n];
//        T[i][j] denotes ways to get i sum from j digits
        for (int i = 0; i < sum; i++) {
            T[i][0] = 1; //ways to get sum from 1 digit, vl remain 1
        }
        for (int i = 0; i < n; i++) {
            T[0][i] = i+1; //ways to get 1 from n digit, vl remain n
        }

        for (int i = 1; i < sum; i++) {
            for (int j = 1; j < n; j++) {
//               sum of top and left
                T[i][j] = T[i-1][j]+T[i][j-1];
            }
        }
        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(T[i][j]+" ");
            }
            System.out.println();
        }
        return T[sum-1][n-1] - T[sum-1][n-2];
        //minus cases where 0 is first digit and other 2 get sum
        //for T[6][3]
        //0 + {6 using two digits} this case has to be eliminated
        //which is T[6][2]
    }

    public static void main(String[] args) {
//        6,3 ans 21
//        System.out.println(getCountOfWays(6,3));
        System.out.println(getCountOfWays(40,50));
    }
}
