import java.util.Arrays;

/**
 * Created by tecso on 16/9/16.
 */
public class BoxStacking {
    public static int getMaxHeight(Dimension[] input) {
        Dimension[] allRotationInput = createAllRotations(input);
        Arrays.sort(allRotationInput);
        for (int i = 0; i < allRotationInput.length; i++) {
            System.out.println(allRotationInput[i].toString());
        }
        //at this point we have all rotations sorted based on area
        //we just need to check which stacking gives max height
        //LIS on height
        int T[] = new int[allRotationInput.length];
        int P[] = new int[allRotationInput.length];
        for (int i = 0; i < allRotationInput.length; i++) {
            T[i] = allRotationInput[i].height;
            P[i] = 0;
        }

        //i on top
        for (int i = 1; i < allRotationInput.length; i++) {
            for (int j = 0; j < i; j++) {
                if (allRotationInput[i].length < allRotationInput[j].length &&
                        allRotationInput[i].width < allRotationInput[j].width && T[i] < T[j] + allRotationInput[i].height) {
                    T[i] = T[j] + allRotationInput[i].height;
                    P[i] = j;
                }
            }
        }

        int max = -1, max_index = -1;
        for (int i = 0; i < T.length; i++) {
            if (max < T[i]) {
                max = T[i];
                max_index = i;
            }
        }
        print_array(T);
        print_array(P);
        while (max_index !=0){
            System.out.println(allRotationInput[max_index].toString());
            max_index = P[max_index];
        }
        System.out.println(allRotationInput[0].toString());
        return max;

    }

    public static Dimension[] createAllRotations(Dimension[] input) {
        Dimension[] allRotationInput = new Dimension[input.length * 3];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            //once pass height as height, then len as height, then width as height
            //dont care about other 2 edges
            allRotationInput[index++] = Dimension.createDimension(
                    input[i].height, input[i].length, input[i].width);
            allRotationInput[index++] = Dimension.createDimension(
                    input[i].length, input[i].height, input[i].width);
            allRotationInput[index++] = Dimension.createDimension(
                    input[i].width, input[i].length, input[i].height);

        }
        return allRotationInput;
    }

    public static void main(String[] args) {
        Dimension input[] = {new Dimension(3, 2, 5), new Dimension(1, 2, 4)};
        int maxHeight = getMaxHeight(input);

    }

    public static void print_array(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Dimension implements Comparable<Dimension> {
    int length, width, height;

    public Dimension(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    Dimension() {

    }

    static Dimension createDimension(int height, int side1, int side2) {
        Dimension d = new Dimension();
        d.height = height;
        if (side1 >= side2) {
            d.length = side1;
            d.width = side2;
        } else {
            d.length = side2;
            d.width = side1;
        }
        return d;
    }


    @Override
    public int compareTo(Dimension d) {
        if (this.length * this.width < d.length * d.width) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Dimension [height=" + height + ", length=" + length
                + ", width=" + width + "]";
    }
}