package com.company;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tecso on 25/5/16.
 */
public class QuickSort {
    public static int partition(int[] A, int l, int r) {
        int pivot_index = r;
        int pivot = A[pivot_index]; // just to generalize
        int i = l;//left pointer
        for (int j = l; j < r; j++) {
            if (A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, pivot_index);//pivot_index's element was never touched
        return i;
    }

    //Dutch National Flag
    public static int[] partition_dnf(int[] A, int lo, int hi) {
        int i, j, mid, pivot, pivot_index;
//        i = lo;
//        j = hi;
        pivot_index = hi;
        pivot = A[pivot_index];
        mid = lo;
        if (hi - lo <= 1) { //2 elements
            if (A[hi] < A[lo])
                swap(A, lo, hi);
        }
        System.out.println("\n lo:" + lo + " mid:" + mid + " high:" + hi);
        while (mid <= hi) {
            if (A[mid] < pivot) {
                swap(A, mid, lo);
                lo++;
                mid++;
            } else if (A[mid] == pivot) {
                mid++;
            } else if (A[mid] > pivot) {
                swap(A, mid, hi);
                hi--;
//                mid++;
            }
            System.out.println("lo:" + lo + " mid:" + mid + " high:" + hi);
        }
        return new int[]{lo - 1, mid}; //lo-1 bcoz we dont pass index of pivot , less than pivot and greater than pivot

    }

    public static void quick_sort_rec(int[] A, int l, int r) {
        if (l < r) { //recursion ending condition
            int pivot = partition(A, l, r);
            quick_sort_rec(A, l, pivot - 1);
            quick_sort_rec(A, pivot + 1, r);
        }
    }

    public static void quick_sort_iter(int[] A, int lo, int hi) {
        Stack stack_left = new Stack();
        Stack stack_right = new Stack();
        stack_left.push(lo);
        stack_right.push(hi);

        while (!stack_left.empty()) {
            int right = (int) stack_right.pop();
            int left = (int) stack_left.pop();
            //pivot-1,pivot,pivot+1
            int pivot = partition(A, left, right);
            if (pivot - 1 > left) { //no point if pivot-1 == l
                stack_left.push(left);
                stack_right.push(pivot - 1);
            }
            if (pivot + 1 < right) {
                stack_left.push(pivot + 1);
                stack_right.push(right);
            }
            System.out.println(stack_left);
            System.out.println(stack_right);
        }
    }

    public static void quick_sort_dnf(int[] A, int l, int r) {
        if (l < r) {
            int[] partition_dnf = partition_dnf(A, l, r);
            print_array(partition_dnf);
            quick_sort_dnf(A, l, partition_dnf[0]);
            quick_sort_dnf(A, partition_dnf[1], r);
        }
    }

    public static int getKthLargest(int[] A, int l, int r, int k) {
        while (true) {
            int p = partition(A, l, r);
            if (p == k)
                return A[p];
            else if (p < k)
                l = p + 1;
            else if (p > k)
                r = p - 1;
        }
    }

    public static void main(String[] args) {
//        int A[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
        int[] A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] A = {1,2,3,4,5,6,7,8};
//        quick_sort_rec(A, 0, A.length - 1);
//        quick_sort_iter(A, 0, A.length - 1);
//        quick_sort_dnf(A, 0, A.length - 1);
        // for 4th largest , pivot index vl be 3
        System.out.println(getKthLargest(A,0,A.length-1,3));
//        print_array(A);
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
