/**
 * Created by tecso on 23/9/16.
 */
//get possible numbers of didgit N
//if only possible moves are up, down.left,right from given button
//http://ideone.com/tUtOP9 : followed here, from comment section
//http://ideone.com/Ttg97L : alternate approach
public class MobileNumKeypad {
    public static int getPossibleCombinations(int n) {
        int T[][] = new int[10][n + 1];
        //T[i][j] //for a choosen number i(0-9) combinations possible of digit j or length j

        for (int i = 0; i <= 9; i++) {
            T[i][1] = 1; //len 1
        }

        for (int l = 2; l <= n; l++) {
            T[0][l] = T[0][l - 1] + T[8][l - 1];
            T[1][l] = T[1][l - 1] + T[2][l - 1] + T[4][l - 1];
            T[2][l] = T[2][l - 1] + T[1][l - 1] + T[3][l - 1] + T[5][l - 1];
            T[3][l] = T[3][l - 1] + T[2][l - 1] + T[6][l - 1];
            T[4][l] = T[4][l - 1] + T[1][l - 1] + T[5][l - 1] + T[7][l - 1];
            T[5][l] = T[5][l - 1] + T[2][l - 1] + T[4][l - 1] + T[6][l - 1] + T[8][l - 1];
            T[6][l] = T[6][l - 1] + T[3][l - 1] + T[5][l - 1] + T[9][l - 1];
            T[7][l] = T[7][l - 1] + T[4][l - 1] + T[8][l - 1];
            T[8][l] = T[8][l - 1] + T[7][l - 1] + T[5][l - 1] + T[9][l - 1] + T[0][l - 1];
            T[9][l] = T[9][l - 1] + T[6][l - 1] + T[8][l - 1];
        }

        int total = 0;
        for (int i = 0; i <= 9; i++) {
            total += T[i][n];
        }
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
        return total;
    }

    public static void main(String[] args) {
        //possible combinations of len 3
        System.out.println(getPossibleCombinations(5)); //10,36,138,532,2062
    }
}
