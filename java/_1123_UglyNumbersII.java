/**
 * Problem: 1123 - Ugly Numbers II
 *
 * Description:
 *  Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 *  1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ... shows the first 10 ugly numbers. By
 *  convention, 1 is included. Given the integer n,write a program to find and print
 *  the n'th ugly number.
 *
 * Input specification:
 *  Each line of the input contains a postisive integer n (1 <= n <= 1500). Input
 *  is terminated by a line with n=0.
 *
 * Output specification:
 *  For each line, output the n'th ugly number .: Don't deal with the line with
 *  n=0.
 *
 * Sample input:
 *  1
 *  2
 *  9
 *  0
 *
 * Sample output:
 *  1
 *  2
 *  10
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1123
 * REF: https://www.geeksforgeeks.org/ugly-numbers/
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class _1123_UglyNumbersII {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt(), max = 0;
    ArrayList<Integer> l = new ArrayList<Integer>();

    while (n > 0) {
      max = Math.max(max, n);
      l.add(n);
      n = in.nextInt();
    }

    int[] ugly = uglyNumbersToNth(max);
    Iterator<Integer> nth = l.iterator();

    while (nth.hasNext()) {
      System.out.println(ugly[nth.next() - 1]);
    }

    in.close();
  }

  static int[] uglyNumbersToNth(int n) {
    int[] ugly = new int[n + 1];
    ugly[0] = 1;
    int i2 = 0, i3 = 0, i5 = 0, next_2 = 2, next_3 = 3, next_5 = 5;

    for (int i = 1; i < n; i++) {

      if (next_2 < next_3) {
        if (next_2 < next_5) {
          ugly[i] = next_2;
        } else {
          ugly[i] = next_5;
        }
      } else if (next_3 < next_5) {
        ugly[i] = next_3;
      } else {
        ugly[i] = next_5;
      }

      if (ugly[i] == next_2) {
        next_2 = ugly[++i2] * 2;
      }
      if (ugly[i] == next_3) {
        next_3 = ugly[++i3] * 3;
      }
      if (ugly[i] == next_5) {
        next_5 = ugly[++i5] * 5;
      }
    }

    return ugly;
  }
}