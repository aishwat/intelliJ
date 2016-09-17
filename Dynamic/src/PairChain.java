import java.util.Arrays;

/**
 * Created by tecso on 16/9/16.
 */
//or Building Bridges //https://people.cs.clemson.edu/~bcdean/dp_practice/dp_6.swf

//http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
//in geeks for geeks they sort via first element of pair, seems wrong

//http://stackoverflow.com/questions/17530303/longest-chain-of-pairs
//http://stackoverflow.com/questions/18018911/maximum-length-of-pairs-in-increasing-order
public class PairChain {
    //simple first sort by second element in each pair
    //then do lis based on pair[i].a>pair[j].b

    public static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int a, int b) {
            this.b = b;
            this.a = a;
        }
        @Override
        public int compareTo(Pair o) {
            return this.b - o.b; //increasing
        }
    }

    public static void getMaxChainLength(Pair[] pairs) {
        Arrays.sort(pairs);
        print_array(pairs);

        int[] tmp = new int[pairs.length];
        Arrays.fill(tmp, 1);
        int[] P = new int[pairs.length];

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i].a > pairs[j].b && tmp[i] < tmp[j] + 1) {
                    tmp[i] = tmp[j] + 1;
                    P[i] = j;
                }
            }
        }
        int max = -1;
        int max_index = -1;
        for (int i = 0; i < pairs.length; i++) {
            if (max < tmp[i]) {
                max = tmp[i];
                max_index = i;
            }
            System.out.print(tmp[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < pairs.length; i++) {
            System.out.print(P[i] + " ");
        }

        System.out.println("\nmax length: "+max);
        while(max_index != 0){
            System.out.print("(" + pairs[max_index].a + "," + pairs[max_index].b + ") ");
            max_index = P[max_index];
        }
        System.out.print("(" + pairs[0].a + "," + pairs[0].b + ") "); //0th always there

    }

    public static void main(String[] args) {
        Pair pairs[] = new Pair[5];
        pairs[0] = new Pair(5, 24);
        pairs[1] = new Pair(39, 60);
        pairs[2] = new Pair(15, 28);
        pairs[3] = new Pair(27, 40);
        pairs[4] = new Pair(50, 90);
        getMaxChainLength(pairs);
    }

    public static void print_array(Pair[] pairs) {
        System.out.println();
        for (int i = 0; i < pairs.length; i++) {
            System.out.print("(" + pairs[i].a + "," + pairs[i].b + ") ");
        }
        System.out.println();
    }
}
