/**
 * Problem: 1288 - Div 6
 *
 * Description:
 *  Can you determine when a number given is divisible by six ?
 *
 * Input specification:
 *  The first line of the input have an integer 1 <= T <= 25 specifying the
 *  number of test cases. The next T lines you will have a number N with at most
 *  1000 digits.
 *
 * Output specification:
 *  For each test case, if N is divisible by 6, print one line with the word "YES"
 *  else, print the word "NO".
 *
 * Sample input:
 *  2
 *  6
 *  4
 *
 * Sample output:
 *  YES
 *  NO
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1288
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class _1288_Div6 {
  private static final BigInteger SIX = new BigInteger("6");

  private static final String YES = "YES\n";
  private static final String NO = "NO\n";

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    byte t = in.nextByte();

    while (t-- > 0) {
      BigInteger n = in.nextBigInteger();
      out.write(isDivisibleBySix(n) ? YES : NO);
    }

    in.close();
    out.close();
  }

  static boolean isDivisibleBySix(BigInteger n) {
    return n.remainder(SIX).equals(BigInteger.ZERO);
  }
}