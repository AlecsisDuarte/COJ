/**
 * Problem: 3073 - Way Too Long Words
 *
 * Description:
 *  Sometimes some words like "localization" or "internationalization" are so long
 *  that writing them many times in one text is quite tiresome.
 *  
 *  Let's consider a word too long, if its length is strictly more than 10
 *  characters. All too long words should be replaced with a special abbreviation.
 *  
 *  This abbreviation is made like this: we write down the first and the last letter
 *  of a word and between them we write the number of letters between the first and
 *  the last letters. That number is in decimal system and doesn't contain any
 *  leading zeroes.
 *  
 *  Thus, "localization" will be spelt as "l10n", and "internationalization» will be
 *  spelt as "i18n".
 *  
 *  You are suggested to automatize the process of changing the words with
 *  abbreviations. At that all too long words should be replaced by the abbreviation
 *  and the words that are not too long should not undergo any changes.
 *
 * Input specification:
 *  The first line contains an integer n (1 ≤ n ≤ 100). Each of the following n
 *  lines contains one word. All the words consist of lowercase Latin letters and
 *  possess the lengths of from 1 to 100 characters.
 *
 * Output specification:
 *  Print n lines. The i-th line should contain the result of replacing of the
 *  i-th word from the input data.
 *
 * Sample input:
 *  4
 *  word
 *  localization
 *  internationalization
 *  pneumonoultramicroscopicsilicovolcanoconiosis
 *
 * Sample output:
 *  word
 *  l10n
 *  i18n
 *  p43s
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3073
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3073_WayTooLongWords {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(in.readLine());
    while (n-- > 0) {
      String l = in.readLine();
      if (l.length() > 10) {
        out.write(String.format("%c%d%c\n", l.charAt(0), l.length() - 2,
                                l.charAt(l.length() - 1)));

      } else {
        out.write(l);
        out.newLine();
      }
    }

    in.close();
    out.close();
  }
}