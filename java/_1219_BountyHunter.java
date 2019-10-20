/**
 * Problem: 1219 - Bounty Hunter
 *
 * Description:
 *  Tomás is a bounty hunter member of Fast Riffle International. He uses to live
 *  hunting dangerous criminals for whom a reward is offered, dead or alive,
 *  preferably dead. At the present he is having problems to acquire bullets for
 *  his weapon, because almost all his providers are in jail. Every month is
 *  published the full list of available jobs, with the reward offered. Because of
 *  this situation he must use a fixed number of bullets in the month obtaining
 *  the maximum possible profit, using one bullet for job. For each job Tomás know
 *  the distance he must walk to the job location from his house. In a day he can
 *  only do one job and go back home, at month's end hi always is very tired, but
 *  who cares: he earns good money. The first day in every month Tomás do his
 *  planning, please write a program to help him in this task.
 *
 * Input specification:
 *  The first line of the input contains an integer T (1<=T<=20), de number of
 *  test cases. For each test case the first line contains two space separated
 *  integers B and A (1<=B<=A<=10000), B the numbers of bullets to spend in the
 *  month and A the number of available jobs. The next A lines for each test case
 *  contains two space separated integers R (1<=R<=10000) and D (1<=D<=1000), the
 *  reward offered and distance to the location of the job.
 *
 * Output specification:
 *  For each test case you should print (only if you want get the problem
 *  accepted) one line with a single number, the maximum total reward Tomas can get
 *  spending B bullets.
 *
 * Sample input:
 *  1
 *  3 5
 *  8 2
 *  100 80
 *  21 7
 *  2 1000
 *  70 20
 *
 * Sample output:
 *  191
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1219
 */
import java.util.Arrays;
import java.util.Scanner;

public class _1219_BountyHunter {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    byte t = in.nextByte();
    while (t-- > 0) {
      int b = in.nextInt(), a = in.nextInt();
      int[] r_array = new int[a];

      for (int i = 0; i < a; i++) {
        r_array[i] = in.nextInt();
        in.next();
      }

      Arrays.sort(r_array);
      int totalRewards = 0, index = a - 1;
      while (b-- > 0) {
        totalRewards += r_array[index--];
      }

      System.out.println(totalRewards);
    }

    in.close();
  }
}