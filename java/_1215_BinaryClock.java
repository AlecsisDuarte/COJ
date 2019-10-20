/**
 * Problem: 1215 - Binary Clock
 *
 * Description:
 *  A binary clock is a clock which displays traditional sexagesimal time in a
 *  binary format. The most common binary clock uses six columns of LEDs to
 *  represent zeros and ones. Each column represents a single decimal digit, a
 *  format known as binary-coded decimal (BCD). The bottom row in each column
 *  represents 1 (or 2^0), with each row above representing higher powers of
 *  two, up to 2^3 (or 8). To read each individual digit in the time, the user
 *  adds the values that each illuminated LED represents, and then reads these
 *  from left to right. The first two columns represent the hour, the next two
 *  represent the minute, and the last two represent the second.
 *
 *  For Example: http://coj.uci.cu/images/problemas/problem1215.jpg/
 *
 *  Your task for this problem is simple: read an hour in its binary format and
 *  output its equivalent in sexagesimal time format. In order to facilitate
 *  your task, each one of the six columns of LEDs than represents a single
 *  decimal digit is concatenated as shown below. For example, 10:37:49 would be
 *  write as: ()(*)()()()()()(*)(*)()(*)(*)(*)(*)()()(*)()()(*)
 *
 *  Note: Spaces between characters do not exist.
 *
 * Input specification:
 *  The input consists of multiple test cases. The first line of input contains
 *  a single integer N, (1 <= N <= 1000) which is the number of test cases that
 *  follow. Each test case consists of a single line containing a string that
 *  represents an hour in its binary format. The length of the LEDs string is
 *  guaranteed to be <= 54.
 *
 * Output specification:
 *  For each test case, print the case number (beginning with 1) followed by the
 *  hour in its equivalent sexagesimal time format (HH:MM:SS). Follow the format
 *  shown in the sample output.
 *
 * Sample input:
 *  2
 *  ()(*)()()()()()(*)(*)()(*)(*)(*)(*)()()(*)()()(*)
 *  ()()()()()()()()()()()()()()()()()()()()
 *
 * Sample output:
 *  Case 1: 10:37:49
 *  Case 2: 00:00:00
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1215
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _1215_BinaryClock {
  static short[] DEC = new short[] {1, 2, 4, 8};

  static Pattern TIME_PATTERN = Pattern.compile(
      "^((?:\\(\\*?\\)){2})((?:\\(\\*?\\)){4})((?:\\(\\*?\\)){3})((?:\\(\\*?\\)){4})((?:\\(\\*?\\)){3})((?:\\(\\*?\\)){4})$");

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    short n = Short.parseShort(in.readLine());
    for (int i = 1; i <= n; i++) {
      String clock = in.readLine();
      out.write(clockToTime(clock, i));
    }

    in.close();
    out.close();
  }

  static String clockToTime(String clock, int index) {
    Matcher m = TIME_PATTERN.matcher(clock);
    StringBuilder time = new StringBuilder();

    // Append the "Case X: " string to the builder
    time.append("Case ").append(index).append(": ");

    if (m.matches()) {
      for (int i = 1; i <= m.groupCount(); i++) {
        time.append(getGroupDecValue(m.group(i)));
        if (i % 2 == 0) {
          time.append(':');
        }
      }
    }

    // Remove last ':' and append an linefeed
    return time.deleteCharAt(time.length() - 1).append('\n').toString();
  }

  static int getGroupDecValue(String group) {
    int dec = 0;
    int index = 0;
    for (int i = group.length() - 2; i > 0; i--) {
      if (group.charAt(i) == '*') {
        dec += DEC[index++];
        i -= 2;
      } else {
        i -= 1;
        index++;
      }
    }

    return dec;
  }
}