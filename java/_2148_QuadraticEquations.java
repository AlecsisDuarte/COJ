/**
 * Problem: 2148 - Quadratic Equations
 *
 * Description:
 *  Quadratic equations are rather simple to solve. A student would have
 *  recommended the task to tell if a quadratic equation has a solution or not.
 *  We want to help us making a program that given values ​​0 < a <= 1000, 0
 *  <= b, c <= 1000, tell us whether the equation is solvable or not.
 *
 * Input specification:
 *  The input consists of a number 1 <= n <= 100 which is the number of cases to
 *  solve. The following n lines contains three integers, separated by a space,
 *  values for a, b, c.
 *
 * Output specification:
 *  You should print 'SI' if the equation has a solution or 'NO' if the equation
 *  has no solution.
 *
 * Sample input:
 *  2
 *  1 9 10
 *  1 3 10
 *
 * Sample output:
 *  SI
 *  NO
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2148
 * REF: https://www.geeksforgeeks.org/program-to-find-the-roots-of-quadratic-equation/
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2148_QuadraticEquations {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = in.nextInt();
    while (t-- > 0) {
      short a = in.nextShort(), b = in.nextShort();
      out.write(b * b >= 4 * a * in.nextShort() ? "SI\n" : "NO\n");
    }

    out.close();
    in.close();
  }
}