package com.company;

import com.sun.tools.classfile.Synthetic_attribute;

import java.util.Arrays;

/**
 * Created by tecso on 24/5/16.
 */
public class KSorted {
    public static void heapify(int[] A, int i, int n) {

        int min = i;

        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l <= n && A[l] < A[min]) {
            min = l;
        }
        if (r <= n && A[r] < A[min]) {
            min = r;
        }
        if (min != i) {
            swap(A, i, min);
            heapify(A, min, n);
        }
    }


    public static void create_min_heap(int[] A, int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(A, i, n - 1);
        }
//        print_array(A);
    }

    public static void main(String[] args) {
        int k = 3;
        int[] A = {2, 6, 3, 12, 56, 8};
        int[] heap_k = new int[k];
        for (int i = 0; i < k; i++) {
            heap_k[i] = A[i];
        }

        create_min_heap(heap_k, heap_k.length); //o(k)
//        print_array(heap_k);

        for (int i = 0; i < A.length - k; i++) {
            A[i] = heap_k[0];
            System.out.print("\n\nheap_k:");
            print_array(heap_k);
            System.out.print("\nnext:" + A[i + k]);

            heap_k[0] = A[i + k];
            heapify(heap_k, 0, heap_k.length - 1);
            System.out.print("\nheapified_k:");
            print_array(heap_k);

        }
        for (int i = 0; i < k; i++) {
            A[A.length - k + i] = heap_k[0];
            heap_k = Arrays.copyOfRange(heap_k,1,heap_k.length);
            heapify(heap_k,0,heap_k.length-1);
        }
        System.out.println("\n");
        print_array(A);


    }

    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

}
