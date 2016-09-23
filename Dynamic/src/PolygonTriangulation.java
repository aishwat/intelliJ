import java.util.Arrays;

/**
 * Created by tecso on 23/9/16.
 */
//http://www.cs.utoronto.ca/~heap/Courses/270F02/A4/chains/node2.html
//    no video lecture
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PolygonTriangulation {

    public static Double getDistance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static Double getCost(Point p1, Point p2, Point p3) {
        Double d1 = getDistance(p1, p2);
        Double d2 = getDistance(p2, p3);
        Double d3 = getDistance(p3, p1);
        return d1 + d2 + d3;
    }

    public static int[][] getMinPolygonTriangulation(Point[] points) {
        int n = points.length;
        Double T[][] = new Double[n][n];
        int res[][] = new int[n][n];


        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (j < i + 2) {
                    T[i][j] = 0.0;
                } else {
                    T[i][j] = Double.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
//                        T[i][k] is cost of polygon i till k, polygon not triangle, may be 0
//                        T[k][j] is cost of polygon k till j
//                        getCost vl get actual cost of triangle ikj
                        Double val = T[i][k] + T[k][j] + getCost(points[i], points[k], points[j]);
//                        System.out.println("i:" + i + " k:" + k + " j:" + j+" cost:"+getCost(points[i], points[k], points[j]));
                        if (val < T[i][j]) {
                            T[i][j] = val;
                            res[i][j] = k;
//                            save k for retracing

                        }
                    }
                }
            }
        }
        System.out.printf("cost: %.1f\t", T[0][n-1]);

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.1f\t\t", T[i][j]);
            }
            System.out.println();
        }
        return res;
    }

    public static void print_solution(Point[] points, int[][] res, int i, int j) {
        if(j-i < 2)
            return;
//        System.out.println("i: "+i+" res[i][j]: "+res[i][j]);
        print_solution(points,res,i,res[i][j]);
        System.out.println("(" + i + "," + res[i][j] + "," + j + ") ");
//        System.out.println("res[i][j]: "+res[i][j]+" j:"+j);
        print_solution(points,res,res[i][j],j);
    }

    public static void main(String[] args) {
        Point points[] = {new Point(0, 0), new Point(1, 0), new Point(2, 1), new Point(1, 2), new Point(0, 2)};
        int[][] res = getMinPolygonTriangulation(points);

//        for (int i = 0; i < res.length; i++) {
//            for (int j = 0; j < res.length; j++) {
//                System.out.print(res[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println();
        print_solution(points,res,0,points.length-1);
    }

}
