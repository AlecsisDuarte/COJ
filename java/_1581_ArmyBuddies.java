
/**
 * Problem: 1581 - Army Buddies
 * 
 * Description:
 *  Nlogonia is fighting a ruthless war against the neighboring country of Cubiconia. The Chief 
 *  General of Nlogonia's Army decided to attack the enemy with a linear formation of soldiers, 
 *  that would advance together until conquering the neighboring country.
 *  Before the battle, the Chief General ordered that each soldier in the attack line, besides 
 *  protecting himself and attacking, should also protect his two (nearest) neighbors in the line, 
 *  one to his left and one to his right. The Chief General told the soldiers that for each of 
 *  them, his buddies would be these two neighbors, if such neighbors existed  because the 
 *  leftmost soldier does not have a left neighbor and the rightmost soldier  does not have a right 
 *  neighbor). The Chief General also told the soldiers that protecting
 *  their buddies was very important to prevent the attack line from being broken. So important 
 *  that, if the left or right buddy of a soldier is killed, then the next living  neighbor to the 
 *  left or to the right of the soldier, respectively, should become his buddy. The battle is 
 *  fierce, and many soldiers in the attack line are being killed by re shots,  renades and bombs. 
 *  But following the Chief General's orders, immediately after  nowing about losses in the attack 
 *  line, the Army's information systems division has to inform the soldiers who their new buddies 
 *  are. You are given the number of soldiers in the attack line, and a sequence of loss reports. 
 *  Each loss report describes a group of contiguous soldiers in the attack line that were just 
 *  killed in the battle. Write a program that, for each loss report, prints the new buddies formed. 
 * 
 * Input specification:
 *  Each test case is described using several lines. The first input line contains two integers S 
 *  and B representing respectively the number of soldiers in the attack line, and the number of 
 *  loss reports (1 <= B <= S <= 10^5 ). Soldiers are identified by different integers from 1 to S, 
 *  according to their positions in the attack line, being 1 the leftmost soldier and S the 
 *  rightmost soldier. Each of the next B input lines describes a loss report using two integers L 
 *  (left) and R (right), meaning that soldiers from L to R were killed (1 <= L <= R <= S ). You 
 *  may assume that until that moment those soldiers were alive and were just killed. The last test 
 *  case is followed by a line containing two zeros. 
 * 
 * Output specification: 
 *  For each test case output B+1 lines. In the i-th output line write the new buddies formed by 
 *  removing from the attack line the soldiers that were just killed according to the i-th loss 
 *  report. That is, for the loss report 'L R' print the first surviving soldier to the left of L 
 *  and the first surviving soldier to the rigth of R. For each direction, print the character '*' 
 *  (asterisk) if there is no surviving soldier in that direction. Print a line  containing a 
 *  single character '-' (hyphen) after each test case.
 * 
 * Sample input:
 *  1 1
 *  1 1
 *  10 4
 *  2 5
 *  6 9
 *  1 1
 *  10 10
 *  5 1
 *  1 1
 *  0 0
 * 
 * Sample output:
 *  * *
 *  -
 *  1 6
 *  1 10
 *  * 10
 *  * *
 *  -
 *  * 2
 *  -
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1581
 * REF: https://github.com/MiichaelD/COJ/blob/master/_1581_A_ArmyBuddies.java
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1581_ArmyBuddies {
    private static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            right = left = null;
        }
    }

    private static class Soldiers {
        private Node start, end;

        Soldiers(int n) {
            start = new Node(1);
            Node tmp = start;
            start.left = new Node(0);
            for (int i = 2; i <= n; i++) {
                Node next = new Node(i);
                next.left = tmp;
                tmp.right = next;

                tmp = next;
            }
            end = tmp;
            end.right = new Node(0);
        }

        Integer[] killRange(int l, int r) {
            Node left = start, right = end;
            if (left.val == 0 && right.val == 0) {
                return new Integer[] { null, null };
            }

            Integer[] res = new Integer[2];
            if (l > left.val) {
                while (left.val != l) {
                    left = left.right;
                }
            } else {
                while (left.val != l) {
                    left = left.left;
                }
            }

            if (r > right.val) {
                while (right.val != r) {
                    right = right.right;
                }
            } else {
                while (right.val != r) {
                    right = right.left;
                }
            }

            if (left.val != 0) {
                left = left.left;
            }

            if (right.val != 0) {
                right = right.right;
            }

            left.right = right;
            right.left = left;

            if (left.val == 0) {
                start = left.right;
                res[0] = null;
            } else {
                res[0] = left.val;
                start = left;
            }

            if (right.val == 0) {
                end = right.left;
                res[1] = null;
            } else {
                res[1] = right.val;
                end = right;
            }
            return res;
        }
    }

    // Improved version that does constant time to report
    private static class Buddies {
        int[] left, right;
        int rightBoundary;

        Buddies(int soldiers) {
            this.rightBoundary = soldiers + 1;
            this.left = new int[soldiers + 2];
            this.right = new int[rightBoundary];
            
            for (int i = 1; i <= soldiers; i++) {
                this.left[i] = i - 1;
                this.right[i] = i + 1;
            }
        }

        Integer[] report(int l, int r) {
            Integer[] sides = new Integer[2];

            sides[0] = left[l] == 0 ? null : left[l];
            sides[1] = right[r] == rightBoundary ? null : right[r];

            left[right[r]] = left[l];
            right[left[l]] = right[r];

            return sides;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = in.readLine().split(" ");
        while (!line[0].equals("0") && !line[1].equals("0")) {
            int s = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            // Soldiers soldiers = new Soldiers(s);
            Buddies buddies = new Buddies(s);
            while (b-- > 0) {
                line = in.readLine().split(" ");
                int l = Integer.parseInt(line[0]);
                int r = Integer.parseInt(line[1]);

                Integer[] sides = buddies.report(l, r);
                // Integer[] sides = soldiers.killRange(l, r);

                out.write(sides[0] == null ? "*" : String.valueOf(sides[0]));
                out.write(" ");
                out.write(sides[1] == null ? "*" : String.valueOf(sides[1]));
                out.write("\n");
            }
            out.write("-\n");
            line = in.readLine().split(" ");
        }

        out.close();
        in.close();
    }
}