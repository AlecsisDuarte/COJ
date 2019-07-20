/**
 * Problem: 2369 - Add and Multiply
 *
 * Description:
 *  Given three integers A, B, C, you are allowed to perform exactly two
 *  operations on these numbers: an addition and a multiplication. For instance, if
 *  A = 10, B = 3, C = 2, we can get (10 + 2) * 3 = 36.
 *  
 *  What are the minimum and maximum values you can get by applying these two
 *  operations?
 *
 * Input specification:
 *  The first line of input contains 1 <= T <= 200, the number of test cases to
 *  consider. Each of the next T lines contains three integers A, B, and C (where
 *  -1,000,000 <= A, B, C <= 1,000,000).
 *
 * Output specification:
 *  For each test case, output a line with the minimum and maximum values
 *  described in the statement.
 *
 * Sample input:
 *  2
 *  10 3 2
 *  -3 2 -5
 *
 * Sample output:
 *  16 50
 *  -16 17
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2369
 */
import java.util.Scanner;

public class _2369_AddAndMultiply {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    short t = in.nextShort();
    while (t-- > 0) {
      long a = in.nextLong(), b = in.nextLong(), c = in.nextLong();
      printMaxAndMin(a, b, c);
    }

    in.close();
  }

  //Created all combinations
  static void printMaxAndMin(long a, long b, long c) {
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;

    long res = a + (b * c);
    max = Math.max(max, res);
    min = Math.min(min, res);

    res = (a + b) * c;
    max = Math.max(max, res);
    min = Math.min(min, res);

    res = (a + c) * b;
    max = Math.max(max, res);
    min = Math.min(min, res);

    res = b + (c * a);
    max = Math.max(max, res);
    min = Math.min(min, res);

    res = (b + c) * a;
    max = Math.max(max, res);
    min = Math.min(min, res);

    res = b + (c * a);
    max = Math.max(max, res);
    min = Math.min(min, res);

    res = c + (a * b);
    max = Math.max(max, res);
    min = Math.min(min, res);

    System.out.printf("%d %d\n", min, max);
  }
}