
/**
 * Problem: 1355 - The Cross I
 * 
 * Description:
 *  In the image below you can see a square ABCD, where AB = BC = CD = DA = a. Four arcs are drawn 
 *  taking the four vertexes A, B, C, D as centers and a/3 as the radius. The arc that is drawn 
 *  taking A as center, starts at neighboring vertex E and ends at neighboring vertex L where 
 *  AE = EF = FB = AB/3. All other arcs are drawn in a similar fashion. Regions of a cross shape 
 *  are created in this fashion. You will have to determine the area of this region. The value used 
 *  on this problem of the constant PI was 3.141592653589793.
 * 
 * Input specification:
 *  The input file contains a floating-point number a (0 <= a <= 1000) in each line which indicates 
 *  the length of one side of the square. Input is terminated by end of file.
 * 
 * Output specification: 
 *  For each line of input, output in a single line the area of the cross. This number will be 
 *  floating point number with four digits after the decimal point.
 * 
 * Sample input:
 *  1.0 
 *  6.0
 * 
 * Sample output:
 *  0.3176
 *  11.4336
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1355
 */
import java.util.Scanner;

public class _1355_TheCrossI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double pi = 3.141592653589793D;

        //We continue until EOF
        while (in.hasNext()) {
            String line = in.nextLine();
            double a = Double.parseDouble(line);
            if (a == 0) {
                System.out.println("0");
            } else {
             System.out.printf("%.4f\n", calculateArea(a, pi));
            }

            // line = in.nextLine();
        }
        in.close();
    }

    public static double calculateArea(double a, double pi) {
        //Full area of the square
        double squareArea = a * a;
        
        //Empty space between the triangles
        double rectangleArea = squareArea / 3D;

        double circleRadius = a / 3D;
        double circleArea = pi * circleRadius * circleRadius;
        
        return squareArea - rectangleArea - circleArea;
    }
}