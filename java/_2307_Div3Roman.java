/**
 * Problem: 2307 - Div 3 Roman
 *
 * Description:
 *  Roman numerals, the numeric system used in ancient Rome, employs combinations
 *  of letters from the Latin alphabet to signify values. In the system of Roman
 *  numerals, I is the symbol for 1, V for 5, X for 10, L for 50, C for 100, D for
 *  500 and M for 1000. Some examples of decimal numbers written in the system of
 *  roman numerals are:
 *
 *  Decimal System / Roman Numerals
 *  2 / II
 *  4 / IV
 *  8 / VIII
 *  9 / IX
 *  59 / LIX
 *
 *  You have to determine if a Z (1 <= Z <= 3000) number given in the system of
 *  Roman numerals is divisible by 3.
 *
 * Input specification:
 *  The first line of the input contains an integer N (1 <= N <= 1000) indicating
 *  the number of test cases. Each of the remaining N lines contains a number in
 *  the Roman numerical system. You can safely assume that numbers are correctly
 *  writen, acording to Roman numerical system rules.
 *
 * Output specification:
 *  For each test case output should contain a line with the word YES if the
 *  number is divisible by 3 or the word NO if not and then the corresponding
 *  integer in decimal system.
 *
 * Sample input:
 *  1
 *  IX
 *
 * Sample output:
 *  YES 9
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2307
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class _2307_Div3Roman {
  private final static HashMap<Character, Integer> LETTER =
      new HashMap<Character, Integer>() {
        private static final long serialVersionUID = 1L;

        {
          put('I', 1);
          put('V', 5);
          put('X', 10);
          put('L', 50);
          put('C', 100);
          put('D', 500);
          put('M', 1000);
        }
      };
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    short n = Short.parseShort(in.readLine());
    while (n-- > 0) {
      String roman = in.readLine();
      short dec = romanToDec(roman);
      out.write(String.format(dec % 3 == 0 ? "YES %d\n" : "NO %d\n", dec));
    }

    out.close();
    in.close();
  }

  private static short romanToDec(String roman) {
    short total = 0;
    for (int i = 0; i < roman.length(); i++) {
      int val = LETTER.get(roman.charAt(i));
      int next = 0;
      if (i + 1 < roman.length()) {
        next = LETTER.get(roman.charAt(i + 1));
      }
      if (val < next) {
        total += next - val;
        ++i;
      } else {
        total += val;
      }
    }

    return total;
  }
}