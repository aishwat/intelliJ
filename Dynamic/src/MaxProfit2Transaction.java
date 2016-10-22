import java.util.Arrays;

/**
 * Created by tecso on 17/10/16.
 */
public class MaxProfit2Transaction {
    public static int getMaxProfit(int[] price) {
        int n = price.length;
        int[] profit = new int[n];
        Arrays.fill(profit, 0);

        int max_price = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (max_price < price[i])
                max_price = price[i];
            profit[i] = Math.max(profit[i + 1], max_price - price[i]);
        }
        print_array(profit);
        int min_price = price[0];
        for (int i = 1; i < n; i++) {
            if (min_price > price[i])
                min_price = price[i];
            profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - min_price));
        }
        print_array(profit);

        System.out.println("profit:" + profit[n - 1]);
        return profit[n - 1];
    }

    public static void print_array(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int price[] = {2, 30, 15, 10, 8, 25, 80};
        getMaxProfit(price);
    }
}
