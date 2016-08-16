package com.company;

/**
 * Created by tecso on 6/6/16.
 */
public class CycleStart1 {
    public static void sort(int[] A) {
        int item, temp, pos;
        for (int cycleStart = 0; cycleStart < A.length; cycleStart++) {
            pos = cycleStart;
            item = A[cycleStart];

            for (int i = cycleStart + 1; i < A.length; i++) {
                if (A[i] < item)
                    pos++;
            }
            if (pos == cycleStart)
                continue;
            while (A[pos] == item) {
                pos++;
            }
            if (A[pos] != item) {
                temp = A[pos];
                A[pos] = item;
                item = temp;
            }
            while (cycleStart != pos) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < A.length; i++) {
                    if (A[i] < item)
                        pos++;
                }
                if (pos == cycleStart)
                    continue;
                while (A[pos] == item) {
                    pos++;
                }
                if (A[pos] != item) {
                    temp = A[pos];
                    A[pos] = item;
                    item = temp;
                }
            }
        }
    }
}
