/**
 * Problem: 2178 - Love Count
 *
 * Description:
 *  Yami is a very loving girl and she likes flowers, one day she goes to the
 *  garden which has N flowers numbered for convenience since 1 ... N, each flower
 *  has Ci petals and she decides to see if her boyfriend Vlad loves her. Then she
 *  takes flowers from the garden and takes away every flower petals, for each
 *  petal she alternate saying “love” or “no love”, at the beginning she starts
 *  saying “love”. Say what is the maximum number of petals that she can take from
 *  the garden to finish knowing that Vlad loves her.
 *
 * Input specification:
 *  The first input line consists of an integer 0 <= N <= 50 the number of flowers
 *  in the garden. The next line N integers 0<=Ci<=50 representing the numbers of
 *  petals of ith flower.
 *
 * Output specification:
 *  An integer representing the maximum number of petals, if yami can not finish
 *  saying "love" then answer is -1;
 *
 * Sample input:
 *  3
 *  1 5 6
 *
 * Sample output:
 *  11
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2178
 */
import java.util.ArrayList;
import java.util.Scanner;

public class _2178_LoveCount {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    byte n = in.nextByte();

    int total = 0;
    ArrayList<Integer> oddPetals = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int petals = in.nextInt();
      if (petals % 2 != 0) {
          oddPetals.add(petals);
      }
      total += petals;
    }

    System.out.println(getTotalPetals(oddPetals, total));

    in.close();
  }

  private static int getTotalPetals(ArrayList<Integer> oddPetals, int total) {
    if (total % 2 != 0) {
      return total;
    }

    if (oddPetals.size() == 0) {
        return -1;
    }

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < oddPetals.size(); i++) {
        int petals = oddPetals.get(i);
      if (petals < min) {
        min = petals;
      }
    }

    return total - min;
  }
}