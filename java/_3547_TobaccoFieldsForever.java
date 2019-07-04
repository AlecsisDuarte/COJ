/**
 * Problem: 3547 - Tobacco Fields Forever
 *
 * Description:
 *  In Pinar Del Río there is a Tabbaco plantation field with rectangular shape,
 *  it measures R x C meters (1 <= R <= 1000) and (1 <= C <= 1000) such that it can
 *  be divided into cells of 1 square meter. Each cell has a seed planted on it, and
 *  each seed has an integer value V (|V| <= 10) associated to it, which means the
 *  height at which the plant of tabacco can grow out of it. In this field is common
 *  to find that some seeds are not smart enough to know that the plant that comes
 *  out of it has to grow up towards the sun, and sadly they grow underground,
 *  that's the reason why some seeds has negative values (yes, it can happen, don't
 *  forget those seeds are from Pinar Del Río).
 *  
 *  Don Alejandro the owner of the plantation wants to examine some parts of the
 *  field, there for he will be asking you Q (1 <= Q <= 10^5) queries. In each query
 *  he will ask for the sum of the heights of all plants that grow towards the sun
 *  in a sub-rectangle of the field. The upper left cell of the field is [1, 1].
 *
 * Input specification:
 *  The first line contains three space separated integers R (1 <= R <= 1000), C
 *  (1 <= C <= 1000), and Q (1 <= Q <= 10^5). The next R lines describe the field,
 *  each line contains C space separated integers V1, V2, ..Vc (|Vi| <= 10)
 *  representing the value associated to a seed.
 *  
 *  The next Q lines contain the description of a single query, consisting of four
 *  integers x1, y1, x2, y2 where [x1, y1] is the sub-rectangle's upper left corner
 *  and [x2, y2] is the sub-rectangle's lower right corner. It is guaranteed that
 *  each pair represent a valid cell inside the field.
 *
 * Output specification:
 *  For each query print a line containing a single integer the sum of the heights
 *  of all plants that grow towards the sun in the queried sub-rectangle.
 *
 * Sample input:
 *  3 3 3
 *  3 1 -3
 *  2 5 7
 *  -1 2 -5
 *  1 1 3 3
 *  1 2 2 3
 *  3 2 3 3
 *
 * Sample output:
 *  20
 *  13
 *  2
 *
 * URL:http://coj.uci.cu/24h/problem.xhtml?pid=3547
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3547_TobaccoFieldsForever {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] values = in.readLine().split(" ");
    int r = Integer.parseInt(values[0]) + 1;
    int c = Integer.parseInt(values[1]) + 1;
    int q = Integer.parseInt(values[2]);

    int[][] grid = new int[r][c];

    for (int y = 1; y < r; y++) {
      values = in.readLine().split(" ");
      for (int x = 1; x < c; x++) {
        grid[y][x] = Math.max(Integer.parseInt(values[x - 1]), 0);
        grid[y][x] += grid[y][x - 1] + grid[y - 1][x] - grid[y - 1][x - 1];
      }
    }

    while (q-- > 0) {
      values = in.readLine().split(" ");
      int x1 = Integer.parseInt(values[0]);
      int y1 = Integer.parseInt(values[1]);
      int x2 = Integer.parseInt(values[2]);
      int y2 = Integer.parseInt(values[3]);

      out.write(String.valueOf(getSum(grid, x1, x2, y1, y2)));
      out.newLine();
    }

    out.close();
    in.close();
  }

  private static int getSum(int[][] grid, int x1, int x2, int y1, int y2) {
    return grid[x2][y2] - grid[x1 - 1][y2] - grid[x2][y1 - 1] +
        grid[x1 - 1][y1 - 1];
  }
}