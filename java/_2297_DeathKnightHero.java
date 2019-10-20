/**
 * Problem: 2297 - Death Knight Hero
 *
 * Description:
 *  There once was a champion of WoW Arthasdk the name he was bestowed.
 *  
 *  He "Death Gripped" you to his side.
 *  His "Chains of Ice" stopped your stride.
 *  And "Obliterates" made you say "OWW!"
 *  
 *  But one day our hero got puzzled. His Death Grip totally fizzled.
 *  In his darkest despair. He could barely hear "OMG NOOB u Chains of Iced than u
 *  Death Gripped".
 *
 * Input specification:
 *  You are given a recording of the abilities our hero used in his battles. The
 *  first line of input will contain a single integer n (1<=n<=100), the number of
 *  battles our hero played. Then follow n lines each with a sequence of ki
 *  (1<=ki<=1000) characters, each of which are either 'C', 'D' or 'O'. These denote
 *  the sequence of abilities used by our hero in the i-th battle. 'C' is Chains of
 *  Ice, 'D' is Death Grip and 'O' is Obliterate.
 *
 * Output specification:
 *  Output the number of battles our hero won, assuming he won each battle where
 *  he did not Chains of Ice immediately followed by Death Grip.
 *
 * Sample input:
 *  3
 *  DCOOO
 *  DODOCD
 *  COD
 *
 * Sample output:
 *  2
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2297
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2297_DeathKnightHero {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    byte n = Byte.parseByte(in.readLine());
    byte wins = 0;
    while (n-- > 0) {
      String battle = in.readLine();
      if (!battle.contains("CD")) {
        ++wins;
      }
    }

    System.out.println(wins);
    in.close();
  }
}