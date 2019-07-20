/**
 * Problem: 2374 - Adding Numbers II
 *
 * Description:
 *  After he got tired of rotating tables, the teacher gave Alf another problem.
 *  She wrote two integers, A and B, on the blackboard and asked him to add them.
 *  Alf is never wrong with his calculation, but sometimes he doesn’t copy the
 *  numbers correctly. The only mistake he ever makes is copying a ‘5’ as a ‘6’,
 *  and viceversa. Given two numbers, A and B, calculate the minimum and the
 *  maximum sum Alf could possibly get.
 *
 * Input specification:
 *  The first and only line of input contains positive integers A and B (1 ≤ A, B
 *  ≤ 1 000 000).
 *
 * Output specification:
 *  In single line of output, print two space separated integers, minimum and
 *  maximum sum Alf could get.
 *
 * Sample input:
 *  11 25
 *
 * Sample output:
 *  36 37
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2374
 */
import java.util.Scanner;

public class _2374_AddingNumbersII {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt(), b = in.nextInt();
    printMinAndMax(a, b);

    in.close();
  }
  static void printMinAndMax(int a, int b) {
    int min = a + b;
    int max = min;

    int power = 1;
    String as = String.valueOf(a), bs = String.valueOf(b);

    for (int i = as.length() - 1; i >= 0; i--) {
      if (as.charAt(i) == '5') {
        max += power;
      } else if (as.charAt(i) == '6') {
        min -= power;
      }
      power *= 10;
    }

    power = 1;
    for (int i = bs.length() - 1; i >= 0; i--) {
      if (bs.charAt(i) == '5') {
        max += power;
      } else if (bs.charAt(i) == '6') {
        min -= power;
      }
      power *= 10;
    }

    System.out.printf("%d %d\n", min, max);
  }
}