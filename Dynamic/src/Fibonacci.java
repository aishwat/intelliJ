import java.util.Arrays;

/**
 * Created by tecso on 17/9/16.
 */
public class Fibonacci {
    public static int F[] = new int[1000];

    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        if (F[n] != 0)
            return F[n];

        int k;
        if (n % 2 == 0) {
            k = n / 2;
            F[n] = 2 * fib(k - 1) * fib(k) + fib(k) * fib(k);
        } else {
            k = (n + 1) / 2;
            F[n] = fib(k) * fib(k) + fib(k - 1) * fib(k - 1);
        }
        return F[n];
    }

    public static void main(String[] args) {
        int fib = fib(9); //34
        System.out.println("Fib: " + fib);
    }
}
