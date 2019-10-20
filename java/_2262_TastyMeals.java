/**
 * Problem: 2262 - Tasty Meals
 *
 * Description:
 *  Professor Juan Núñez believes there’s a relationship between the weight of a
 *  meal and its taste. Each meal is composed of N courses and each course has an
 *  associated weight C_i. The weight of a meal is therefore the sum of the weights
 *  of its courses. In general, Professor Núñez asserts that if a meal weights at
 *  least K, then it is very tasty. It should not be to your surprise that
 *  Professor Núñez has a big belly.
 *   
 *  You are given the weights of the courses of a meal and the value K. What is the
 *  minimum number of courses that Professor Núñez must eat in order to find the
 *  given meal very tasty?
 *
 * Input specification:
 *  The input contains two lines. The first line has two space-separated positive
 *  integers N and K (1 <= N <= 1000, 1 <= 10^12 <= K). The second line contains N
 *  integers C_i (1 <= C_i <= 10^9), the weights of the N courses.
 *
 * Output specification:
 *  For the given meal, output the minimum number of courses necessary for
 *  Professor Núñez to find the meal very tasty. If there is no way for the meal to
 *  be very tasty, please print "IMPOSSIBLE" (without the quotes).
 *
 * Sample input:
 *  3 100
 *  101 500 1000
 *
 * Sample output:
 *  1
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2262
 */
import java.util.Arrays;
import java.util.Scanner;

public class _2262_TastyMeals {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    short n = in.nextShort();
    long k = in.nextLong();

    int[] weights = new int[n];
    long totalWeight = 0;
    for (int i = 0; i < n; i++) {
      totalWeight += weights[i] = in.nextInt();
    }

    if (totalWeight < k) {
      System.out.println("IMPOSSIBLE");
    } else {
        System.out.println(minimumCourses(weights, totalWeight, k));
    }

    in.close();
  }

  private static int minimumCourses(int[] weights, long totalWeight, long k) {
    Arrays.sort(weights);
    int courses = weights.length;
    for (int i = 0; i < weights.length - 1; i++) {
      if (totalWeight - weights[i] <= k) {
        totalWeight -= weights[i];
      } else {
        break;
      }
    }

    return courses;
  }
}