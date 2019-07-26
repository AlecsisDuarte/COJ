import java.util.Scanner;

public class _2785_WhoIsTheWinner {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt(), total = 0;
    for (int i = 0; i < n; i++) {
      total += in.nextInt();
    }

    System.out.printf("%.2f\n", total / (double)n);

    in.close();
  }
}