/**
 * Problem: 2711 - Shinigami Sword
 *
 * Description:
 *  The 11th Division of the Soul Society is specialized in fighting with swords,
 *  neglecting other disciplines of the Shinigamis. Their Captain Kenpachi Zaraki
 *  believe that the strength of a Shinigami must be measured only taking into
 *  account the phisic habilities using swords without using Shikai or Bankai
 *  liberations of their Zanpakutos. In other words for Kenpachi, the most powerfull
 *  Shinigami is the one that have the most powerfull Zanpakuto. The more powerfull
 *  the Shinigami, the higher their rank in the 11th Division.
 *  
 *  The power of each Shinigami Zanpakuto in the 11th Division will be given, and
 *  you must find the rank of the Shinigamis in the 11th Division.
 *
 * Input specification:
 *  The first line contain a integer number 1 <= N <= 1000, the amount of
 *  Shinigamis in the 11th Division. Shinigamis are conveniently numbered between 1
 *  and N. The following N lines contains a integer number 1 <= P <= N representing
 *  the power of the i-th (for 1 <= i <= N) Shinigami Zanpakuto. You can safely
 *  assume that all powers will be different.
 *
 * Output specification:
 *  You must print N lines representing the Shinigamis in the 11th Division,
 *  ordered decreasing by their powers. This is the number of the most powerfull
 *  Shinigami in the first line, the second line contain the number of the second
 *  more powerfull, and so on. The number of the less powerfull must be in the last
 *  line of the ouptput.
 *
 * Sample input:
 *  5
 *  3
 *  1
 *  5
 *  2
 *  4
 *
 * Sample output:
 *  3
 *  5
 *  1
 *  4
 *  2
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2711
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2711_ShinigamiSword {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(in.readLine());
    int[] shinigamis = new int[n + 1];
    StringBuilder sb = new StringBuilder(n * 2);

    for (int i = 1; i <= n; i++) {
      shinigamis[Integer.parseInt(in.readLine())] = i;
    }

    for (int i = n; i > 0; i--) {
      sb.append(shinigamis[i]);
      sb.append('\n');
    }
    out.write(sb.toString());

    out.close();
    in.close();
  }
}