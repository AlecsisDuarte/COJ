/**
 * Problem: 2400 - RIMSKI
 *
 * Description:
 *  Using roman numerals the numbers 1, 2, 3, 4, 5, 6, 7, 8, 9 are written as 'I',
 *  'II','III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX'. Numbers 10, 20, 30, 40, 50,
 *  60, 70, 80, 90 are written as 'X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX',
 *  'XC'.
 *  
 *  Any number smaller than 100 can be written by converting tens and ones
 *  separately and concatenating the results. So, for example, the number 48 would
 *  be written as XLVIII, XL for 40 and VIII for 8.
 *  
 *  Given a number written in roman numerals, rearrange it's characters so that you
 *  create the smallest possible number, written in roman numerals.
 *
 * Input specification:
 *  The first and only line of input contains one integer B ( 1 ≤ B < 100 ),
 *  written using roman numerals.
 *
 * Output specification:
 *  The first and only line of output should contain a rearrangement of input
 *  characters so that it represents the smallest possible number, written in roman
 *  numerals.
 *
 * Sample input:
 *  VI
 *
 * Sample output:
 *  IV
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2400
 */
import java.util.HashMap;
import java.util.Scanner;

public class _2400_RIMSKI {

  private static final HashMap<String, String> CONVERT =
      new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;
        {
          put("VI", "IV");
          put("VII", "VII");

          put("XI", "IX");
          put("XII", "XII");

          put("LX", "XL");
          put("LXX", "LXX");
          
          put("LXXI", "XLIX");
          put("LXXII", "LXXII");

          put("CX", "XC");
        }
      };

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String roman = in.nextLine();
    in.close();

    if (roman.length() == 1) {
      System.out.println(roman);
      return;
    }

    System.out.println(rearrange(roman));
  }

  static String rearrange(String roman) {
    StringBuilder sb = new StringBuilder();

    int len = roman.length();

    for (int from = 0; from < len; from++) {
      int remLen = len - from;

      if (5 <= remLen) {
        String sub = roman.substring(from, from + 5);
        if (CONVERT.containsKey(sub)) {
          sb.append(CONVERT.get(sub));
          from += 4;
          continue;
        }
      }

      if (4 <= remLen) {
        String sub = roman.substring(from, from + 4);
        if (CONVERT.containsKey(sub)) {
          sb.append(CONVERT.get(sub));
          from += 3;
          continue;
        }
      }

      if (3 <= remLen) {
        String sub = roman.substring(from, from + 3);
        if (CONVERT.containsKey(sub)) {
          sb.append(CONVERT.get(sub));
          from += 2;
          continue;
        }
      }

      if (2 <= remLen) {
        String sub = roman.substring(from, from + 2);
        if (CONVERT.containsKey(sub)) {
          sb.append(CONVERT.get(sub));
          from += 1;
          continue;
        }
      }

      sb.append(roman.charAt(from));
    }

    return sb.toString();
  }
}