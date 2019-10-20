
/**
 * Problem: 1441 - Egypt
 * 
 * Description:
 *  A long time ago, the Egyptians figured out that a triangle with sides of length 3, 4, and 5 had 
 *  a right angle as its largest angle. You must determine if other triangles have a similar 
 *  property.
 * 
 * Input specification:
 *  Input represents several test cases, followed by a line containing 0 0 0. Each test case has 
 *  three positive integers, less than 30000, denoting the lengths of the sides of a triangle.
 * 
 * Output specification: 
 *  For each test case, a line containing "right" if the triangle is a right triangle, and a line 
 *  containing "wrong" if the triangle is not a right triangle.
 * 
 * Sample input:
 *  6 8 10
 *  25 52 60
 *  5 12 13
 *  0 0 0
 * 
 * Sample output:
 *  right
 *  wrong
 *  right
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1441
 */
import java.util.Scanner;

public class _1441_Egypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("0 0 0")) {
            String[] parts = line.split(" ");
            boolean isRight = isRightTriangle(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]),
                    Double.parseDouble(parts[2]));
            System.out.println(isRight ? "right" : "wrong");
            line = in.nextLine();
        }
        in.close();
    }

    private static boolean isRightTriangle(double side, double sideTwo, double sideThree) {
        double[] s = sortSides(side, sideTwo, sideThree);
        double cSquare = s[0] * s[0];
        double aSquare = s[1] * s[1];
        double bSquare = s[2] * s[2];
        return Double.compare(cSquare, (aSquare + bSquare)) == 0;

    }

    private static double[] sortSides(double side, double sideTwo, double sideThree) {
        double[] sort = new double[3];
        if (side > sideTwo) {
            if (side > sideThree) {
                sort[0] = side;
                sort[2] = sideThree;
            } else {
                sort[0] = sideThree;
                sort[2] = side;

            }
            sort[1] = sideTwo;
        } else {
            if (sideTwo > sideThree) {
                sort[0] = sideTwo;
                sort[2] = sideThree;
            } else {
                sort[0] = sideThree;
                sort[2] = sideTwo;
            }
            sort[1] = side;
        }
        return sort;
    }
}