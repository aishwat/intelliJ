import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by tecso on 15/8/16.
 */


//https://github.com/dharam3/DS/blob/master/src/com/dk/greedy/HuffmanCoding.java
public class Huffman {
    static public class CharFreq implements Comparable<CharFreq> {
        char ch;
        int freq;
        int huffMan = -1;

        CharFreq left, right;

        //leaves
        CharFreq(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        //internal nodes
        CharFreq(int freq, CharFreq left, CharFreq right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        boolean isLeafNode() {
            return left == null && right == null;
        }


        @Override
        public int compareTo(CharFreq o) {
            return this.freq - o.freq;
        }

        public String toString() {
            return "CharFreq[ch=" + ch + ",freq=" + freq + ",huffMan=" + huffMan + "]";
        }
    }

    public static void createHuffmanEncoding(CharFreq[] charFreqs) {
        Queue<CharFreq> pQueue = new PriorityQueue<CharFreq>();
        List<CharFreq> chF = Arrays.asList(charFreqs);
        pQueue.addAll(chF);
        while (pQueue.size() > 1) {
            CharFreq left = pQueue.remove();
            CharFreq right = pQueue.remove();
            CharFreq internal = new CharFreq(left.freq + right.freq, left, right);
            pQueue.add(internal);
        }
        //now we have complete huffman tree
        calculateHuffmanEncoding(pQueue.remove(), 0); //pass root node
    }

    public static int calculateHuffmanEncoding(CharFreq charFreq, int code) {
        if (!charFreq.isLeafNode()) {
            //before going left, left shift code
            code = code << 1;
            code = calculateHuffmanEncoding(charFreq.left, code); //need to asign to code , not just rec call
            //before going right, left shift code and put 1
            code = (code << 1) | 1;
            code = calculateHuffmanEncoding(charFreq.right, code);
        } else {
            charFreq.huffMan = code;//when leaf, already got code from prev steps//just store it
        }
        return code >> 1;
    }

    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] fq = {5, 9, 12, 13, 16, 45};
        CharFreq[] charFreq = new CharFreq[ch.length];
        for (int i = 0; i < ch.length; i++) {
            charFreq[i] = new CharFreq(ch[i], fq[i]);
        }
        createHuffmanEncoding(charFreq);

        for (CharFreq chf : charFreq) {
            System.out.println(chf.ch + "    "
                    + Integer.toBinaryString(chf.huffMan));
        }

    }


}
