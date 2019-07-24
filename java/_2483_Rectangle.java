/**
 * Problem: 2483 - Rectangle
 *
 * Description:
 *  Mirko needs to choose four points in the plane so that they form a rectangle
 *  with sides parallel to the axes. He has already chosen three points and is
 *  confident that he hasn't made a mistake, but is having trouble locating the
 *  last point. Help him.
 *
 * Input specification:
 *  Each of the three points already chosen will be given on a separate line. All
 *  coordinates will be integers between 1 and 1000.
 *
 * Output specification:
 *  Output the coordinates of the fourth vertex of the rectangle.
 *
 * Sample input:
 *  5 5
 *  5 7
 *  7 5
 *
 * Sample output:
 *  7 7
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2483
 */
import java.util.Scanner;

public class _2483_Rectangle {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    short[][] points = new short[3][2];

    for (int i = 0; i < points.length; i++) {
      points[i][0] = in.nextShort();
      points[i][1] = in.nextShort();
    }

    short x = 0, y = 0;
    if (points[0][0] == points[1][0]) {
      x = points[2][0];
    } else if (points[0][0] == points[2][0]) {
      x = points[1][0];
    } else {
      x = points[2][0];
    }

    if (points[0][1] == points[1][1]) {
      y = points[2][1];
    } else if (points[0][1] == points[2][1]) {
      y = points[1][1];
    } else {
      y = points[0][1];
    }

    System.out.printf("%d %d\n", x, y);

    in.close();
  }
}