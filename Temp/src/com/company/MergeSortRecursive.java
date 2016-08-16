package com.company;

/**
 * Created by tecso on 22/5/16.
 */
public class MergeSortRecursive {
    public static void merge(int[] A, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[m + 1 + i];
        }
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }


    }

    public static void sort(int[] A, int l, int r) {
        if (l < r) {
            int m = l + r >>> 1;
            sort(A, l, m);
            sort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] A = {8, 7, 6, 5, 4, 3, 2, 1};
        sort(A, 0, A.length - 1);
        print_array(A);

    }

    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
