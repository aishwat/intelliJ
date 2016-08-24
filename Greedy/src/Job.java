import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.min;

/**
 * Created by tecso on 21/8/16.
 */
//https://www.youtube.com/watch?v=yHsDLU3ZqNM
public class Job implements Comparable<Job> {
    char id;
    int dead, profit;

    public Job(char id, int dead, int profit) {
        this.id = id;
        this.dead = dead;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job o) {
        //decreasing order
        return o.profit - this.profit;
    }

    public static int findMaxDeadline(ArrayList<Job> jobs)
    {
        int max = Integer.MIN_VALUE;
        for (Job temp : jobs)
            max = Math.max(temp.dead, max);
        System.out.println("max_dead:"+max);
        return max;
    }

    public static void printJobs(ArrayList<Job> jobs) {
        int max_dead = findMaxDeadline(jobs);

        boolean slots[] = new boolean[max_dead];
        char result[] = new char[max_dead];
        Arrays.fill(slots, false);
        Arrays.fill(result, '0');

        Collections.sort(jobs);

        for (Job job : jobs) {

            for (int j = min(max_dead, job.dead) - 1; j >= 0; j--) {
                if (slots[j] == false) {
                    System.out.println("setting slot "+j+" for job "+job.id);
                    slots[j] = true;
                    result[j] = job.id;
                    break;
                }
            }
        }
//
//        for (int i = 0; i < max_dead; i++) {
//            System.out.println("slot:" + i + " result:" + result[i]);
//        }
    }
    public static void main(String args[])
    {
        ArrayList<Job> arr=new ArrayList<Job>();
        arr.add(new Job('a',2,100));
        arr.add(new Job('b',1,19));
        arr.add(new Job('c',2,27));
        arr.add(new Job('d',1,25));
        arr.add(new Job('e',3,15));
        System.out.println("Following jobs need to be "+
                "executed for maximum profit");
        Job.printJobs(arr);
    }
}


