
public class Manacher {

    public Manacher(String s) {

        char[] T = new char[s.length()*2 + 3];
        T[0] = '$';
        T[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            T[2*i + 1] = '#';
            T[2*i + 2] = s.charAt(i);
        }
        T[s.length()*2 + 1] = '#';


        int[]  P = new int[T.length];
        int center = 0, right = 0;

        for (int i = 1; i < T.length-1; i++) {
            int mirr = 2*center - i;

            if (i < right)
                P[i] = Math.min(right - i, P[mirr]); //may be P[mirr] bigger than right boundary

            while (T[i + (1 + P[i])] == T[i - (1 + P[i])]) //start looking before and after P[i] length
                P[i]++;

            if (i + P[i] > right) {
                center = i;
                right = i + P[i];
            }
        }

        int length = 0;   // length of longest palindromic substring
        center = 0;   // center of longest palindromic substring
        for (int i = 1; i < P.length-1; i++) {
            if (P[i] > length) {
                length = P[i];
                center = i;
            }
        }
        System.out.println("palindrome: "+s.substring((center - 1 - length) / 2, (center - 1 + length) / 2));

    }

    public static void main(String[] args) {
        String s = "abababa";
        Manacher manacher = new Manacher(s);
    }
}
        
