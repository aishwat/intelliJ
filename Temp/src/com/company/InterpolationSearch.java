package com.company;

/**
 * Created by tecso on 5/6/16.
 */
public class InterpolationSearch {
    public static int search(int[] A, int value) {
        // value-x, index-y
        //y = mx+c
        //y2 = (y2-y1)/(x2-x1) *(x-x1) + y1
        int hi = A.length - 1;
        int lo = 0;

        while (A[hi] >= value && A[lo] <= value) {
            int slope = (hi - lo) / (A[hi] - A[lo]);
            System.out.println("slope:"+slope);
            int x = value - A[lo];
            int index = slope * x + lo;
            System.out.println("lo: "+lo+" hi: "+hi+" index: "+index);
            if (A[index] < value)
                lo = index + 1;
            else if (A[index] > value)
                hi = index + 1;
            else {
                return index;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] A = {2,3,4,5,6,7,8};
        int index = search(A, 2);
        if (index == -1)
            System.out.println("not found");
        else
            System.out.println("at: " + index);
    }

}
