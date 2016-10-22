import java.util.Arrays;

/**
 * Created by tecso on 21/10/16.
 */
//given 3,5,10
public class WaysToReachGivenScore {
    public static int getNumberOfWaysToReachGivenScore(int n) {
        int table[] = new int[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 3; i <= n; i++) {
            table[i] += table[i - 3];
        }
        for (int i = 5; i <= n; i++) {
            table[i] += table[i - 5];
        }
        for (int i = 10; i <= n; i++) {
            table[i] += table[i - 10];
        }
        System.out.println(table[n]);
        return table[n];
    }

    public static void main(String[] args) {
        getNumberOfWaysToReachGivenScore(20);//4
        getNumberOfWaysToReachGivenScore(13);//2
    }
}
