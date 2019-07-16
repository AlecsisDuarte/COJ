/**
 * Problem: 1898 - Meeting
 *
 * Description:
 *  Two cyclists are travelling on a long highway along the same line, but in
 *  opposite directions. The first biker moves at a constant speed of 10 <= A <= 25
 *  km/h. The second biker at a constant speed of 10 <= B <= 25 km/h.
 *  
 *  Knowing this information, and the initial distance in kms between the cyclists
 *  (0 <= D <= 10^9), can you determine the number of hours it takes the bikers to
 *  pass each other? For the calculations, you may consider the bikers as very small
 *  points on the plane.
 *
 * Input specification:
 *  The first line contains an integer number 1 <= N <= 10^3 denoting the number
 *  of scenarios. Each of the following N lines contains three space separated
 *  integer numbers A, B and D.
 *
 * Output specification:
 *  You must print N lines. The i-th line contains the calculated hours for the
 *  i-th scenario given in the input, as a real number rounded up to four decimal
 *  places.
 *
 * Sample input:
 *  4
 *  20 20 0
 *  10 10 100
 *  20 25 900
 *  17 23 999
 *
 * Sample output:
 *  0.0000
 *  5.0000
 *  20.0000
 *  24.9750
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1898
 * NOTE: Throws Wrong Answer but in C () it runs alright
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1898_Meeting {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    short t = Short.parseShort(in.readLine());
    while (t-- > 0) {
      String[] line = in.readLine().split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      int d = Integer.parseInt(line[2]);

      out.write(String.format("%.4f\n", getHoursToMeet(a, b, d)));
    }

    out.close();
    in.close();
  }

  private static double getHoursToMeet(int  a, int  b, int  d) {
    double totalSpeed = a + b;
    return d / totalSpeed;
  }
}