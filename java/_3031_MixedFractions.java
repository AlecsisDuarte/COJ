/**
 * Problem: 3031 - Mixed Fractions
 *
 * Description:
 *  You are part of a team developing software to help students learn basic
 *  mathematics. You are to write one part of that software, which is to display
 *  possibly improper fractions as mixed fractions. A proper fraction is one where
 *  the numerator is less than the denominator; a mixed fraction is a whole number
 *  followed by a proper fraction. For example the improper fraction 27/12 is
 *  equivalent to the mixed fraction 2 3/12. You should not reduce the fraction
 *  (i.e. don’t change 3/12 to 1/4).
 *
 * Input specification:
 *  Input has one test case per line. Each test case contains two integers in the
 *  range [1; 2^31 – 1]. The first number is the numerator and the second is the
 *  denominator. A line containing 0 0 will follow the last test case.
 *
 * Output specification:
 *  For each test case, display the resulting mixed fraction as a whole number
 *  followed by a proper fraction, using whitespace to separate the output tokens.
 *
 * Sample input:
 *  27 12
 *  2460000 98400
 *  3 4000
 *  0 0
 *
 * Sample output:
 *  2 3 / 12
 *  25 0 / 98400
 *  0 3 / 4000
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3031
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _3031_MixedFractions {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = in.nextInt();
    int b = in.nextInt();
    while (b != 0) {
      int quotient = a / b;
      int remainder = a - (quotient * b);

      out.write(String.format("%d %d / %d\n", quotient, remainder, b));

      a = in.nextInt();
      b = in.nextInt();
    }

    in.close();
    out.close();
  }
}