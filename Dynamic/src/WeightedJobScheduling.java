import java.util.Arrays;

/**
 * Created by tecso on 21/10/16.
 */
//Like LIS, with different sequence condition
//https://www.youtube.com/watch?v=cr6Ip0J9izc
public class WeightedJobScheduling {
    public static int getMaxProfit(Job[] jobs) {
        Arrays.sort(jobs);
        int n = jobs.length;
        int profit[] = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = jobs[i].profit;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (jobs[i].start >= jobs[j].finish)
                    profit[i] = Math.max(profit[i], profit[j] + jobs[i].profit);
            }
        }

        int max = profit[0];
        for (int i = 0; i < n; i++) {
            if (max < profit[i])
                max = profit[i];
            System.out.print(profit[i] + " ");
        }
        System.out.println();
        System.out.println("profit: " + max);
        return max;
    }

    public static void main(String[] args) {
        Job jobs[] = {new Job(1, 3, 5), new Job(2, 5, 6), new Job(4, 6, 5), new Job(6, 7, 4), new Job(5, 8, 11), new Job(7, 9, 2)};
        getMaxProfit(jobs);
    }
}

class Job implements Comparable<Job> {
    int start, finish, profit;

    public Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job o) {
        return this.finish - o.finish;
    }
}
