package com.company;

/**
 * Created by tecso on 21/5/16.
 */
public class MergeSortIterative {
    public int inv_count = 0;
    public int inversions = 0;

    public void sort(int[] A) {
        System.out.println("Log(A.len):" + log(A.length, 2));

        for (int i = 0; i < log(A.length, 2); i++) { //log A.len
            int r = 1 << i + 1; //2^i// shift 1 i+1 times to left
            //2<<i
            int mid = r >> 1;
            for (int j = 0; j + r <= A.length; j = j + r) {
                System.out.print("offset:" + j + " mid:" + (j + mid) + " r:" + (j + r));
                merge(A, j, (j + mid), (j + r));
            }
        }
    }

    public void merge(int[] A, int offset, int mid, int n) {
        mid = mid - offset;
        n = n - offset;
        int[] L = new int[mid];
        int[] R = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            L[i] = A[i + offset];
            R[i] = A[mid + i + offset];
        }
        System.out.print("\nL:");
        print_array(L);
        System.out.print("\nR:");
        print_array(R);

        int l = 0;
        int r = 0; //left right pointer
        int k = offset;
        while (l < mid && r < mid) {
            if (L[l] < R[r]) {
//                System.out.println("in left");
                A[k] = L[l];
                l++;
            } else {
                inv_count += L.length - l;
//                System.out.println("in right");
                A[k] = R[r];
                r++;
            }
            k++;
        }
        while (l < mid) {
            A[k] = L[l];
            l++;
            k++;
        }
        while (r < mid) {
            A[k] = R[r];
            r++;
            k++;
        }

        System.out.print("\nA:");
        print_array(A);
        System.out.print("\n\n");

    }

    public static void print_array(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public void brute(int[] A) {

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    inversions++;
                }
            }
        }
    }

    static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
}

class foo {
    public static void main(String[] args) {
        int[] A = {8, 7, 6, 5, 4, 3, 2, 1};
        MergeSortIterative msi = new MergeSortIterative();
        msi.brute(A); //before sorting
        msi.sort(A);

        msi.print_array(A);
        System.out.println("\ninv count: " + msi.inv_count);
        System.out.println("\nbrute_inversions: " + msi.inversions);
    }
}

