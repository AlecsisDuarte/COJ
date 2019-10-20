/**
 * Problem: 3601 - Writing Numbers
 *
 * Description:
 *  You have been hired to design a program for writing numbers of the decimal
 *  system with words. The program must read a list of K (1 ≤ K ≤ 12) integers and
 *  for each number Ki (1 ≤ Ki ≤ 12), it must print the same number but with words
 *  of the english alphabet. That's all. Is it this job too hard for you?
 *
 * Input specification:
 *  The first line of input contains an integer K representing the amount of
 *  numbers of the input. The following K lines contain an integer Ki representing
 *  the k-th number that should be written with words.
 *
 * Output specification:
 *  The output contains K lines, each one with the k-th number written with words.
 *
 * Sample input:
 *  5
 *  1
 *  7
 *  9
 *  10
 *  12
 *
 * Sample output:
 *  one
 *  seven
 *  nine
 *  ten
 *  twelve
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3601
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3601_WritingNumbers {
  static String[] NUMBERS = new String[] {
      "\n",      "one\n",   "two\n",  "three\n", "four\n",   "five\n",  "six\n",
      "seven\n", "eight\n", "nine\n", "ten\n",   "eleven\n", "twelve\n"};

  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int k = Integer.parseInt(in.readLine());

    while (k-- > 0) {
      int ki = Integer.parseInt(in.readLine());
      out.write(NUMBERS[ki]);
    }

    out.close();
    in.close();
  }
}