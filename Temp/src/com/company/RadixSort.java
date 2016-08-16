package com.company;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

import static java.lang.Math.pow;

/**
 * Created by tecso on 29/5/16.
 */
public class RadixSort {
    public static int range = 10;

    public static void sort(int[] A) {
        IntSummaryStatistics stats = Arrays.stream(A).summaryStatistics();
        int min = stats.getMin();
        int max = stats.getMax();
        int digits = String.valueOf(max).length();

        for (int pos = 1; pos < pow(10, digits); pos = pos * 10) { //1st,10th,100th pos
            System.out.println("digit:" + pos);
            count_sort_on_digit(A, pos);
//            countSort(A,A.length,pos);
        }
    }

    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void count_sort_on_digit(int[] A, int pos) {
        int[] count = new int[range];
        int[] output = new int[A.length];
        Arrays.fill(count, 0);
        for (int i = 0; i < A.length; i++) {
            count[(A[i] / pos) % 10]++; //got count of each element
        }
        for (int i = 1; i < range; i++) { // 1 to 15
            count[i] += count[i - 1]; // got posn of each element
        }
        for (int i = A.length - 1; i >= 0; i--) {
            output[count[(A[i] / pos) % 10] - 1] = A[i];
            count[(A[i] / pos) % 10]--;
        }
//        from 0 to a.len reverses order , not stable
//        http://stackoverflow.com/questions/2572195/how-is-counting-sort-a-stable-sort
//        for (int i = 0; i < A.length; i++) {
//            output[count[(A[i] / pos) % 10] - 1] = A[i]; // -1 for index in output
//            count[(A[i] / pos) % 10]--;
//        }
        for (int i = 0; i < A.length; i++) {
            A[i] = output[i];
        }
        print_array(A);
        System.out.println("\n");
    }

    public static void main(String[] args) {
//        int[] A = {1, 3, 41, 52, 102, 104};
//        sort(A);
        //if rang is 0 to n^2-1
        //change base to n
        //O(d*(n+b)) , d is digits log(k) <K is highest or range> which becomes log<baseb>(k)
        //if k is n^c and b is n// d becomes log<basen>(n^c) = c
        //radix becomes O(n+n) = O(n)
        //we just need to evaluate everything on base n
        int A[]= {0, 23, 14, 12, 9};
        int n = A.length;
        countSort(A,n,1);  //n^0
        countSort(A,n,n); //n^1

        print_array(A);
    }

    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
