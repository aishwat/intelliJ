package com.company;

/**
 * Created by tecso on 17/6/16.
 */
public class ClosestPair {
    public static void getPair(int[] A, int[] B, int value) {
        int l = 0;
        int r = B.length - 1;
        int left=0, right=B.length-1, diff = Integer.MAX_VALUE;
        while (l < A.length && r >= 0) {
            if (Math.abs(A[l] + B[r] - value) < diff) {
                left = l;
                right  =r;
                diff = Math.abs(A[l] + B[r] - value);
            }
            if((A[l] + B[r]) > value){
                r--;
            }
            else {
                l++;
            }
        }
        System.out.println("l:"+A[left]+" r:"+B[right]+" diff:"+diff);
    }

    public static void main(String[] args) {
        int A[] ={100, 400, 500, 700};
        int B[] = {10, 20, 30, 40};
        getPair(A,B,372);
    }
}
