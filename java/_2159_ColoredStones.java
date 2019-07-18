/**
 * Problem: 2159 - Colored Stones
 *
 * Description:
 *  In the laboratory of the movement of competitive programming of the UCI,
 *  there are 1 <= N <= 50 gray tables. Vlad coach, does not like gray tables,
 *  therefore decided to paint some arbitrary amount of tables in blue (depending on
 *  how much blue paint has). But Ymon coach, does not like tables in gray nor blue,
 *  therefore decided to paint all remaining gray tables in red (he always have
 *  enough red paint). Then both friends reorganize the tables in the laboratory,
 *  coming first all the blue tables, and finally all the red tables.
 *  
 *  If you want to be a future contestant of the movement, find the number R of
 *  possible configurations for the tables of the laboratory, after tha painting
 *  task of Vlad and Ymon coachs.
 *
 * Input specification:
 *  A single integer number N, the number of tables in the laboratory.
 *
 * Output specification:
 *  A single integer number R, the number of possible configurations for the
 *  tables of the laboratory, after tha painting task of Vlad and Ymon coachs.
 *
 * Sample input:
 *  1
 *
 * Sample output:
 *  2
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2159
 */
import java.util.Scanner;

public class _2159_ColoredStones {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println(in.nextInt() + 1);
    in.close();
  }
}