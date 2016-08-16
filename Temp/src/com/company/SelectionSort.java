package com.company;

/**
 * Created by tecso on 01/04/16.
 */
public class SelectionSort {
    public static void sort(int[] A) {
        for (int i = 0; i < A.length; i++) { //i = pos
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    swap(A, i, j);
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
        int A[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
