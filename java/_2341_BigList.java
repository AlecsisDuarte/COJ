/**
 * Problem: 2341 - Big List
 *
 * Description:
 *  Tiny is a not very intelligent boy and wants to compete with his ​​brother
 *  Axe to make him look bad any day. He is holding a list of mathematical
 *  calculations (questions) and their answers. He wants to ask some of those
 *  calculations to Axe and see if he accepts. He knows almost all of the questions
 *  he has in the list, and told them to his brother without looking at the list
 *  (then sometimes, Tiny can say some question which is not in the list).
 *  
 *  There is a problem, the list is very big. And when Axe responds Tiny takes a
 *  while to find the question with their answer in the list. Tiny needs help with
 *  the list and you should make an application that allows him to instantly find
 *  the question and their correct response, in order to know if Axe answer is fine.
 *  Also the program should tell him if their memory failed and said some question
 *  which is not in the list, not to allow Axe to respond in vain.
 *
 * Input specification:
 *  First line contain two integer numbers N and M (1 <= N, M <= 10^4), the number
 *  of mathematical calculations (questions) in the list and the number of questions
 *  which Axe must respond. The following N lines contains two space-separated
 *  strings, questions and their answers, each string has between 1 and 15
 *  characters (digits or '+'). The following M lines, may be of two forms: Only one
 *  string (question of Tiny), if it is not in the list. Two strings (question of
 *  Tiny and Axe response) if it is in the list. You can safely assume, that input
 *  meet above specifications. There are no repeated mathematical calculation in the
 *  list.
 *
 * Output specification:
 *  You should print M lines, one for each question of Tiny. If question is not in
 *  the list, you should print "not found". If question is in the list, you should
 *  print "ok" if Axe response is fine, otherwise you should print "wrong".
 *
 * Sample input:
 *  3 3
 *  2+4+1 7
 *  0+9+1 10
 *  7+2+6 15
 *  7+2+8
 *  2+4+1 10
 *  7+2+6 15
 *
 * Sample output:
 *  not found
 *  wrong
 *  ok
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2341
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class _2341_BigList {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] line = in.readLine().split(" ");
    int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
    HashMap<String, Integer> calcs = new HashMap<>();

    while (n-- > 0) {
      line = in.readLine().split(" ");
      calcs.put(line[0], Integer.parseInt(line[1]));
    }

    while (m-- > 0) {
      line = in.readLine().split(" ");
      Integer res = calcs.get(line[0]);
      if (res == null) {
        out.write("not found\n");
        continue;
      }

      if (line.length > 1 && res != Integer.parseInt(line[1])) {
        out.write("wrong\n");
      } else {
        out.write("ok\n");
      }
    }

    in.close();
    out.close();
  }
}