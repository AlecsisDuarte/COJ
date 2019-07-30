/**
 * Problem: 1176 - Ternary
 *
 * Description:
 *  You will be given a decimal number. You will have to convert it to its ternary
 *  (Base 3) equivalent.
 *
 * Input specification:
 *  The input file contains at most 100 lines of inputs. Each line contains a
 *  non-negative decimal integer N (N <= 10^9). Input is terminated by a line
 *  containing a negative value. This line should not be processed.
 *
 * Output specification:
 *  For each line of input produce one line of output. This line contains the
 *  ternary equivalent of decimal value N.
 *
 * Sample input:
 *  10
 *  100
 *  1000
 *  -1
 *
 * Sample output:
 *  101
 *  10201
 *  1101001
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1176
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _1176_Ternary {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = in.nextInt();
    while (n > -1) {
      if (n == 0) {
        out.write("0\n");
      } else {
        out.write(String.valueOf(ternary(n)));
        out.newLine();
      }
      n = in.nextInt();
    }

    out.close();
    in.close();
  }

  static long ternary(long dec) {
    long ter = dec % 3;

    long mul = 10;
    long res = (dec / 3);

    while (res > 0) {
      ter += (res % 3) * mul;
      res /= 3;
      mul *= 10;
    }

    return ter;
  }
}