/**
 * Problem: 3442 - Diamond Cutout
 *
 * Description:
 *  An odd-length word w can be printed out over |w| lines to form a square of
 *  letters. Consider how that would appear when using the string "abcde":
 *      abcde
 *      abcde
 *      abcde
 *      abcde
 *      abcde
 *  
 *  A diamond shape can be cut out from the center of the square to create an
 *  interesting design:
 *      abcde
 *      ab de
 *      a   e
 *      ab de
 *      abcde
 *  
 *  This is the diamond cutout pattern. Can you create a program that prints out
 *  words following that pattern?
 *
 * Input specification:
 *  The input will consist of a single word w (2 <= |w| <= 20). It will only
 *  contain lowercase letters from the English alphabet.
 *
 * Output specification:
 *  The output will consist of one line. If w has an odd length, the output must
 *  be a design following the diamond cutout pattern described above. Otherwise,
 *  output "error" to indicate that no design can be generated.

 *
 * Sample input:
 *  working
 *
 * Sample output:
 *  working
 *  wor ing
 *  wo   ng
 *  w     g
 *  wo   ng
 *  wor ing
 *  working
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3442
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3442_DiamondCutout {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String w = in.readLine();
    if (w.length() % 2 == 0) {
      out.write("error\n");
    } else {
      char[][] diamond = getDiamond(w);
      for (int i = 0; i < w.length(); i++) {

        out.write(String.valueOf(diamond[i]));
        out.newLine();
      }
    }

    in.close();
    out.close();
  }

  static char[][] getDiamond(String w) {
    int len = w.length();
    char[][] diamond = new char[len][len];
    diamond[0] = diamond[len - 1] = w.toCharArray();

    int spaces = len - 2, mid = len / 2;
    int index = mid;

    while (spaces >= 0) {
      int left = mid, right = mid;
      for (; right < len; right++) {

        if (right - left < spaces) {
          diamond[index][left] = diamond[index][right] = ' ';
        } else {
          diamond[index][left] = w.charAt(left);
          diamond[index][right] = w.charAt(right);
        }
        --left;
      }

      if (index != mid) {
        diamond[mid + (mid - index)] = diamond[index];
      }

      spaces -= 2;
      --index;
    }

    return diamond;
  }
}

/**
 * ###
 * # #
 * ###
 */