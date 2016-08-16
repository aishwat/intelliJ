package com.company;

/**
 * Created by tecso on 01/04/16.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//1,2,3,4,5
public class BinarySearch {
    int binarySearchRec(int arr[], int l, int r, int x) {
        System.out.print("l:" + l + " r:" + r + " ");
        if (r >= l) {
            int mid = l + r >>> 1;
            System.out.println("mid: " + mid);
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearchRec(arr, l, mid - 1, x);
            return binarySearchRec(arr, mid + 1, r, x);
        }
        System.out.println("out");
        return -1;
    }

    int binarySearchItr(int arr[], int l, int r, int x) {

        while (l <= r) {
            int mid = l + r >>> 1;
            System.out.print("l:" + l + " r:" + r + " ");
            System.out.println("mid: " + mid);
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        int pos = bs.binarySearchItr(arr, 0, arr.length - 1, 10);
        System.out.println(pos);
    }

}
