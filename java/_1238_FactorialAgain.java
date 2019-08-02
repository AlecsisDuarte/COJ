/**
 * Problem: 1238 - Factorial Again!
 *
 * Description:
 *  Mathew, an engineering freshman, is developing an original positional
 *  notation for representing integer numbers. He called it "A Curious Method"
 *  (ACM for short). The ACM notation uses the same digits as the decimal
 *  notation, i.e., 0 through 9. To convert a number A from ACM to decimal
 *  notation you must add k terms, where k is the number of digits of A (in the
 *  ACM notation). The value of the i-th term, corresponding the i-th digit ai,
 *  counting from right to left, is ai * i!. For instance 719ACM is equivalent to
 *  53 in decimal notation, since 7 * 3! + 1 * 2! + 9 * 1! = 53. Mathew has just
 *  begun studying number theory, and probably does not know which properties a
 *  numbering system should have, but at the moment he is only interested in
 *  converting a number from ACM to decimal. Could you help him?
 *
 * Input specification:
 *  Each test case is given in a single line that contains a non-empty string of
 *  at most 5 digits, representing a number in ACM notation. The string does not
 *  have leading zeros. The last test case is followed by a line containing one
 *  zero.
 *
 * Output specification:
 *  For each test case output a single line containing the decimal representation
 *  of the corresponding ACM number.
 *
 * Sample input:
 *  719
 *  1
 *  15
 *  110
 *  102
 *  0
 *
 * Sample output:
 *  53
 *  1
 *  7
 *  8
 *  8
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1238
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1238_FactorialAgain {
  private final static int[] FACTORIAL = new int[] {1, 2, 6, 24, 120};

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int acm = Integer.parseInt(in.readLine());
    while (acm > 0) {
      out.write(String.valueOf(getDecimal(acm)));
      out.newLine();
      acm = Integer.parseInt(in.readLine());
    }

    out.close();
    in.close();
  }

  static int getDecimal(int acm) {
    int index = 0, dec = 0;

    while (acm > 0) {
      int d = acm % 10;
      acm /= 10;

      dec += d * FACTORIAL[index++];
    }
    return dec;
  }
}