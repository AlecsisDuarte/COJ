/**
 * Problem:
 *
 * Description:
 *  Harry Potter is one of the best wizards in the history of the
 *  Hogwarts School of Witchcraft and Wizardry. Unfortunately for Harry, the
 *  evil professor Umbridge knows he is not very good in maths. That’s why she has
 *  done a math test to Harry to evaluate his knowledge in another attempt to
 *  expel Harry from the Hogwarts School.
 * 
 *  Professor Umbridge told Harry: “Harry, this is a very simple exam for you. I
 *  will give you an initial pattern with points and I will explain you how to
 *  complete the pattern in each step. I just wants to know how many points will
 *  have the N-th pattern after you have been completed”.
 * 
 *  Professor Umbridge gives Harry the following pattern and said, that’s all
 *  you need to know. Help Harry to know the answer for the problem he has.
 *
 * Input specification:
 *  The first line of the input contains an integer M: 1 <= M <= 5000, the number
 *  of questions that Professor Umbridge will ask Harry. The following M lines
 *  contains a single integer specifying the N-th step that Harry has to complete
 *  in the pattern to answer the question.
 *
 * Output specification:
 *  The output contains M lines. Each line contains the answer to each of the
 *  questions Professor Umbridge makes Harry.
 *
 * Sample input:
 *  3
 *  1
 *  2
 *  3
 *
 * Sample output:
 *  1
 *  5
 *  13
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2362
 */
import java.util.Scanner;

public class _2362_HarryPotterAndThePoints {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int m = in.nextInt();

    for (int i = 0; i < m; i++) {
      int q = in.nextInt();
      System.out.println(q * q + (q - 1) * (q - 1));
    }

    in.close();
  }

  /**
   * Previous solution was getting all the paths prom 0 to max
   */
  static int[] getAllPatterns(int max) {
    int[] patterns = new int[max + 1];
    int inc = 4;
    patterns[1] = 1;

    for (int i = 2; i < patterns.length; i++) {
      patterns[i] = patterns[i - 1] + inc;
      inc += 4;
    }

    return patterns;
  }
}