/**
 * Problem: 2205 - Counting Ones
 *
 * Description:
 *  Consider the binary representation of the integers in the range [A, B] (1 <= A
 *  <= B <= 1000). How many 1's are needed to write all those binary numbers?
 *  Easy, isn't it?
 *
 * Input specification:
 *  An integer T with the total number of test cases will be in the first line. T
 *  lines follow, each one with a 2 integers A, B, denoting the first and last
 *  integer in the range.
 *
 * Output specification:
 *  Output a line per test case. Each line must contain an integer with the number
 *  of 1's needed to write the binary representation of all integers within the
 *  current interval.
 *
 * Sample input:
 *  2
 *  1 10
 *  15 100
 *
 * Sample output:
 *  17
 *  291
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2205
 */
import java.util.Scanner;

public class _2205_CountingOnes {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    byte t = in.nextByte();
    
    while (t-- > 0) {
        int from = in.nextInt(), to = in.nextInt();
        System.out.println(countOnes(from, to));
    }

    in.close();
  }

  private static int countOnes(int from, int to) {
    int total = 0;
    for (int i = from; i <= to; i++) {
      total += Integer.bitCount(i);
    }

    return total;
  }
}