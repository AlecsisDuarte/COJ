/**
 * Problem: 1273 - Domino Factory
 *
 * Description:
 *  Peter is a remarkable games factory director who has made some contributions
 *  to many traditional games and now he's interested in domino. Domino is a
 *  traditional game consisting in a set of pieces representing all possible pairs
 *  we can build with numbers from 0 to N. So for example taking N = 6, with leave
 *  us to game with 28 pieces. Although the most known games are the ones with N =
 *  6 and N = 9, he's interested in games with many others different N. Peter will
 *  build the pieces with some particular wood and will put over their main faces a
 *  very expensive material, so given the desired measures (width and length) in
 *  cm, he needs your help in determining how much material in cm^2 he will have to
 *  buy.
 *
 * Input specification:
 *  A single line with an integer T with the number of test cases. T lines
 *  follows, each one with three integers N, L (length of the pieces in cm), W
 *  (width of the pieces in cm).
 *
 * Output specification:
 *  A single line per test case with the required amount of material in cm^2. The
 *  answer will always fit in a signed 32 bits integer.
 *
 * Sample input:
 *  1
 *  6 3 2
 *
 * Sample output:
 *  168
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1273
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _1273_DominoFactory {
  private static final int N = 0;
  private static final int AREA = 1;

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = in.nextInt();
    int max = 0;
    int[][] pieces = new int[t][2];

    for (int i = 0; i < t; i++) {
      pieces[i][N] = in.nextInt();
      if (max < pieces[i][N]) {
        max = pieces[i][N];
      }
      pieces[i][AREA] = in.nextInt() * in.nextInt();
    }

    int[] totalPieces = getTotalPieces(max);

    for (int i = 0; i < t; i++) {
      out.write(String.valueOf(totalPieces[pieces[i][N]] * pieces[i][AREA]));
      out.newLine();
    }

    out.close();
    in.close();
  }

  static int[] getTotalPieces(int max) {
    int[] totalPieces = new int[max + 1];
    totalPieces[0] = 1;
    for (int i = 1; i < totalPieces.length; i++) {
      totalPieces[i] += totalPieces[i - 1] + i + 1;
    }

    return totalPieces;
  }
}