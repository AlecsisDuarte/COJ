
/**
 * Problem: 1293 - Powers of Two
 * 
 * Description:
 *  Given an integer N (0 <= N <= 265), print exactly 2^N.
 * 
 * Input specification:
 *  A single line with the value of N.
 * 
 * Output specification: 
 *  A single line with the exactly value of 2^N.
 * 
 * Sample input:
 *  100
 * 
 * Sample output:
 *  1267650600228229401496703205376
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1293
 */
import java.math.BigDecimal;
import java.util.Scanner;

public class _1293_PowersOfTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short n = Short.parseShort(in.nextLine());
        System.out.println(powerTwo(2, n));
        in.close();
    }

    private static String power(int n) {
        return new BigDecimal("2").pow(n).toString();
    }

    // We reduce time to O(logn) and use space(1)
    private static BigDecimal powerTwo(long x, long n) {
        if (n == 0) {
            return BigDecimal.ONE;
        }
        BigDecimal tmpPower = powerTwo(x, n / 2);
        if (n % 2 == 0) {
            return tmpPower.multiply(tmpPower);
        } else {
            return new BigDecimal(x).multiply(tmpPower).multiply(tmpPower);
        }
    }
}