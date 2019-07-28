/**
 * Problem: 3129 - Mysterious Number
 *
 * Description:
 *  Alice had a bag where each number from 1 to N was present in it. After a magic
 *  trick she either removes all even numbers or all odd numbers from the bag.
 *  Given the kind of trick she has performed find the Pth smallest number in the
 *  bag after the trick. For example P = 1 denotes the smallest number present.
 *
 * Input specification:
 *  First line contains 1 <= T <= 100, the number of test cases. Each test case
 *  consists of 1 <= N <= 10^3, a string S and an integer P >= 1 in single line. S
 *  will be either “odd” or “even”(quotes for clarity), denoting the kind of trick
 *  Alice has performed. Note: It is guaranteed that P will be less than or equal
 *  to remaining items in the bag.
 *
 * Output specification:
 *  For each test case, print the required answer in one line.
 *
 * Sample input:
 *  2
 *  4 odd 2
 *  5 even 2
 *
 * Sample output:
 *  4
 *  3
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3129
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3129_MysteriousNumber {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String[] values = in.readLine().split(" ", 3);
      int pth = Integer.parseInt(values[2]);

      out.write(String.format("%d\n", values[1].equals("even") ? pth * 2 - 1
                                                               : pth * 2));
    }

    in.close();
    out.close();
  }
}