package com.company;

/**
 * Created by tecso on 6/6/16.
 */
public class CycleSort {
    public static int sort(int[] A) {
        int pos;
        int item;
        int temp;
        int write = 0;

        for (int cycleStart = 0; cycleStart < A.length - 1; cycleStart++) {
            item = A[cycleStart];
            pos = cycleStart;
            for (int i = cycleStart + 1; i < A.length; i++) {
                if (A[i] < item)
                    pos++;
            }
            if (pos == cycleStart)
                continue;
            while (item == A[pos]) //just a equallity check if elements equal keep pushing pos
                pos++;

            if (item != A[pos]) {
                temp = A[pos];
                A[pos] = item;
                item = temp;
                write++;
            }
            System.out.print(" ");
            print_array(A);
            System.out.println("item:" + item);

            //eventually pos vl be equal cycle sort
            while (pos != cycleStart) {
                pos = cycleStart; //if elem at correct posn , pos == cycleStart

                //element before cycleStart is already placed at correct position
                //and item contains element which was removed
                for (int i = cycleStart + 1; i < A.length; i++) {
                    if (A[i] < item)
                        pos++;
                }
                while (item == A[pos])
                    pos++;

                if (item != A[pos]) {
                    temp = A[pos];
                    A[pos] = item;
                    item = temp;
                    write++;
                }
                System.out.print("-");
                print_array(A);
                System.out.println("item:" + item);
            }
        }
        return write;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 0, 1, 2};
        System.out.print(" ");
        print_array(A);
        System.out.println();
        int writes = sort(A);
        System.out.print(" ");
        print_array(A);
        System.out.println("writes:" + writes);

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
