/**
 * Created by tecso on 28/9/16.
 */
//Total number of non-decreasing numbers with n digits
//    1digit = n
//    2digit = n(n+1)/2
//    3digit = n(n+1)(n+2)/6
// for DP sol follow https://www.geeksforgeeks.org/number-n-digits-non-decreasing-integers/
public class NumbersWithIncreasingDigits {
    public static int getCountOfNondecresingNumbers(int n) {
        int N = 10;
        int tmp = 10;
        for (int i = 1; i < n; i++) {
            tmp = tmp * (N + i)/(i+1);
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(getCountOfNondecresingNumbers(1));
        System.out.println(getCountOfNondecresingNumbers(2));
        System.out.println(getCountOfNondecresingNumbers(3));
    }

}
