
/**
 * Problem: 2315 - The Easiest Problem is This On
 * 
 * Description: The sum of the digits S(N) is then defined as the plain sum of all individual digits 
 *  without multiplying them by powers of ten
 *  For example:
 *      N = 3029 = 3 x 10^3 + 2 x 10 + 9
 *      S(N) = 3 + 0 + 2 + 9 = 14
 *  
 *  If we multiply the original number N with another number m, the sum of the digits typically changes. 
 *  For example, if m1 = 26:
 *  
 *  N x m1 = 78754 = 7 x 10^4 + 8 x 10^3 + 7 x 10^2 + 5 x 10 + 4
 *  S(N x m1) = 7 + 8 + 7 + 5 + 4 = 31
 *  
 *  However, there are some numbers that, if multiplied by N, will result in the same sum of the digits 
 *  as the original number N. For example, consider m2 = 37:
 *  
 *  N x m2 = 112073 = 10^5 + 10^4 + 2 x 10^3 + 7 x 10 + 3
 *  S(N x m2) = 1 + 1 + 2 + 0 + 7 + 3 = 14 = S(N)
 *  
 *  Your task is to find the smallest positive integer p among those that will result in the same sum of 
 *  the digits when multiplied by N. To make the task a little bit more challenging, the number must also 
 *  be higher than ten.
 * 
 * Input: The input consists of several test cases. Each case is described by a single line containing 
 *  one positive integer number N, 1 <= N <= 100 000. The last test case is followed by a line containing zero.
 * 
 * Output: For each test case, print one line with a single integer number p which satisfies all of the 
 *  following conditions:
 *   - p > 10
 *   - S(N) = S(N x p)
 *   - ∀q ∈ N : [S(N) = S(N x q)] => [(q >= p) ∨ (q <= 10)]
 * 
 * Sample:
 *  Input:
 *      3029
 *      4
 *      5
 *      42
 *      0
 *  Output:
 *      37
 *      28
 *      28
 *      25
 */
import java.util.Scanner;

public class EasiestProblemThisOne {
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        int num = 0;
        while ((num = scan.nextInt()) > 0) {
            final int sum = getSummedDigits(num);
            int solution = 11;
            while (getSummedDigits(solution * num) != sum) {
                ++solution;
            }
            System.out.println(solution);
        }
        scan.close();
    }

    private static int getSummedDigits(int number) {
        int sum = 0;
        while (number / 10 > 0  ) {
            sum += number % 10;
            number = number / 10;
        }
        sum += number;
        return sum;
    }
}