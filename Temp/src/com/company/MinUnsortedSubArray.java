package com.company;

/**
 * Created by tecso on 6/6/16.
 */

//http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
public class MinUnsortedSubArray {
    public static void getSubArray(int[] A) {
        int start = 0, end = 0;
        int n = A.length - 1;
        //these 2 for loop make n
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                start = i;
                break;
            }
        }
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] < A[i - 1]) {
                end = i;
                break;
            }
        }

        if (start < end) {

            int max = A[start], min = A[start];
            //x elements
            for (int i = start; i <= end; i++) {
                if (max < A[i])
                    max = A[i];
                if (min > A[i])
                    min = A[i];
            }
            //n-x elements
            //ideally, all elements in array before start must be smaller than min of sub array
            //if not, mark that element as start
            for (int i = start - 1; i >= 0; i--) {
                if (A[i] > min) {
                    start = i; //no break, so does this till first element
                }
            }
            for (int i = end; i < A.length; i++) {
                if (A[i] < max) {
                    end = i; //does till last element
                }
            }
            System.out.println("start:" + start + " end:" + end);

        } else {
            System.out.println("start >= end");
        }
    }

    public static void main(String[] args) {
        int[] A = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        getSubArray(A);
    }
}
