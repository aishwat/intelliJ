import java.util.Arrays;

/**
 * Created by tecso on 16/9/16.
 */
//or text justification
//https://www.youtube.com/watch?v=RORuwHiblPc
public class WordWrap {
    public static int INF = 999;

    public static int[][] getMatrix(int[] words, int line_length) {
        int T[][] = new int[words.length][words.length];
        //T is cost of storing words i to j words in 1 line

        for (int i = 0; i < words.length; i++) {
            int words_total_len = 0;
            for (int j = i; j < words.length; j++) {
                words_total_len = words_total_len + words[j];
                if (j > i)
                    words_total_len++;

                if (words_total_len <= line_length)
                    T[i][j] = (int) Math.pow((line_length - words_total_len), 2);
                else
                    T[i][j] = INF;
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (T[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(T[i][j] + "\t");
            }
            System.out.println();
        }
        return T;
    }

    public static int getCost(int[][] T, int words[], String[] words_) {
        int temp;
        int tmp[] = new int[words.length];
        Arrays.fill(tmp, INF);
        int P[] = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {
            temp = 0;
            for (int j = words.length - 1; j >= i; j--) {
//                System.out.print("T[" + i + "][" + j + "]: " + T[i][j]);
//                System.out.println("\ttmp[" + i + "]: " + tmp[i]);
                if (T[i][words.length - 1] != INF) {
                    tmp[i] = T[i][words.length - 1];
//                    System.out.println("setting tmp to " + tmp[i]);

                    if (i == words.length - 1)
                        P[i] = words.length; //1st case
                    else
                        P[i] = P[i + 1]; //on same line , same parent

                    break;
                } else {
                    //look for partitions
                    if (i != j && j >= 1 && T[i][j - 1] != INF) {
                        temp = T[i][j - 1] + tmp[j];
//                        System.out.println("temp:" + temp);
                        if (tmp[i] > temp) {
                            tmp[i] = temp;
//                            System.out.println("setting tmp to " + tmp[i]);
                            P[i] = j;
                        }
                    }
                }
            }
        }
        System.out.print("\ntmp: ");
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.print("\nP: ");
        for (int i = 0; i < P.length; i++) {
            System.out.print(P[i] + " ");
        }
        System.out.println("\nlines: ");
        int i = 0;
        while (i < words.length) {
            for (int j = i; j <P[i]; j++) {
                System.out.print(words_[j]+" ");
            }
            i = P[i];
            System.out.println();
        }

        return P[0];
    }

    public static void main(String[] args) {
        String words_[] = {"tushar", "roy", "likes", "to", "code"};

        int words[] = new int[words_.length];
        for (int i = 0; i < words_.length; i++) {
            words[i] = words_[i].toCharArray().length;
        }

        int[][] T = getMatrix(words, 10);
        int cost = getCost(T, words, words_);
        System.out.println("\ncost: " + cost);
    }
}
