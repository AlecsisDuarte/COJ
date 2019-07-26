import java.util.Scanner;

public class _2786_Coder {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    System.out.println((int)Math.ceil((n * n) / 2f));

    in.close();
  }
}