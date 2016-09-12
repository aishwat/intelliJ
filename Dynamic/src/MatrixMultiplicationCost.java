/**
 * Created by tecso on 1/9/16.
 */
public class MatrixMultiplicationCost {
    public int findCost(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            System.out.println("\nl:"+l);
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                System.out.println("  i:"+i+" j:"+j);
                System.out.print("    k:");
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++){
                    System.out.print(k);
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    System.out.print("["+q+"] ");
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
                System.out.println();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr.length; j++) {
                System.out.print(temp[i][j]+"   ");
            }
            System.out.println();
        }

        return temp[0][arr.length-1];
    }

    public static void main(String args[]){
        MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
//        int arr[] = {4,2,3,5,3};
        int arr[] = {2,3,6,4,5};
        int cost = mmc.findCost(arr);
        System.out.println(cost);
    }
}
