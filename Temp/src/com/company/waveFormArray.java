package com.company;

/**
 * Created by tecso on 16/6/16.
 */
public class waveFormArray {
    public static void sortInWave(int[] A) {
        for (int i = 0; i + 1 < A.length; i = i + 2) {
            if ((i > 0) && (A[i] < A[i - 1]))
                swap(A, i, i - 1);
            if (A[i] < A[i + 1])
                swap(A, i, i + 1);
        }
    }

    public static void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public static void main(String[] args) {
        int[] A = {10, 90, 49, 2, 1, 5, 23};
        sortInWave(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
