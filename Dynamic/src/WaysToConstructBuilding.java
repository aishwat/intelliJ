/**
 * Created by tecso on 15/10/16.
// */
//Let countB(i) be count of possible ways with i sections
//        ending with a building.
//
// countS(i) be count of possible ways with i sections
//        ending with a space.
//
//// A space can be added after a building or after a space.
//        countS(N) = countB(N-1) + countS(N-1)
//
//// A building can only be added after a space.
//        countB[N] = countS(N-1)
//
//// Result for one side is sum of the above two counts.
//        result1(N) = countS(N) + countB(N)
//
//// Result for two sides is square of result1(N)
//        result2(N) = result1(N) * result1(N)
    
public class WaysToConstructBuilding {
    public static int getWaysToConstructBuilding(int N){
        if(N==1)// Base case
            return 4;

        // countB is count of ways with a building at the end
        // countS is count of ways with a space at the end
        // Initialize countB and countS for one side
        int countB = 1,countS=1;
        int prevCountB,prevCountS;
        for (int i = 2; i <= N; i++) {
            prevCountB = countB;
            prevCountS = countS;

            countB = prevCountS;
            countS = prevCountS+prevCountB;

        }
        // Result for one side is sum of ways ending with building
        // and ending with space
        int result;
        result = countB+countS;
        // Result for 2 sides is square of result for one side
        return result*result;

    }

    public static void main(String[] args) {
        int res = getWaysToConstructBuilding(4);
        System.out.println(res);
    }
}
