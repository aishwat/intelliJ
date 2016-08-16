package com.company;

/**
 * Created by tecso on 11/6/16.
 */
public class KClosestElements {
    public static int getCrossoverIndex(int[] A, int key) {
        int l = 0, r = A.length - 1, m;
        while (r - l > 1) {
            m = (r + l) >>> 1;
            System.out.println("l: " + l + " m: " + m + " r:" + r);
            if (A[m] == key)
                return m;
            else if (A[m] < key)
                l = m;
            else
                r = m;
        }
        return l; //floor
    }


    public static void main(String[] args) {
        int[] A = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int k = 4, x = 35;
        int crossover = getCrossoverIndex(A, x);
        System.out.println("crossover:" + crossover);
        int count = 0, l = crossover, r = l+1;
        if(A[crossover] == x)
            l--;
        while (count < k && l > 0 && r < A.length - 1) {
            if(A[crossover]-A[l]<A[r]-A[crossover]){
                System.out.println(A[l]);
                l--;
            }
            else {
                System.out.println(A[r]);
                r++;
            }
            count++;
        }
        while (count<k && l>0){
            System.out.println(A[l]);
            l--;
            count++;
        }
        while (count<k && r<A.length-1){
            System.out.println(A[r]);
            r++;
            count++;
        }


    }

}
