/**
 * Problem: 1318 - Abc
 * 
 * Description: You will be given three integers A, B and C. The numbers will not be given in that exact order, 
 *  but we do know that A is less than B and B less than C. In order to make for a more pleasant viewing, we want 
 *  to rearrange them in the given order.
 * 
 * Input: The first line contains three positive integers A, B and C, not necessarily in that order. All three 
 *  numbers will be less than or equal to 100. The second line contains three uppercase letters 'A', 'B' and 
 *  'C' (with no spaces between them) representing the desired order.
 * 
 * Output: Output the A, B and C in the desired order on a single line, separated by single spaces.
 * 
 * Sample:
 *  Input:
 *      1 5 3
 *      ABC
 *  Output:
 *      1 3 5
 */
import java.util.Scanner;

public class _1318_Abc {
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