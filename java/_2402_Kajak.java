/**
 * Problem: 2402 - KAJAK
 *
 * Description:
 *  Mirko and Slavko are sports commentators on a local kayaking competition. They
 *  have a live satellite feed of the entire track. Since there are too much teams
 *  for our dynamic duo to follow, they asked you to help them. They would like you
 *  to write a program that will display current standings teamby-team.
 *  
 *  The satellite feed is encoded as a table of R rows C characters each. The first
 *  character in each row is the starting line, encoded by the character 'S'. The
 *  last character in each row is the finishing line, encoded by 'F'. There are
 *  exactly nine kayaks on the image. Each kayak is marked by his number, and each
 *  spans exactly three consecutive columns. Water is marked by '.'.
 *  
 *  Teams are ranked by their distance to the finish line. Smaller is better. If two
 *  teams are at the same distance, they share their place.
 *
 * Input specification:
 *  The first line of input contains two integers R and C (10 ≤ R, C ≤ 50), the
 *  number of rows and columns of the encoded satellite image. Each of the following
 *  R lines contains exactly C characters '.', 'S', 'F' and 'digits 1' to '9'. Each
 *  row will contain at most one kayak. Each image contains all 9 kayaks.
 *
 * Output specification:
 *  Output nine lines, one for each kayak. The ith line should contain the current
 *  rank of the ith team.

 *
 * Sample input:
 *  10 15
 *  S..........222F
 *  S.....111.....F
 *  S...333.......F
 *  S...555.......F
 *  S.......444...F
 *  S.............F
 *  S......777....F
 *  S..888........F
 *  S........999..F
 *  S...666.......F
 *
 * Sample output:
 *  5
 *  1
 *  6
 *  3
 *  6
 *  6
 *  4
 *  7
 *  2
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2402
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2402_Kajak {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int r = in.nextInt(), c = in.nextInt();
    in.nextLine();

    ArrayList<ArrayList<Integer>> distances = initializeDistances(c);
    Pattern p = Pattern.compile("S(:?.*?)(\\d)?(\\.*)?F");

    while (r-- > 0) {
      Matcher m = p.matcher(in.nextLine());
      if (m.matches() && m.group(2) != null) {
        distances.get(m.group(3).length()).add(m.group(2).charAt(0) - '0');
        // distances[m.group(3).length()][m.group(2).charAt(0) - '0'] = true;
      }
    }
    int[] positions = calculatePosition(distances);
    for (int i = 1; i < positions.length; i++) {
      out.write(String.format("%d\n", positions[i]));
    }

    in.close();
    out.close();
  }

  private static int[] calculatePosition(
      ArrayList<ArrayList<Integer>> distances) {
    int pos = 1;
    int[] positions = new int[10];

    for (int c = 0; c < distances.size(); c++) {
      boolean found = false;
      Iterator<Integer> players = distances.get(c).iterator();
      if (players.hasNext()) {
        found = true;
        while (players.hasNext()) {
          positions[players.next()] = pos;
        }
      }
      if (found) {
        ++pos;
      }
    }

    return positions;
  }

  static ArrayList<ArrayList<Integer>> initializeDistances(int c) {
    ArrayList<ArrayList<Integer>> distances = new ArrayList<>();
    for (int i = 0; i < c - 4; i++) {
      distances.add(new ArrayList<Integer>());
    }
    return distances;
  }
}