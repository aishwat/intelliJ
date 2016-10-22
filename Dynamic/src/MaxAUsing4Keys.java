/**
 * Created by tecso on 17/10/16.
 */
//print maximum number of A’s using given four keys
//    A,Ctrl_A,Ctrl_C,Ctrl_V
//    A, S, C, P
    
//http://stackoverflow.com/questions/4606984/maximum-number-of-characters-using-keystrokes-a-ctrla-ctrlc-and-ctrlv
public class MaxAUsing4Keys {
    public static int getAsUsing4Keys(int n) {
        if (n < 7)
            return n;
        int e3, e4;
//        e3 : SCPP | 3 times | 4 keystroke
//        e4 : SCPPP| 4 times | 5 keystroke
        e3 = 4 - (n % 5);
        e4 = n / 5 - e3;
//        System.out.println("e3:" + e3 + " e4:" + e4);
        double res = 4 * Math.pow(4, e4) * Math.pow(3, e3);
        System.out.println(res);
        return (int) res;
    }

    public static void main(String[] args) {
        getAsUsing4Keys(12);
        getAsUsing4Keys(24);
        getAsUsing4Keys(25);
        getAsUsing4Keys(26);
    }
}
