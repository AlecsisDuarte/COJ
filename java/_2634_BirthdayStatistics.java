/**
 * Problem: 2634 - Birthday Statistics
 *
 * Description:
 *  In a company, the birthdays of all employees are collected. Your task is to
 *  write a program to summarize the number of people that were born in each
 *  month.
 *
 * Input specification:
 *  The first line of the input contains a positive integer n (1 <= n <= 5,000)
 *  which is the number of employees. The n following lines contain the ID
 *  (4-digit number) of each employee and his/her birth date. The birth date is
 *  written in this particular format: day/month/year. Suppose that all dates in
 *  the input are valid dates.
 *
 * Output specification:
 *  Print out the number of month (1-12) and the number of employees born in that
 *  month.
 *
 * Sample input:
 *  10
 *  1000 1/2/1967
 *  1012 13/10/1940
 *  1103 5/1/1965
 *  2012 16/7/1980
 *  1125 18/9/1979
 *  1235 10/10/1976
 *  1400 16/11/1973
 *  1013 5/1/1965
 *  2109 28/7/1958
 *  2155 10/12/1970
 *
 * Sample output:
 *  1 2
 *  2 1
 *  3 0
 *  4 0
 *  5 0
 *  6 0
 *  7 2
 *  8 0
 *  9 1
 *  10 2
 *  11 1
 *  12 1
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2634
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2634_BirthdayStatistics {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(in.readLine());
    int[] months = new int[13];
    Pattern pattern = Pattern.compile(".*\\/(\\d+)\\/.*");

    while (n-- > 0) {
      Matcher m = pattern.matcher(in.readLine());
      if (m.matches()) {
        ++months[Integer.parseInt(m.group(1))];
      }
    }

    for (int i = 1; i < months.length; i++) {
        out.write(String.format("%d %d\n", i, months[i]));
    }

    in.close();
    out.close();
  }
}