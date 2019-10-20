/**
 * Problem:
 *
 * Description:
 *  Paul is learning how to add numbers. To make the calculation easier, the sum
 *   only contains numbers 1, 2 and 3. He is only beginning to count, so he can
 *   calculate a sum only if the summands follow in non-decreasing order. For
 *   example, he can't add the sum 1+3+1 but he can calculate sums 1+1+2 and 3+3.
 *   Given the sum, your task is to rearrange the summands in such way that Paul can
 *   make the sum calculation.
 *  
 *
 * Input specification:
 *  The first line contains a non-empty string s, the sum Paul needs to count.
 *  String s contains no spaces. It only contains digits and characters "+".
 *  Besides, string s is a correct sum of numbers 1, 2 and 3. The length of the
 *  string s is less than or equal than 1000 characters.
 *
 * Output specification:
 *  Print the sum after rearranging the summands belonging to the input.
 *
 * Sample input:
 *  3+2+1
 *
 * Sample output:
 *  1+2+3
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2789
 */
import java.util.Arrays;
import java.util.Scanner;

public class _2789_SumOrder {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String line = in.nextLine();
    // System.out.println(reverse(line));
    System.out.println(reverseChar(line));
    in.close();
  }

  static String reverse(String line) {
    String[] sums = line.split("\\+");
    StringBuilder sb = new StringBuilder(line.length());

    Arrays.sort(sums);
    sb.append(sums[0]);
    for (int i = 1; i < sums.length; i++) {
      sb.append('+');
      sb.append(sums[i]);
    }
    return sb.toString();
  }

  static char[] reverseChar(String line) {
    char[] res = new char[line.length()];
    int[] numbers = new int[4];

    for (int i = 0; i < line.length(); i += 2) {
      ++numbers[line.charAt(i) - '0'];
    }

    int index = 0;

    for (int i = 1; i < numbers.length && index < res.length; i++) {
      while (numbers[i]-- > 0) {
        res[index++] = (char)(i + '0');
        if (index < res.length) {
          res[index++] = '+';
        }
      }
    }

    return res;
  }
}