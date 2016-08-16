package com.company;

/**
 * Created by tecso on 1/6/16.
 */
public class ShellSort {
    //    https://www.youtube.com/watch?v=dZyvhPIqpH0
    public static void sort(int[] A) {

        for (int gap = A.length / 2; gap > 0; gap = gap / 2) {  //get gap
            System.out.println("gap: " + gap + "\n");

            for (int i = gap; i < A.length; i = i + 1) {  //start traversing on gap one by one
                // insertion sort at gap interval
                int key = A[i];
                int j;
                for (j = i - gap; j >= 0 && A[j] > key; j = j - gap) {
                    A[j + gap] = A[j];
                }
                System.out.println("swapping "+A[j+gap]+" & "+key);
                A[j + gap] = key;

            }
            print_array(A);
            System.out.println("\n");
        }
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

