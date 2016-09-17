/**
 * Created by tecso on 14/9/16.
 */
//or subset sum
//https://www.youtube.com/watch?v=s6FhG--P7z0
public class Partition {
    // whether a given set can be partitioned into two subsets
    // such that the sum of elements in both subsets is same
    public static boolean isPartitionPossible(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        if (sum % 2 != 0)
            return false;
        else
            return isSumPossible(a, sum / 2);
    }

    public static boolean isSumPossible(int[] a, int sum) {
        Boolean T[][] = new Boolean[a.length][sum + 1]; //0 to sum
        for (int i = 0; i < a.length; i++) {
            T[i][0] = true; //first column true
        }
        for (int j = 1; j <= sum; j++) {
            //first row handled separate, so that can use i-1 easily
            if (a[0] == j)
                T[0][j] = true;
            else
                T[0][j] = false;
        }
        print_arr(a, sum, T);
        print_elements(a, sum, T);
        return T[a.length - 1][sum];
    }

    public static void print_arr(int[] a, int sum, Boolean[][] T) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (a[i] > j)
                    T[i][j] = T[i - 1][j]; //copy from up
                else if (T[i - 1][j] == true)
                    T[i][j] = true; //up true , nowhere to look
                else //this vl also handle a[i] == j case as 1st col is true
                    T[i][j] = T[i - 1][j - a[i]]; //go back a[i]
            }
        }
        for (int i = 0; i <= sum; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (T[i][j])
                    System.out.print("T\t");
                else
                    System.out.print("F\t");
            }
            System.out.println();
        }
    }

    public static void print_elements(int[] a, int sum, Boolean[][] T) {
        int i = a.length - 1;
        int j = sum;
        System.out.print("Elements: ");
        while (i != 0) {
            if(T[i-1][j]==true) //means coming from top
                i=i-1;
            else{
                System.out.print(a[i]+" ");
                j=j-a[i]; //just move back in same row
                //next iteration vl see up true and vl run ok
            }
        }
    }


    public static void main(String[] args) {
        int a[] = {2, 3, 7, 8, 10};
        System.out.println("\nisSumPossible: "+isSumPossible(a, 11));
        //or call is partition possible
    }
}
