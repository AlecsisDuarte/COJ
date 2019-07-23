/**
 * Problem: 2403 - NATJECANJE
 *
 * Description:
 *  As you know, a kayaking competition is going on as we speak. Unfortunately
 *  strong winds have damaged a few kayaks, and the race starts in 5 minutes!.
 *  Fortunately, some teams have brought reserve kayaks. Since kayaks are bulky and
 *  hard to carry, teams are willing to lend kayaks to opposing teams if and only if
 *  they are starting immediately next to them.
 *  
 *  For example, team with the starting number 4 will lend its reserve kayak only to
 *  teams 3 and 5. Of course if some team did bring a reserve and its' kayak was
 *  damaged, they will use it themselves and not lend it to anyone. You as the
 *  organizer now need to know, what is the minimal number of teams that cannot
 *  start the race, not even in borrowed kayaks.
 *
 * Input specification:
 *  The first line of input contains three integers N, (2 ≤ N ≤ 10), total number
 *  of teams, S, (2 ≤ S ≤ N), number of teams with damaged kayaks and R, (2≤ R ≤ N),
 *  number fo teams with reserve kayaks. The second line contains exactly S numbers,
 *  the starting numbers of teams with damaged kayaks. The second line will not
 *  contain duplicates.
 *  
 *  The third line contains exactly R numbers, the starting numbers of teams with
 *  reserve kayaks. The third line will not contain duplicates.
 *
 * Output specification:
 *  The first and only line of output should contain the smallest number of teams
 *  that cannot start the competition.

 *
 * Sample input:
 *  5 2 1
 *  2 4
 *  3
 *
 * Sample output:
 *  1
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2403
 */
import java.util.Scanner;

public class _2403_Natjecanje {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextByte(), s = in.nextByte(), r = in.nextByte();
    boolean[] noKayak = new boolean[n + 1];

    while (s-- > 0) {
      noKayak[in.nextByte()] = true;
    }

    while (r-- > 0) {
      byte hasSpare = in.nextByte();
      if (noKayak[hasSpare]) {
        noKayak[hasSpare] = false;
      } else if (noKayak[hasSpare - 1]) {
        noKayak[hasSpare - 1] = false;
      } else if (hasSpare < n && noKayak[hasSpare + 1]) {
        noKayak[hasSpare + 1] = false;
      }
    }
    int count = 0;
    for (int i = 1; i < noKayak.length; i++) {
      if (noKayak[i]) {
        ++count;
      }
    }
    System.out.println(count);

    in.close();
  }
}