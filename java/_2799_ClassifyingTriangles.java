/**
 * Problem: 2799 - Classifying Triangles
 *
 * Description:
 *  The little Ivan has a problem to determinate the classification of a triangle
 *  by its angles. For this reason, you will be programing an algorithm that help
 *  the little Ivan. The program will receive 3 parameters: the triangle's angles.
 *
 * Input specification:
 *  The input consists of 3 integers, each angle in a different line.
 *
 * Output specification:
 *  You should print one of the following classifications:
 *  Equilateral
 *  Isosceles
 *  Scalene
 *  Error
 *
 * Sample input:
 *  60
 *  70
 *  50
 *
 * Sample output:
 *  Scalene
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2799
 */
import java.util.Scanner;

public class _2799_ClassifyingTriangles {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int total = 0;
    int[] angles = new int[3];

    for (int i = 0; i < angles.length; i++) {
      angles[i] = in.nextInt();
      total += angles[i];
    }

    if (total == 180) {
      if (angles[0] == angles[1]) {
        if (angles[0] == angles[2]) {
          System.out.println("Equilateral");
        } else {
          System.out.println("Isosceles");
        }
      } else if (angles[0] == angles[2] || angles[1] == angles[2]) {
        System.out.println("Isosceles");
      } else {
        System.out.println("Scalene");
      }
    } else {
      System.out.println("Error");
    }

    in.close();
  }
}