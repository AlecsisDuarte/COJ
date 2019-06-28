
/**
 * Problem: 1566 - Cannon Balls
 * 
 * Description:
 *  When visiting an ancient castle two friends saw cannon. At the foot of it, the bullets 
 *  spherical shaped bullets are displayed, which are arranged next to each other, forming a 
 *  regular pyramid with a square base, with a single bullet at the apex (top floor). One of the 
 *  friends shows that the pyramid is formed by N floors, while the other responds by saying the 
 *  number of bullets that make it. Can you compute that number?
 * 
 * Input specification:
 *  Input consists of several test cases, each one described by a line with a single integer 
 *  N (1 <= N <= 500) denoting the number of floors. Input ends with line containing 0.
 * 
 * Output specification: 
 *  For each test case, output the total number of balls the pyramid consists of.
 * 
 * Sample input:
 *  1
 *  2
 *  0
 * 
 * Sample output:
 *  1
 *  5
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1566
 */
import java.util.Scanner;

public class _1566_CannonBalls {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            System.out.println(pyramidBalls(n));
            n = in.nextInt();
        }
        in.close();
    }

    private static long pyramidBalls(int n) {
        if (n == 1) {
            return 1L;
        }
        return (long)(n * n) + pyramidBalls(n - 1);
    }
}