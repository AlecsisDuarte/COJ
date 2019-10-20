/**
 * Problem: 2146 - Counting Diagonals
 *
 * Description:
 *  Given an n-sided polygon is defined as the polygon diagonals all segments
 *  whose endpoints are any two vertices of the polygon that aren't adjacent. Two
 *  vertices in a polygon are adjacent if both delimiting one side. Your task is
 *  quite simple, given a number D of diagonals and a number V of vertices you
 *  must say whether a polygon composed of V vertices has D diagonal.
 *
 * Input specification:
 *  Two integers D y V separated by one space. D = [0, 2^63-1] y V = [3, 2^31-1].
 *
 * Output specification:
 *  If the polygon with V vertexes has D diagonals you should print "yes" without
 *  the quotes, in any other case print "no".
 *
 * Sample input:
 *  2 4
 *
 * Sample output:
 *  yes
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2146
 * REF: http://mathforum.org/library/drmath/sets/select/dm_polygon_diagonals.html
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2146_CountingDiagonals {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    long d = in.nextLong();
    long v = in.nextInt();

    //( d << 1 ) == ( d * 2 )
    out.write(v * (v - 3) == (d << 1) ? "yes\n" : "no\n");
    out.close();
    in.close();
  }
}