/**
 * Problem: 3232 - Penalty Calculation
 *
 * Description:
 *  In the forthcoming UCI Cup, COJ Development Team fears the possibility of the
 *  main structure of the site to go down. Therefore they have assigned many young
 *  programmers (you among them) to code backup modules, so if anything goes wrong
 *  during the contest, the competitors don’t get upset. The task assigned to you is
 *  to calculate the penalty for a specific problem from a team.
 *  
 *  You will be given 1 <= N <= 100, the number of submissions, and for each one you
 *  will also know the minute 1 <= Mi <= 300 it was submitted and the judge verdict
 *  by its identifier which can be one of these:
 *  
 *    Verdict                  Identifier
 *   - Wrong Answer         –     WA  
 *   - Time Limit Exceeded  –     TLE
 *   - Runtime Error        –     RTE
 *   - Compilation Error    –     CE
 *   - Accepted             –     AC
 *  
 *  If a problem is Accepted the penalty raises to the amount of minutes it took to
 *  accept and for each submission before the first Accepted one, the penalty raises
 *  by 20 points. If the problem is not Accepted, the penalty is zero.
 *
 * Input specification:
 *  In the first line of the input a single integer N (1 <= N <= 100) representing
 *  the number of submissions. The next N lines describe a single submission: with a
 *  integer Mi (1 <= Mi <= 300) representing the minute of the submission and a
 *  string V representing the verdict, both values are space separated. The value of
 *  V is one of these: WA, TLE, RTE, CE or AC. You can safely assume that all Mi are
 *  unique.
 *
 * Output specification:
 *  The total penalty the team will have after all submissions are processed.
 *
 * Sample input:
 *  4
 *  40 RTE
 *  20 WA
 *  30 WA
 *  41 AC
 *
 * Sample output:
 *  101
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3232
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3232_PenaltyCalculation {

  // MIN IMPOSSIBLE TIME
  static final int MAX_TIME = 301;

  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int acceptedTime = MAX_TIME;
    int[] submissions = new int[MAX_TIME];

    int n = Integer.parseInt(in.readLine());

    while (n-- > 0) {
      String[] values = in.readLine().split(" ", 2);
      int time = Integer.parseInt(values[0]);
      if (values[1].equals("AC")) {
        acceptedTime = Math.min(acceptedTime, time);
      } else {
        ++submissions[time];
      }
    }

    if (acceptedTime == MAX_TIME) {
      out.write("0\n");
    } else {
      int count = 0;
      for (int i = acceptedTime - 1; i > 0; i--) {
        count += submissions[i];
      }
      out.write(String.valueOf((count * 20) + acceptedTime));
      out.newLine();
    }

    out.close();
    in.close();
  }
}