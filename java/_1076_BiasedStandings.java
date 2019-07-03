/**
 * Problem: 1076 - Biased Standings
 *
 * Description:
 *  Usually, results of competitions are based on the scores of participants.
 *  However, we are planning a change for the next year of IPSC. During the
 *  registration each team will be able to enter a single positive integer:
 *  their preferred place in the ranklist. We would take all these preferences
 *  into account, and at the end of the competition we will simply announce a
 *  ranklist that would please all of you. But wait... How would that ranklist
 *  look like if it won't be possible to satisfy all the requests? Suppose that
 *  we already have a ranklist. For each team, compute the distance between their
 *  preferred place and their place in the ranklist. The sum of these distances
 *  will be called the badness of this ranklist. Given team names and their
 *  preferred placements find one ranklist with the minimal possible badness.
 *
 * Input specification:
 *  The first line of the input file contains an integer T (no more than 20)
 *  specifying the number of test cases. Each test case is preceded by a blank
 *  line. Each test case looks as follows: The first line contains N: the number
 *  of teams participating in the competition ( 1<=N <= 10^4). Each of the next
 *  N lines contains a team name (a string of letters and numbers. The number of
 *  characters will not exceed 20) and its preferred place (an integer between 1
 *  and N, inclusive). No two team names will be equal.
 *
 * Output specification:
 *  For each of the test cases output a single line with a single integer: the
 *  badness of the best ranklist for the given teams.
 *
 * Sample input:
 *  2
 *
 *  7
 *  noobz 1
 *  llamas 2
 *  Winn3rz 2
 *  5thwheel 1
 *  NotoricCoders 5
 *  StrangeCase 7
 *  WhoKnows 7
 *
 *  3
 *  ThreeHeadedMonkey 1
 *  MoscowSUx13 1
 *  NeedForSuccess 1
 *
 * Sample output:
 *  5
 *  3
 *
 * URL:http://coj.uci.cu/24h/problem.xhtml?pid=1076
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1076_BiasedStandings {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    byte t = Byte.parseByte(in.readLine());
    while (t-- > 0) {
      in.readLine(); // Remove each test emtpy line
      int n = Integer.parseInt(in.readLine());
      int[] badness = new int[n + 1];

      while (n-- > 0) {
        int rank = Integer.parseInt(in.readLine().split(" ")[1]);
        // We store the occurences of the specified rank
        ++badness[rank];
      }

      int rank = 1;
      int totalBadness = 0;
      for (int i = 1; i < badness.length; i++) {
        while (badness[i]-- > 0) {
          // the total badness will be the difference between the current rank
          // and the specified rank
          totalBadness += Math.abs(rank++ - i);
        }
      }

      out.write(String.valueOf(totalBadness));
      out.newLine();
    }

    out.close();
    in.close();
  }
}