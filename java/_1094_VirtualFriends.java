/**
 * Problem: 1094 - Virtual Friends
 *
 * Description:
 *  These days, you can do all sorts of things online. For example, you can use
 *  various websites to make virtual friends. For some people, growing their
 *  social network (their friends, their friends' friends, their friends'
 *  friends' friends, and so on), has become an addictive hobby. Just as some
 *  people collect stamps, other people collect virtual friends. Your task is to
 *  observe the interactions on such a website and keep track of the size of
 *  each person's network. Assume that every friendship is mutual. If Fred is
 *  Barney's friend, then Barney is also Fred's friend.
 *
 * Input specification:
 *  The first line of input contains one integer specifying the number of test
 *  cases to follow (at most 5). Each test case begins with a line containing an
 *  integer F, the number of friendships formed, which is no more than 10^5.
 *  Each of the following F lines contains the names of two people who have just
 *  become friends, separated by a space. A name is a string of 1 to 20 letters
 *  (uppercase or lowercase).
 *
 * Output specification:
 *  Whenever a friendship is formed, print a line containing one integer, the
 *  number of people in the social network of the two people who have just
 *  become friends.
 *
 * Sample input:
 *  1
 *  3
 *  Fred Barney
 *  Barney Betty
 *  Betty Wilma
 *
 * Sample output:
 *  2
 *  3
 *  4
 *
 * URL:http://coj.uci.cu/24h/problem.xhtml?pid=1094
 */
import java.io.*;
import java.util.*;

public class _1094_VirtualFriends {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    byte t = Byte.parseByte(in.readLine());
    while (t-- > 0) {
      ArrayList<HashSet<String>> network = new ArrayList<>();
      long f = Long.parseLong(in.readLine());
      while (f-- > 0) {
        String[] friends = in.readLine().split(" ");
        int networkIndexOne = -1, networkIndexTwo = -1;

        for (int i = 0; i < network.size(); i++) {
          if (network.get(i).contains(friends[0])) {
            networkIndexOne = i;
            if (networkIndexTwo > -1) {
              break;
            }
          } else if (network.get(i).contains(friends[1])) {
            networkIndexTwo = i;
            if (networkIndexOne > -1) {
              break;
            }
          }
        }

        if (networkIndexOne > -1) {
          HashSet<String> groupOne = network.get(networkIndexOne);
          if (networkIndexTwo > -1) {
            HashSet<String> groupTwo = network.get(networkIndexTwo);
            groupOne.addAll(groupTwo);
            network.remove(groupTwo);
          } else {
            groupOne.add(friends[1]);
          }
          out.write(String.valueOf(groupOne.size()));
          out.write('\n');
        } else if (networkIndexTwo > -1) {
          HashSet<String> groupTwo = network.get(networkIndexTwo);
          groupTwo.add(friends[0]);

          out.write(String.valueOf(groupTwo.size()));
          out.write('\n');
        } else {
          HashSet<String> group = new HashSet<String>(2);
          group.add(friends[0]);
          group.add(friends[1]);
          network.add(group);
          out.write(String.valueOf(group.size()));
          out.write('\n');
        }
      }
    }

    out.close();
    in.close();
  }
}