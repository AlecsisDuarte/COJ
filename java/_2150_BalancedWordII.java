/**
 * Problem: 2150 - Balanced Words II
 *
 * Description:
 *  "Never the second parts were good" but Octavito as a warrior that is, does not
 *  share that idea. He has learned to easily identify a type of balanced word
 *  therefore thought that it would have not trouble identifying others and in a
 *  girls conversation he heard about some kind of balanced word he thought he
 *  could not solve. In this case the word is considered balanced when the first
 *  n/2 letters of the word is balanced with the last n/2 letters, meaning
 *  balanced when they have the same amount of upper and lower case characters.
 *  Our friend Octavito want to impress these girls solving this problem, but he
 *  needs your help.
 *
 * Input specification:
 *  The first line contains a number 1 <= C <= 100 which determines the number of
 *  words which Octavito wants to know if are balanced or not, the following C
 *  lines contains the word to solve (the word length is not greater than 100).
 *
 * Output specification:
 *  You should print "SI" if the word is balanced, in other cases print "NO".
 *
 * Sample input:
 *  2
 *  aBcD
 *  aBBCDE
 *
 * Sample output:
 *  SI
 *  NO
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2150
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2150_BalancedWordII {

  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    byte c = Byte.parseByte(in.readLine());
    while (c-- > 0) {
      String word = in.readLine();
      out.write(isBalanced(word) ? "SI\n" : "NO\n");
    }

    out.close();
    in.close();
  }

  private static boolean isBalanced(String word) {
    int middle = word.length() / 2, upper = 0;

    int i = 0;
    for (; i < middle; i++) {
      if (word.charAt(i) < 97) {
        ++upper;
      }
    }
    if (word.length() % 2 != 0) {
        ++i;
    }
    for (; i < word.length(); i++) {
      if (word.charAt(i) < 97) {
        --upper;
      }
    }

    return upper == 0;
  }
}