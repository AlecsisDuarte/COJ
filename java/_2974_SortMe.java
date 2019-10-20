/**
 * Problem: 2974 - Sort Me
 *
 * Description:
 *  We know the normal alphabetical order of the English alphabet, and we can then
 *  sort words or other letter sequences. For instance these words are sorted:
 *  ANTLER
 *  ANY
 *  COW
 *  HILL
 *  HOW
 *  HOWEVER
 *  WHATEVER
 *  ZONE
 *  
 *  The standard rules for sorting letter sequences are used: 
 *  1. The first letters are in alphabetical order. Among strings with the same prefix,
 *      like the prefix AN in ANTLER and ANY, they are ordered by the first character
 *      that is different, T or Y here. 
 * 
 *  2. One whole string may be a prefix of another
 *      string, like HOW and HOWEVER. In this case the longer sequence comes after the
 *      shorter one. 
 * 
 *  3. The Gorellians, at the far end of our galaxy, have discovered
 *      various samples of English text from our electronic transmissions, but they did
 *      not find the order of our alphabet. Being a very organized and orderly species,
 *      they want to have a way of ordering words, even in the strange symbols of
 *      English. Hence they must determine their own order. Unfortunately they cannot
 *      agree, and every Gorellian year, they argue and settle on a new order. 
 *  
 *  For instance, if they agree on the alphabetical order UVWXYZNOPQRSTHIJKLMABCDEFG
 *  then the words above would be sorted as
 *  WHATEVER
 *  ZONE
 *  HOW
 *  HOWEVER
 *  HILL
 *  ANY
 *  ANTLER
 *  COW
 *  
 *  The first letters of the words are in their alphabetical order. Where words have
 *  the same prefix, the first differing letter determines the order, so the order
 *  goes ANY, then ANTLER, since Y is before T in their choice of alphabet. Still
 *  HOWEVER comes after HOW, since HOW is a prefix of HOWEVER. Dealing with the
 *  different alphabetical orders each year by hand (or tentacle) is tedious. Your
 *  job is to implement sorting with the English letters in a specified sequence.
 *
 * Input specification:
 *  The input will contain one or more datasets. Each dataset will start with a
 *  line containing an integer n and a string s, where s is a permutation of the
 *  English uppercase alphabet, used as the Gorellians' alphabet in the coming year.
 *  The next n lines (1 <= n <= 20) will each contain one non-empty string of
 *  letters. The length of each string will be no more than 30. Following the last
 *  dataset is a line containing only 0.
 *
 * Output specification:
 *  The first line of output of each dataset will contain "year " followed by the
 *  number of the dataset, starting from 1. The remaining n lines are the n input
 *  strings sorted assuming the alphabet has the order in s.
 *
 * Sample input:
 *  8 UVWXYZNOPQRSTHIJKLMABCDEFG
 *  ANTLER
 *  ANY
 *  COW
 *  HILL
 *  HOW
 *  HOWEVER
 *  WHATEVER
 *  ZONE
 *  5 ZYXWVUTSRQPONMLKJIHGFEDCBA
 *  GO
 *  ALL
 *  ACM
 *  TEAMS
 *  GO
 *  10 ZOTFISENWABCDGHJKLMPQRUVXY
 *  THREE
 *  ONE
 *  NINE
 *  FIVE
 *  SEVEN
 *  ZERO
 *  TWO
 *  FOUR
 *  EIGHT
 *  SIX
 *  0
 *
 * Sample output:
 *  year 1
 *  WHATEVER
 *  ZONE
 *  HOW
 *  HOWEVER
 *  HILL
 *  ANY
 *  ANTLER
 *  COW
 *  year 2
 *  TEAMS
 *  GO
 *  GO
 *  ALL
 *  ACM
 *  year 3
 *  ZERO
 *  ONE
 *  TWO
 *  THREE
 *  FOUR
 *  FIVE
 *  SIX
 *  SEVEN
 *  EIGHT
 *  NINE
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2974
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class _2974_SortMe {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String line = in.readLine();
    int year = 1;
    while (!line.equals("0")) {
      String[] vals = line.split(" ", 2);

      int n = Integer.parseInt(vals[0]);
      int[] dictionary = new int[91];
      String[] lines = new String[n];

      for (int i = 0; i < vals[1].length(); i++) {
        dictionary[vals[1].charAt(i)] = i;
      }

      while (--n >= 0) {
        lines[n] = in.readLine();
      }
      sort(lines, dictionary);
      out.write(String.format("year %d\n", year++));
      for (int i = 0; i < lines.length; i++) {
        out.write(lines[i]);
        out.newLine();
      }
      line = in.readLine();
    }

    out.close();
    in.close();
  }

  static void sort(String[] lines, final int[] dictionary) {
    Comparator<String> compare = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.equals(o2)) {
          return 0;
        }

        int i = 0;
        for (; i < o1.length() && i < o2.length(); i++) {
          char c1 = o1.charAt(i), c2 = o2.charAt(i);
          if (dictionary[c1] > dictionary[c2]) {
            return 1;
          } else if (dictionary[c1] < dictionary[c2]) {
            return -1;
          }
        }

        if (o1.length() > o2.length()) {
          return 1;
        } else {
          return -1;
        }
      }
    };

    Arrays.sort(lines, compare);
  }
}