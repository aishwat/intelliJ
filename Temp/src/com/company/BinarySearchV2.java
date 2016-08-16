package com.company;

/**
 * Created by tecso on 20/5/16.
 */
public class BinarySearchV2 {
    public static int floor(int A[], int l, int r, int key) {
        int m = 0;

        while (r - l > 1) {
            m = l + r >>> 1;
            System.out.println("l: " + l + " m: " + m + " r:" + r);
            if (A[m] == key)
                return A[m];
            if (A[m] < key) {
                l = m;
            } else {
                r = m;
            }
            System.out.println("l: " + l + " m: " + m + " r:" + r + "\n");
        }
        return A[l];
//        ceiling A[r]
    }

    public static int first(int A[], int l, int r, int key) {
        int m = 0;

        while (r - l > 1) {
            m = l + r >>> 1;
            System.out.println("l: " + l + " m: " + m + " r:" + r);
            if (A[m] >= key) {
                r = m;
            } else {
                l = m;
            }
            System.out.println("l: " + l + " m: " + m + " r:" + r + "\n");
        }
        return r;
    }
    public static int last(int A[], int l, int r, int key) {
        int m = 0;

        while (r - l > 1) {
            m = l + r >>> 1;
            System.out.println("l: " + l + " m: " + m + " r:" + r);
            if (A[m] <= key) {
                l = m;
            } else {
                r = m;
            }
            System.out.println("l: " + l + " m: " + m + " r:" + r + "\n");
        }
        return l;
    }

    public static int getMin(int A[], int l, int r) {
        int m = 0;
        while (l < r) {
            m = l + r >>> 1;
            System.out.println("l: " + l + " m: " + m + " r:" + r);
            if (m < r && A[m] > A[m + 1])
                return m + 1;
            else if (m < r && A[m] < A[m - 1])
                return m;
            else if (A[m] < A[r])
                r = m - 1;
            else
                l = m + 1;

        }
        return m;
    }

    public static void main(String[] args) {
//        int[] arr = {-1, 2, 3, 5, 6, 6, 6, 6, 6, 6, 6, 8, 9, 10};
        //////////////0  1  2  3  4  5  6  7  8  9  10,11,12,13
//        int[] rot_arr = {13, 14, 15, 6, 7, 8, 9, 10, 11, 12};
        /////////////////0  1  2  3  4  5  6  7  8  9  10 11
        int[] A = {1,2,3,4,5,6,8};
        int floor = floor(A, 0, A.length-1 , 7);
        System.out.println("floor: " + floor);
//        int pivot = getMin(rot_arr, 0, rot_arr.length - 1);
//        System.out.println("pivot:" + pivot);
    }

}
