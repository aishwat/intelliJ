package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by tecso on 31/5/16.
 */
public class BucketSort {
    public static void sort(float[] A) {
        int n = A.length;
        ArrayList<Float> b[] = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            b[i] = new ArrayList<Float>();
        }

        for (int i = 0; i < n; i++) {
            int index = (int) (A[i] * 10);
            b[index].add(A[i]);
        }
        for (int i = 0; i <= 9; i++) {
            Collections.sort(b[i]);
        }
        int cnt = 0;
        for (int i = 0; i <= 9; i++) {
            for (float f : b[i]) {
                System.out.print(f+" ");
                A[cnt] = f;
                cnt++;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        float A[] = {(float) 0.897, (float) 0.565, (float) 0.656, (float) 0.1234, (float) 0.665, (float) 0.3434};
        sort(A);
        print_array(A);
    }

    public static void print_array(float[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
