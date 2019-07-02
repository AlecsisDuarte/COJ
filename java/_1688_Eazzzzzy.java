
/**
 * Problem: 1688 - Eazzzzzy
 *
 * Description:
 *  You should draw triangles, parallelograms and rectangles, using asterisks.
 *       *                      ****               ****
 *      ***                    ****                ****
 *     *****                  ****                 ****
 *    *******                ****                  ****
 *   *********              ****                   ****
 *
 *  Triangle (5)      Parallelogram (4x5)     Rectangle (4x5)
 *  In the previous figure in brackets is specified dimension. For the triangle,
 * given the height. For the parallelogram, rectangle, will the width and
 * height.
 *
 * Input specification:
 *  The first line of each entry represents the category C.
 *  If C = 1, is a triangle. Then the next line specifies the height H, such
 * that 1 <= H <= 10. If C = 2, is a parallelogram. Then the next line of input
 * will contain the width W and height H, separated by a space, so that 1 <= W
 * <= 10 and 1 <= H <= 10. If C = 3, is a rectangle. Then the next line of input
 * will contain the width W and height H, separated by a space, so that 1 <= W
 * <= 10 and 1 <= H <= 10. C = -1 indicates the end of the entry.
 *
 * Output specification:
 *  The output will be drawn using the asterisk '*' as shown in the example.
 *  You should print a blank line between each output.
 *
 * Sample input:
 *  1
 *  5
 *  2
 *  5 3
 *  3
 *  4 6
 *  -1
 *
 * Sample output:
 *      *
 *     ***
 *    *****
 *   *******
 *  *********
 *
 *    *****
 *   *****
 *  *****
 *
 *  ****
 *  ****
 *  ****
 *  ****
 *  ****
 *  ****
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1688
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1688_Eazzzzzy {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(in.readLine());

    while (c != -1) {
      switch (c) {
      case 1: // Triangle
        triangle(Byte.parseByte(in.readLine()), out);
        break;
      case 2: // Parallelogram
        String[] values = in.readLine().split(" ");
        parallelogram(Byte.parseByte(values[0]), Byte.parseByte(values[1]),
                      out);
        break;
      case 3: // Rectangle
        values = in.readLine().split(" ");
        rectangle(Byte.parseByte(values[0]), Byte.parseByte(values[1]), out);
        break;
      }
      c = Integer.parseInt(in.readLine());
      if (c != -1) {
        out.write("\n");
      }
    }

    out.close();
    in.close();
  }

  private static void triangle(byte h, BufferedWriter out) throws IOException {
    StringBuilder sb = new StringBuilder();
    int w = (h - 1) * 2 + 1;
    int middle = w / 2;

    // Fill with spaces
    for (int i = 0; i < middle; i++) {
      sb.append(' ');
    }

    sb.append('*');

    while (h-- > 0) {
      out.write(sb.toString());
      out.write('\n');
      sb.append("**");
      sb.deleteCharAt(0);
    }
  }

  private static void rectangle(byte w, byte h, BufferedWriter out)
      throws IOException {
    StringBuilder sb = new StringBuilder(w);

    while (--w >= 0) {
      sb.append('*');
    }
    sb.append('\n');
    String l = sb.toString();

    while (h-- > 0) {
      out.write(l);
    }
  }

  private static void parallelogram(byte w, byte h, BufferedWriter out)
      throws IOException {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < h - 1; i++) {
      sb.append(' ');
    }
    while (w-- > 0) {
      sb.append('*');
    }

    sb.append('\n');

    while (h-- > 0) {
      out.write(sb.toString());
      sb.deleteCharAt(0);
    }
  }
}