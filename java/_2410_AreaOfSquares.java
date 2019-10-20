/**
 * Problem:
 *
 * Description:
 *  Given a shape formed by 1 <= N <= 10 squares as follows. The first is a
 *  square of side A, the second is a square whose vertices are the middle points
 *  of the first square sides, the third is a square whose vertices are the
 *  middle points of the second square sides and so on until the N-th square.
 *  Your task is to find the area of the N-th square given the length A of the
 *  first square sides.
 *
 * Input specification:
 *  The first line contain the number of cases to process (1 <= T <= 50000). Each
 *  case consists of a line containing a integer number A (0 < A <= 5000) which
 *  represents the length of the first square sides, and a integer number N, the
 *  number of squares.
 *
 * Output specification:
 *  For every case a line should be printed with a following format "Case #C: D"
 *  (without quotes) where C is the number of the case starting by 1, and D is the
 *  value of the area rounded up to two decimal places.
 *
 * Sample input:
 *  2
 *  2 1
 *  1 2
 *
 * Sample output:
 *  Case #1: 4.00
 *  Case #2: 0.50
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2410
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2410_AreaOfSquares {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = in.nextInt();
    final double sqrtOfTwo = Math.sqrt(2);

    for (int i = 1; i <= t; i++) {
      int a = in.nextInt();
      int n = in.nextInt();

      double c = a;

      while (n-- > 1) {
        c = (c / 2F) * sqrtOfTwo;
      }

      out.write(String.format("Case #%d: %.2f\n", i, c * c));
    }
    in.close();
    out.close();
  }
}