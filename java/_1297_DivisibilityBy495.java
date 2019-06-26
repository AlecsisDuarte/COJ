
/**
 * Problem: 1297 - Divisibility by 495
 * 
 * Description:
 *  Can you determine when a number given is divisible by 495 ?

 * 
 * Input specification:
 *  The first line of the input have an integer T specifying the number of test cases. The next T 
 *  lines you will have a integer N less than 10^1000.
 * 
 * Output specification: 
 *  For each test case, if N is divisible by 495, print a single line with ?YES? else, print ?NO?.
 * 
 * Sample input:
 *  1
 *  2
 * 
 * Sample output:
 *  NO
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1297
 */
import java.math.BigInteger;
import java.util.Scanner;

public class _1297_DivisibilityBy495 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger fourNinetyFive = new BigInteger("495");

        long t = Long.parseLong(in.nextLine());
        while (t-- > 0) {
            // you have to get the value as a BigInteger directly from the buffer
            BigInteger bg = in.nextBigInteger();
            System.out.println(bg.mod(fourNinetyFive).equals(BigInteger.ZERO) ? "YES" : "NO");
        }
        in.close();
    }
}