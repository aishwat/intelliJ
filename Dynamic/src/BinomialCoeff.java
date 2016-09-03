/**
 * Created by tecso on 2/9/16.
 */
public class BinomialCoeff {
    public static int getCoeff(int n, int k) {
        //nCk = n-1Ck-1 + n-1Ck
        int tmp[][] = new int[k+1][n+1];

        for (int i = 0; i < k+1; i++)
            tmp[i][i] = 1; //diagonal

        for (int i = 0; i < n+1; i++)
            tmp[0][i] = 1; //first row

        for (int i = 1; i < k+1; i++) {
            for (int j = i+1; j < n+1; j++) {
                tmp[i][j] = tmp[i-1][j-1]+ tmp[i][j-1];
            }
        }

        for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return tmp[k][n];
    }

    public static void main(String[] args) {
        int coeff = getCoeff(5, 2);
        System.out.println(coeff);
    }
}
