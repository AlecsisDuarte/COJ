/**
 * Problem: 2786 - Coder
 *
 * Description:
 *  A Coder is a new piece of chess game. A Coder can move (and attack) one square
 *  horizontally or vertically. If one Coder is located at position (x,y), he can
 *  move to (or attack) positions (x+1,y), (x–1,y), (x,y+1) and (x,y–1). Given N,
 *  the size of a chessboard, you need to calculate the maximum number of Coders
 *  that you can place on it, so that no Coder attacks any other.
 *
 * Input specification:
 *  The first line contains an integer N (1 ≤ N ≤ 1000).
 *
 * Output specification:
 *  In the first line you must print the maximum number of Coders that can be
 *  placed on the chessboard.
 *
 * Sample input:
 *  2
 *
 * Sample output:
 *  2
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2786
 */
import java.util.Scanner;

public class _2786_Coder {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    n *= n;

    if (n % 2 == 0) {
      System.out.println(n / 2);
    } else {
      // If n is odd we have to round up the value
      System.out.println((int)Math.ceil(n / 2f));
    }

    in.close();
  }
}