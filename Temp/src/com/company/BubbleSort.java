package com.company;

/**
 * Created by tecso on 20/5/16.
 */
public class BubbleSort {
    public static void sort(int[] A) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length-1; j++) {
                if (A[j+1] < A[j]) {
                    swap(A, j+1, j);
                }
            }
        }
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
