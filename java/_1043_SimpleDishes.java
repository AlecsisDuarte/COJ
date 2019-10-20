/**
 * Problem: 1043 - Simple Dishes
 *
 * Description:
 *  It has a weight of simple dishes, and weights of 1kg, 2kg, 4kg, 8kg, 16Kg,
 *  ..., up to 2^14kg. And he wants to weigh objects whose total weight is less than
 *  2^15 kg. You are required to develop a software that, given the weight of the
 *  object find which dishes you need to use to do their weighing. The weights are
 *  properly numbered with a value 0 <= Pi <= 14, in the same order they are given,
 *  where each has a weight equal to 2^Pi.
 *
 * Input specification:
 *  An integer 1 <= T <= 100 that corresponds to the number of objects. Then in
 *  the following T lines, a positive integer greater than zero with the weight of
 *  the object in each case.
 *
 * Output specification:
 *  For each object should be printed on one line, separated by a space, the
 *  number of each of the weights to be used for the weighing, in ascending order.
 *
 * Sample input:
 *  3
 *  5
 *  73
 *  255
 *
 * Sample output:
 *  0 2
 *  0 3 6
 *  0 1 2 3 4 5 6 7
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1043
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _1043_SimpleDishes {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    byte t = in.nextByte();
    while (t-- > 0) {

      int weight = in.nextInt();

      String bin = Integer.toBinaryString(weight);
      int len = bin.length();

      //We set max sb length (if all chars in bin are 1) + empty space
      StringBuilder sb = new StringBuilder(len * 2);

      for (int i = len - 1; i >= 0; i--) {
        if (bin.charAt(i) == '1') {
          sb.append(len - i - 1);
          sb.append(' ');
        }
      }
      
      //We remove last appended space
      sb.deleteCharAt(sb.length() - 1);

      out.write(sb.toString());
      out.newLine();
    }

    out.close();
    in.close();
  }
}