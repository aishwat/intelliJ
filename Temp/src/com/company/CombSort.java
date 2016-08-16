package com.company;

/**
 * Created by tecso on 3/6/16.
 */
public class CombSort {
    public static void sort(int[] A) {
        int gap = (int) (A.length / 1.3);

        for (; gap >= 1; gap /= 1.3) {

            for (int i = 0; i + gap < A.length; i++) {
                if (A[i] > A[i + gap]) {
                    swap(A, i, i + gap);
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
        int[] A = {4, 3, 7, 2, 1, 9, 5, 6};
        sort(A);
        print_array(A);
    }

    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
