/**
 * Problem: 1010 - ACM contest and Blackout
 *
 * Description:
 *  In order to prepare the "The First National ACM School Contest" (in 2001)
 *  the major of the city decided to provide all the schools with a reliable
 *  source of power. The major is really afraid of blackouts. So, in order to do
 *  that, power station "Future" and one school (does not matter which one) must
 *  be connected; in addition, some schools may be connected as well. You may
 *  assume that a school has a reliable source of power if it's connected
 *  directly to "Future", or to any other school that has a reliable source of
 *  power. You are given the cost of connection between some schools. The major
 *  has decided to pick out the two cheapest connection plans (the cost of the
 *  connection is equal to the sum of the connections between the schools). Your
 *  task is to help the major find the cost of the two cheapest connection
 * plans.
 *
 * Input specification:
 *  The input starts with the number of test cases, T (1 <= T <= 15) on a line.
 *  Then T test cases follow. The first line of every test case contains two
 *  numbers, which are separated by a space: N (3 <= N <= 100) the number of
 *  schools in the city, and M the number of possible connections among them.
 * Next M lines contain three numbers Ai, Bi, Ci, where Ci is the cost of the
 *  connection (1 <= Ci <= 300) between schools Ai and Bi. The schools are
 *  numbered with integers in the range 1 to N.
 *
 * Output specification:
 *  For every test case print only one line of output. This line should contain
 *  two numbers separated by a single space, the cost of the two cheapest
 *  connection plans. Let S1 be the cheapest cost and S2 the next cheapest cost.
 *  It is important, that S1 = S2 if and only if there are two cheapest plans,
 *  otherwise S1 < S2. You can assume that it is always possible to find the
 * costs S1 and S2.
 *
 * Sample input:
 *  2
 *  5 8
 *  1 3 75
 *  3 4 51
 *  2 4 19
 *  3 2 95
 *  2 5 42
 *  5 4 31
 *  1 2 9
 *  3 5 66
 *  9 14
 *  1 2 4
 *  1 8 8
 *  2 8 11
 *  3 2 8
 *  8 9 7
 *  8 7 1
 *  7 9 6
 *  9 3 2
 *  3 4 7
 *  3 6 4
 *  7 6 2
 *  4 6 14
 *  4 5 9
 *  5 6 10
 *
 * Sample output:
 *  110 121
 *  37 37
 *
 * URL:http://coj.uci.cu/24h/problem.xhtml?pid=1010
 * NOTE: Still unable to get the second cheapest connection;
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class _1010_ACMContestAndBlackout {
  static class Node {
    int val;
    ArrayList<Connection> connections;
    Node(int val) {
      this.val = val;
      this.connections = new ArrayList<>();
    }
  }
  static class Connection implements Comparable<Connection> {
    Node node;
    int cost;

    Connection(Node node, int cost) {
      this.node = node;
      this.cost = cost;
    }

    @Override
    public int compareTo(Connection o) {
      if (this.cost > o.cost) {
        return 1;
      } else if (this.cost < o.cost) {
        return -1;
      }
      if (this.node.val > o.node.val) {
        return 1;
      } else if (this.node.val < o.node.val) {
        return -1;
      }
      return 0;
    }
    @Override
    public String toString() {
      return String.format("(%d costs $%d)", node.val, cost);
    }
  }

  private static int[] findConnectionsConst(Node school, int schools) {
    int start = 1;
    HashSet<Integer> visited = new HashSet<>();
    TreeSet<Connection> connections = new TreeSet<>(school.connections);

    visited.add(start);
    int totalCost = 0;
    int minDiff = Integer.MAX_VALUE;

    while (visited.size() != schools) {
      Iterator<Connection> itr = connections.iterator();
      Connection c = null;

      while (itr.hasNext()) {
        c = itr.next();
        if (!visited.contains(c.node.val)) {
          visited.add(c.node.val);
          totalCost += c.cost;
          connections.addAll(c.node.connections);
          school = c.node;
          break;
        }
      }

      // We search to the next optimal path for our seconds cheapest connection
      itr = connections.iterator();
      while (itr.hasNext()) {
        Connection option = itr.next();
        if (c != option && option.node == school) {
          int diff = Math.abs(option.cost - c.cost);
          if (diff < minDiff) {
            System.out.println("Original connection: " + c +
                               ", optional: " + option);
            minDiff = diff;
            break;
          }
        }
      }
    }
    return new int[] {totalCost, totalCost + minDiff};
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    Byte t = Byte.parseByte(in.nextLine());
    while (t-- > 0) {
      String[] values = in.nextLine().split(" ");

      int n = Integer.parseInt(values[0]); // Schools
      int m = Integer.parseInt(values[1]); // Connections

      Node[] schools = new Node[n];

      while (m-- > 0) {
        values = in.nextLine().split(" ");
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[1]);
        int cost = Integer.parseInt(values[2]);

        Node schoolA = schools[a - 1] == null ? new Node(a) : schools[a - 1];
        Node schoolB = schools[b - 1] == null ? new Node(b) : schools[b - 1];

        schoolA.connections.add(new Connection(schoolB, cost));
        schoolB.connections.add(new Connection(schoolA, cost));

        schools[a - 1] = schoolA;
        schools[b - 1] = schoolB;
      }
      int[] costs = findConnectionsConst(schools[0], n);
      System.out.printf("%d %d\n", costs[0], costs[1]);
    }

    in.close();
  }
}