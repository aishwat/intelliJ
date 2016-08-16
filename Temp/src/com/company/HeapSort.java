package com.company;

/**
 * Created by tecso on 23/5/16.
 */
public class HeapSort {
    public static void heapify_iterative(int[] A, int i, int n) {
        int max = i;
        int l = (i << 1) + 1; //2i+1
        int r = (i + 1) << 1; //2i+2 = 2(i+1)
        while (l < n && r < n) {
            System.out.println("l:" + l + " r:" + r);
            if (A[max] < A[l]) {
                swap(A, max, l);
                max = l;
            } else if (A[max] < A[r]) {
                swap(A, max, r);
                max = r;
            }
            if (max == i) {
                System.out.println("break");
                break; //no need to process further down
            }
            else {
                i = max;
                l = (max << 1) + 1; //get l and r of max
                r = (max + 1) << 1;
            }
        }
    }

    //rec clean here
    public static void heapify_rec(int[] A, int i, int n) {
        int max = i;
        int l = (i << 1) + 1; //2i+1
        int r = (i + 1) << 1; //2i+2 = 2(i+1)
        if (l <= n && A[max] < A[l]) //imp to check <n - terminating condition
            max = l;
        if (r <= n && A[max] < A[r])
            max = r;
        if (max != i) {
            swap(A, i, max);
            heapify_rec(A, max, n);
        }
    }

    public static void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    public static void build_max_heap(int[] A) {
        int n = A.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
//            System.out.println("i: " + i);
            heapify_rec(A, i, n-1);
//            print_array(A);
        }

        print_array(A);
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] A = {8,7,6,5,4,3,2,1,0};
        build_max_heap(A);
        for (int i = A.length - 1; i > 0; i--) {
            swap(A, 0, i);
            heapify_rec(A, 0, i-1);
            System.out.print("\n");
            print_array(A);
        }


    }

    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
