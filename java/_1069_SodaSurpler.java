/**
 * Problem: 1069 - Soda Surpler
 *
 * Description:
 *  Tim is an absolutely obsessive soda drinker, he simply cannot get enough. Most
 *  annoyingly though, he almost never has any money, so his only obvious legal
 *  way to obtain more soda is to take the money he gets when he recycles empty
 *  soda bottles to buy new ones. In addition to the empty bottles resulting from
 *  his own consumption he sometimes finds empty bottles in the street. One day he
 *  was extra thirsty, so he actually drank sodas until he couldn't afford a new
 *  one.
 *
 * Input specification:
 *  The first line of the input file contains an integer N (1 <= N <= 15) which
 *  denotes the total number of test cases. The description of each test case is
 *  given below: A line with three non-negative integers E, F, C, where 0 <= E <=
 *  1000 represents the amount of empty soda bottles in Tim's possession at the
 *  start of the day, 0 <= F <= 1000 represents the amount of empty soda bottles
 *  that Tim found in the street during the day, and 1 <= C <= 2000 represents the
 *  amount of empty soda bottles required to buy a new soda.
 *
 * Output specification:
 *  For each test case, your program should print a line with a whole number that
 *  represents the amount of soda bottles that Tim can be taken. Look at the sample
 *  output for details. If Tim can take infinitely Sodas, print the number 0.
 *
 * Sample input:
 *  2
 *  9 0 3
 *  5 5 2
 *
 * Sample output:
 *  4
 *  9
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1069
 */
import java.util.Scanner;

public class _1069_SodaSurpler {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    while (n-- > 0) {
      int e = in.nextInt(), f = in.nextInt(), c = in.nextInt();

      if (c == 1 && (e > 0 || f > 0)) {
        System.out.println("0");
      } else {

        int empty = e + f;
        int drank = 0;
        while (empty >= c) {
          int drink = empty / c;
          drank += drink;
          empty = (empty % c) + drink;
        }

        System.out.println(drank);
      }
    }

    in.close();
  }
}