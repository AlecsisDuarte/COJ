/**
 * Problem: 1118 - The Drunk Jailer
 *
 * Description:
 *  A certain prison contains a long hall of n cells, each right next to each
 *  other. Each cell has a prisoner in it, and each cell is locked. One night, the
 *  jailer gets bored and decides to play a game. For round 1 of the game, he takes
 *  a drink of whiskey,and then runs down the hall unlocking each cell. For round
 *  2, he takes a drink of whiskey, and then runs down the hall locking every other
 *  cell (cells 2, 4, 6, ?). For round 3, he takes a drink of whiskey, and then
 *  runs down the hall. He visits every third cell (cells 3, 6, 9, ?). If the cell
 *  is locked, he unlocks it; if it is unlocked, he locks it. He repeats this for n
 *  rounds, takes a final drink, and passes out. Some number of prisoners, possibly
 *  zero, realizes that their cells are unlocked and the jailer is incapacitated.
 *  They immediately escape. Given the number of cells, determine how many
 *  prisoners escape jail.
 *
 * Input specification:
 *  The first line of input contains a single positive integer. This is the number
 *  of lines that follow. Each of the following lines contains a single integer
 *  between 5 and 100, inclusive, which is the number of cells n.
 *
 * Output specification:
 *  For each line, you must print out the number of prisoners that escape when the
 *  prison has n cells.
 *
 * Sample input:
 *  2
 *  5
 *  100
 *
 * Sample output:
 *  2
 *  10
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1118
 */
import java.util.Scanner;

public class _1118_TheDrunkJailer {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      System.out.println(scapedFormula(n));
    }

    in.close();
  }

  // Aplies brute force
  static int scapedBruteForce(int n) {
    boolean[] cells = new boolean[n];

    for (int round = 2; round <= n; round++) {
      for (int i = round - 1; i < cells.length; i += round) {
        cells[i] = !cells[i];
      }
    }

    int scaped = 0;
    for (int i = 0; i < cells.length; i++) {
      if (!cells[i]) {
        ++scaped;
      }
    }

    return scaped;
  }

  //    You get this formula if you lay the cells and scaped in a table:
  //
  //    Cells:  5 6 7 8 9 ... 15 16 ... 24
  //    scaped: 2 2 2 2 3 ... 3  4  ... 4
  //
  //    Each scaped increase every 5 += 2 (i.e. every 7, 9, 11, .. , etc)
  static int scapedFormula(int n) {
    int scaped = 2, from = 8, range = 5;

    while (n > from) {
      ++scaped;
      from += (range += 2);
    }

    return scaped;
  }
}