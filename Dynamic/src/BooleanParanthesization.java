/**
 * Created by tecso on 23/9/16.
 */
public class BooleanParanthesization {
    public static int getParentesizationCount(char[] symbols, char[] operators) {
        int n = symbols.length;
        int T[][] = new int[n][n];
        int F[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            T[i][i] = symbols[i] == 'T' ? 1 : 0;
            F[i][i] = symbols[i] == 'F' ? 1 : 0;
        }
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                T[i][j] = 0;
                F[i][j] = 0;

                for (int k = i; k < j; k++) {
                    int t_ik = T[i][k] + F[i][k];
                    int t_kj = T[k + 1][j] + F[k + 1][j];

                    if (operators[k] == '|') {
                        T[i][j] += t_ik * t_kj - F[i][k] * F[k + 1][j];
                        F[i][j] += F[i][k] * F[k + 1][j];
                    }
                    if (operators[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += t_ik * t_kj - T[i][k] * T[k + 1][j];
                    }
                    if (operators[k] == '^') {
                        T[i][j] += T[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(T[i][j]+" ");
            }
            System.out.println();
        }
        return T[0][n-1];
    }

    public static void main(String[] args) {
        String symbols = "TTFT";
        String operators = "|&^";
        int cnt = getParentesizationCount(symbols.toCharArray(),operators.toCharArray());
        System.out.println(cnt);
    }
}
