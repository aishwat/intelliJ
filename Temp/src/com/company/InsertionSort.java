package com.company;

/**
 * Created by tecso on 21/5/16.
 */
public class InsertionSort {
    //5,6,7,1
    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void sort_down(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j;
            for (j = i - 1; j >= 0 && A[j] > key; j--) {
                A[j + 1] = A[j];
            }
            // if confusion here
            //lets say 9,8
            //i vl be 9, j vl be 0 in for, 1 swap ,in next iter , j-- and condition false
            //so j here -1
            A[++j] = key;
        }
    }

    public static void sort_up(int[] A) {
        for (int i = 1; i < A.length; i++) {
            print_array(A);
            System.out.print("\n");
            for (int j = 0; j < i; j++) { //must be j=i-1 down to 0, if a[i] > a[j] keep going and break if not
                if (A[i] < A[j]) {
                    rsh_insert(A, i, j);
                    break;
                }
            }
            print_array(A);
            System.out.println("\n");
        }
    }

    public static void rsh_insert(int[] A, int i, int j) {
        int tmp = A[i];
        System.out.println("i: " + i + " j: " + j);
        for (int k = i; k > j; k--) {
            System.out.print("k:" + k + " ");
            A[k] = A[k - 1]; //rsh by 1 till i
        }
        System.out.print("\n");
        A[j] = tmp;
    }

    public static void sort_while(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] A = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort_down(A);
        print_array(A);
    }



}
