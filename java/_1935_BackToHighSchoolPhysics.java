/**
 * Problem: 1935 - Back to High School Physics
 *
 * Description:
 *  A particle has initial velocity and acceleration. If its velocity after
 *  certain time is v then what will its displacement be in twice of that time?
 *
 * Input specification:
 *  The input will contain two integers in each line. Each line makes one set of
 *  input. These two integers denote the value of v (−100 <= v <= 100) and t (0 <=
 *  t <= 200) (t means at the time the particle gains that velocity v).
 *
 * Output specification:
 *  For each line of input print a single integer in one line denoting the
 *  displacement in double of that time.
 *
 * Sample input:
 *  0 0
 *  5 12
 *
 * Sample output:
 *  0
 *  120
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1935
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _1935_BackToHighSchoolPhysics {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner in = new Scanner(System.in);

    while (in.hasNextInt()) {
        int v = in.nextInt();
        int t = in.nextInt() << 1; //We double time by shifting to the left

        out.write(String.format("%d\n", v*t));
    }

    out.close();
    in.close();
  }
}