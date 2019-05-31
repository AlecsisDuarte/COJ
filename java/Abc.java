import java.util.Scanner;

public class Abc {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final int firstNum = scan.nextInt();
        final int secondNum = scan.nextInt();
        final int thirdNum = scan.nextInt();
        
        scan.nextLine(); //Empty line

        final int[] num = sortedNumbers(firstNum, secondNum, thirdNum);
        final char[] letters = scan.nextLine().toCharArray();

        System.out.println(num[letters[0] - 65] + " " + num[letters[1] - 65] + " " + num[letters[2] - 65]);

        scan.close();
    }

    final private static int[] sortedNumbers(int a, int b, int c) {
        final int[] sorted = new int[3];
        if (a > b && a > c) {
            sorted[2] = a;
            if (b > c) {
                sorted[1] = b;
                sorted[0] = c;
            } else {
                sorted[1] = c;
                sorted[0] = b;
            }
        } else if (b > c) {
            sorted[2] = b;
            if (a > c) {
                sorted[1] = a;
                sorted[0] = c;
            } else {
                sorted[1] = c;
                sorted[0] = a;
            }
        } else {
            sorted[2] = c;
            if (a > b) {
                sorted[1] = a;
                sorted[0] = b;
            } else {
                sorted[1] = b;
                sorted[0] = a;
            }
        }
        return sorted;
    }
}