import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _1214_SideOfTheRhombus {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = in.nextInt();
    while (n-- > 0) {
      double a = in.nextDouble(), s = in.nextDouble();
      out.write(String.format("%.3f\n", findRhombusSide(a, s)));
    }

    in.close();
    out.close();
  }

  static double findRhombusSide(double a, double s) {
    double q = findQ(a, s);

    System.out.println("Q = " + q);
    double halfQ = q / 2d, halfP = (s - q) / 2d;

    return Math.sqrt((halfQ * halfQ) + (halfP * halfP));
  }

  static double findQ(double a, double s) {
    double from = 0, to = s;
    float area = (float)(a * 2);

    while (from < to) {
      float q = (float)((to - from) / 2f);
      float newArea = (float)((s - q) * q);
      System.out.printf("From = %f, to = %f, area = %f, newArea = %f, q = %f\n",
                        from, to, area, newArea, q);
      if (newArea > area) {
        to = q - 0.001f;
      } else if (newArea < area) {
        from = q + 0.001f;
      } else {
        return q;
      }
    }
    return -1;
  }
}