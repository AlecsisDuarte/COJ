/**
 * Problem: 1933 - Og
 *
 * Description:
 *  Og is a caveman with many children, and he wants to count them all. Og counts
 *  his sons with his left hand and his daughters with his right hand. However, Og
 *  is very dumb, and can’t add the two counts, so he asked you to write him a
 *  program that will do the addition.
 *
 * Input specification:
 *  The input contains several test cases. Each test case consists of a single
 *  line containing two integers L and R, separated by a single space, indicating
 *  respectively the number of sons and daughters (1 <= L,R <= 5). The end of
 *  input is indicated by a line containing only two zeros, separated by a single
 *  space.
 *
 * Output specification:
 *  The input contains several test cases. Each test case consists of a single
 *  line containing two integers L and R, separated by a single space, indicating
 *  respectively the number of sons and daughters (1 <= L,R <= 5). The end of
 *  input is indicated by a line containing only two zeros, separated by a single
 *  space.
 *
 * Sample input:
 *  2 2
 *  2 3
 *  5 5
 *  1 1
 *  0 0
 *
 * Sample output:
 *  4
 *  5
 *  10
 *  2
 *
 * URL:http://coj.uci.cu/24h/problem.xhtml?pid=1933
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1933_Og {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String line = in.readLine();
    while (!line.equals("0 0")) {
      String res = sumChildren(line);
      out.write(res);

      line = in.readLine();
    }

    in.close();
    out.close();
  }

  private static String sumChildren(String line) {
    return (line.charAt(0) - '0' + line.charAt(2) - '0') + "\n";
  }
}