/**
 * Problem: 2120 - Different Digits
 *
 * Description:
 *  The inhabitants of Nlogonia are very superstitious. One of their beliefs is
 *  that street house numbers that have a repeated digit bring bad luck for the
 *  residents. Therefore, they would never live in a house which has a street number
 *  like 838 or 1004.
 *  
 *  The Queen of Nlogonia ordered a new seaside avenue to be built, and wants to
 *  assign to the new houses only numbers without repeated digits, to avoid
 *  discomfort among her subjects. You have been appointed by Her Majesty to write a
 *  program that, given two integers N and M , determines the maximum number of
 *  houses that can be assigned street numbers between N and M , inclusive, that do
 *  not have repeated digits.
 *
 * Input specification:
 *  Each test case is described using one line. The line contains two integers N
 *  and M  as described above (1 <= N <= M <= 5000).
 *
 * Output specification:
 *  For each test case output a line with an integer representing the number of
 *  street house numbers between N and M, inclusive, with no repeated digits.
 *
 * Sample input:
 *  87 104
 *  989 1022
 *  22 25
 *  1234 1234
 *
 * Sample output:
 *  14
 *  0
 *  3
 *  1
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2120
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class _2120_DifferentDigits {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      short n = in.nextShort();
      short m = in.nextShort();

      out.write(String.format("%d\n", totalStreeNumbersV2(n, m)));
    }

    out.close();
    in.close();
  }

  private static int totalStreeNumbers(short n, short m) {
    int total = 0;
    HashSet<Integer> nums = new HashSet<>();
    for (short i = n; i <= m; i++) {
      short tmp = i;
      
      boolean hasRepeatedDigit = false;
      while (tmp > 0) {
        if (!nums.add(tmp % 10)) {
          hasRepeatedDigit = true;
          break;
        }
        tmp /= 10;
      }
      if (!hasRepeatedDigit) {
        ++total;
      }
      nums.clear();
    }

    return total;
  }

  /**
   * Twenty percent speed improvement with the usage of an array over a Hashing table
   */
  private static int totalStreeNumbersV2(short n, short m) {
    int total = 0;
    for (short i = n; i <= m; i++) {
      int[] repeated = new int[10];
      short tmp = i;

      boolean hasRepeatedDigit = false;
      while (tmp > 0) {
        if (repeated[tmp % 10]++ > 0) {
          hasRepeatedDigit = true;
          break;
        }
        tmp /= 10;
      }
      if (!hasRepeatedDigit) {
        ++total;
      }
    }

    return total;
  }
}