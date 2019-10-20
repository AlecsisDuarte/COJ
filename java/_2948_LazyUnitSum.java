/**
 * Problem: 2948 - Lazy Unit Sum
 *
 * Description:
 *  Jimmy is a math teacher at Great Frontier School. He loves to give his
 *  students multiplication exercises. However, he doesn’t care about the actual
 *  operation result but the unit sum of its digits.
 *  
 *  At Great Frontier School, they define the unit sum (US) of N as the unit that it
 *  is left after doing the sum of all the digits of a number over and over again
 *  until they get a number of exactly 1 digit. For example: US(976) = 9 + 7 + 6 =
 *  22 -> 2 + 2 = 4. Another example is US(19) = 1.
 *  
 *  Jimmy left as an assignment to get the US of any number. In order to check if a
 *  student get the right answer or not, he wants to make a program that solves it
 *  fast enough, but he is too busy for doing it himself.
 *  
 *  ¿Can you help Jimmy to check his homework?
 *
 * Input specification:
 *  The first line of input contains an integer T (1 <= T <= 50), the number of
 *  test cases. Next T lines contains an integer number 0 <= A <= 10^1000.
 *
 * Output specification:
 *  For each test case, the output is a single line containing the corresponding
 *  Unit Sum of A.
 *
 * Sample input:
 *  3
 *  18
 *  14
 *  1234
 *
 * Sample output:
 *  9
 *  5
 *  1
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2948
 */
import java.math.BigInteger;
import java.util.Scanner;

public class _2948_LazyUnitSum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    while (t-- > 0) {
      BigInteger bi = in.nextBigInteger();
      System.out.println(getUnitSum(bi));
    }

    in.close();
  }

  static int getUnitSum(BigInteger a) {
    if ((a.divide(BigInteger.TEN)).equals(BigInteger.ZERO)) {
      return a.intValue();
    }

    int sum = 0;

    while (a.compareTo(BigInteger.ZERO) > 0) {
      sum += a.remainder(BigInteger.TEN).intValue();
      a = a.divide(BigInteger.TEN);
    }

    return getUnitSum(sum);
  }

  static int getUnitSum(int a) {
    if (a < 10) {
      return a;
    }
    int sum = 0;
    while (a > 0) {
      sum += a % 10;
      a /= 10;
    }
    return getUnitSum(sum);
  }
}