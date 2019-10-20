/**
 * Problem: 1197 - Mega Searcher
 *
 * Description:
 *  The Intranet, the vast network that feeds us, contains much information. So,
 *  it is not possible to find a particular file quickly. To resolve this
 *  problem arose network scanners, those wonderful tools that let you painlessly
 *  find any series, movie, game or photo you want "as we work, of course:)".
 *  Then, in view of this problem, Enrique decided to make a scanner, to
 *  demonstrate that it is not so difficult. The first version was a success, but
 *  soon received complaints from users who wanted to always know how long it
 *  takes to finish the search. In trying to resolve this problem, however, found
 *  a complication in the application module in charge of finding the computer
 *  on, because it was necessary to know the number of available IP addresses in
 *  the range to search. Enrique can not resolve this difficult problem, but is
 *  too proud to admit it. Can you help ?
 *
 * Input specification:
 *  An IPv4 address as used in Cuba is in the form X.X.X.X, where X is a number
 *  between 0 and 255. Some of these are used for routing IP network to various
 *  methods of communication between servers and active elements and change
 *  depending on the configuration of the network. Some are reserved and have
 *  special meanings depending on the class to which they belong. For purposes
 *  of this problem, we assume that all IPs are valid and the Mega Searcher can
 *  be used with any kind of IP address. The entry consists of a range of IPs,
 *  that is, two valid IP addresses A and B (A > B), one in each input line.
 *
 * Output specification:
 *  The output is a single number, the number of IPs theoretically valid in the
 *  interval [B, A].
 *
 * Sample input:
 *  10.35.12.40
 *  10.35.12.38
 *
 * Sample output:
 *  3
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1197
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1197_MegaSearcher {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] ipsA = in.readLine().split("\\.", 4);
    String[] ipsB = in.readLine().split("\\.", 4);

    System.out.println(getTotalIPs(ipsA, ipsB));

    in.close();
  }

  static long getTotalIPs(String[] ipsA, String[] ipsB) {
    long a = Integer.parseInt(ipsA[0]), b = Integer.parseInt(ipsB[0]);

    for (int i = 1; i < 4; i++) {
      a = (a * 256) + Long.parseLong(ipsA[i]);
      b = (b * 256) + Long.parseLong(ipsB[i]);
    }

    return a - b + 1;
  }
}