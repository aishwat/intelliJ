package com.company;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by tecso on 29/5/16.
 */
public class CountingSort {
    static int range = 16;
    //0 to 15 - hex

    public static void sort(int[] A) {
        //7,5,3,1             - A
        //0 1 2 3 4 5 6 7 8 9
        //0 1 0 1 0 1 0 1 0 0 - count
        //0 1 1 2 2 3 3 4 4 4 - pos
        //count[A[i]] is the actual posn now

        int[] count = new int[range];
        int[] output = new int[A.length];
        Arrays.fill(count, 0);
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++; //got count of each element
        }
        for (int i = 1; i < range; i++) { // 1 to 15
            count[i] += count[i - 1]; // got posn of each element
        }
        for (int i = A.length - 1; i >= 0; i--){ //for stable sort go from a.len to 0
            output[count[A[i]] - 1] = A[i]; // -1 for index in output
            count[A[i]]--;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = output[i];
        }
    }

    public static void sort_neg_range(int[] A) {
        IntSummaryStatistics stats = Arrays.stream(A).summaryStatistics();
        int min = stats.getMin();
        int max = stats.getMax();
        //range as max-min+1 and count[A[i]-min] thats it
        range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[A.length];
        Arrays.fill(count, 0);
        for (int i = 0; i < A.length; i++) {
            count[A[i] - min]++; //got count of each element
        }
        for (int i = 1; i < range; i++) { // 1 to 15
            count[i] += count[i - 1]; // got posn of each element
        }
        for (int i = 0; i < A.length; i++) {
            output[count[A[i] - min] - 1] = A[i]; // -1 for index in output
            count[A[i] - min]--;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] A = {-2, -1, -1, 7, 5, 3, 1};
        sort_neg_range(A);
        print_array(A);
    }

    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
