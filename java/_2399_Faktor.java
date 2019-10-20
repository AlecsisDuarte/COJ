/**
 * Problem: 2399 - FAKTOR
 *
 * Description:
 *  Impact factor of a scientific journal is a measure reflecting the average
 *  number of citations to articles published in science journals. For this task we
 *  are using a simplified formula for calculating the impact factor:
 *  
 *  (Total sum of all citations articles published in the journal received)/
 *  (Total number of articles published)
 *  
 *  Rounding is always performed up. For example the impact factor of the “Journal
 *  for one research and time wasting” that published 38 articles quoted 894 times
 *  is 894 / 38 = 23.53 rounding up to 24.
 *  
 *  You are the editor of one scientific journal. You know how much article you are
 *  going to publish and the owners are pushing you to reach a specific impact
 *  factor. You are wondering how many scientists you will have to bribe to cite
 *  your article to meet the owners demands. Since money is tight you want to bribe
 *  the minimal amount of scientists.
 *
 * Input specification:
 *  First and only line of input will contain 2 integers, A (1 ≤ A ≤ 100), number
 *  of articles you plan to publish and I (1 ≤ I ≤ 100) impact factor the owners
 *  require.
 *
 * Output specification:
 *  First and only line of output should contain one integer, the minimal number
 *  of scientists you need to bribe.
 *
 * Sample input:
 *  38 24
 *
 * Sample output:
 *  875
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2399
 */
import java.util.Scanner;

public class _2399_Faktor {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println(in.nextShort() * (in.nextShort() - 1) + 1);

    in.close();
  }
}