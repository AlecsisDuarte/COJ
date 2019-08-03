import java.util.Arrays;
import java.util.Scanner;

public class _2789_SumOrder {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String line = in.nextLine();
    // System.out.println(reverse(line));
    System.out.println(reverseChar(line));
    in.close();
  }

  static String reverse(String line) {
    String[] sums = line.split("\\+");
    StringBuilder sb = new StringBuilder(line.length());

    Arrays.sort(sums);
    sb.append(sums[0]);
    for (int i = 1; i < sums.length; i++) {
      sb.append('+');
      sb.append(sums[i]);
    }
    return sb.toString();
  }

  static char[] reverseChar(String line) {
    char[] res = new char[line.length()];
    int[] numbers = new int[4];

    for (int i = 0; i < line.length(); i += 2) {
      ++numbers[line.charAt(i) - '0'];
    }

    int index = 0;

    for (int i = 1; i < numbers.length && index < res.length; i++) {
      while (numbers[i]-- > 0) {
        res[index++] = (char)(i + '0');
        if (index < res.length) {
          res[index++] = '+';
        }
      }
    }

    return res;
  }
}