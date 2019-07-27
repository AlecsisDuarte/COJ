/**
 * Problem: 2979 - Another Sorting Problem
 *
 * Description:
 *  A permutation of the integers between 1 and N is given. Initially, they are
 *  positioned in an arbitrary order, but you want to rearrange the numbers, leaving
 *  them in increasing order. To do so, you use the following procedure: First, pick
 *  any number which is not in their corresponding position. Then, move this number
 *  into its corresponding position.  Another number may be occupying this location,
 *  so you must also move this number to its correct position. Repeat this step
 *  while possible. Finally, repeat from the first step while possible. Once these
 *  steps finish, the sequence will be ordered. You wish to know the amount of
 *  affected numbers during this sorting procedure. A number is considered affected
 *  if their initial position is distinct to their final position.
 *
 * Input specification:
 *  The first line contain a integer number T (1 <= T <= 100), the number of test
 *  cases. For each case: The first line contains an integer number N (1 <= N <=
 *  50), the number of integers in the sequence. The second line contains N
 *  space-separated integer numbers, a permutation of the numbers between 1 and N.
 *
 * Output specification:
 *  For each case, you must print a line with the amount of affected numbers
 *  during the described sorting procedure.
 *
 * Sample input:
 *  3
 *  1
 *  1
 *  5
 *  2 3 1 5 4
 *  9
 *  3 2 1 5 4 7 8 6 9
 *
 * Sample output:
 *  0
 *  5
 *  7
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2979
 */
import java.util.Scanner;

public class _2979_AnotherSortingProblem {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while (t-- > 0) {

      int n = in.nextInt();
      int count = 0;
      for (int i = 1; i <= n; i++) {
        if (in.nextInt() != i) {
          ++count;
        }
      }
      System.out.println(count);
    }

    in.close();
  }
}