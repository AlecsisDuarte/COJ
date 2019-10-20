
/**
 * Problem: 1390 Max Factor
 * 
 * Description:
 *  To improve the organization of his farm, Farmer John label each one of its N (1 <= N <= 5000) 
 *  cows with a different serial number in the range 1..20000. Unfortunately, he is unable to help 
 *  the cows to interpret some serial numbers as well as others. In particular, a cow whose serial 
 *  number has the largest prime factor enjoys the highest social position among the other cows. 
 *  Remember that a prime number is simply a number that has no divisors except 1 and itself. The 
 *  number 7 is a prime number, while the number 6, being divisible by 2 and 3, it is not. Given a 
 *  set of N (1 <= N <= 5000) serial numbers in the range 1..20000, determine the one with the 
 *  largest prime factor.
 * 
 * Input specification:
 *  A single integer N. Then follow N serial numbers to be considered, one per line.
 * 
 * Output specification: 
 *  The integer with the largest prime factor. If more than one, print the number wich appears 
 *  earlier in the input.
 * 
 * Sample input:
 *  4
 *  36
 *  38
 *  40
 *  42
 * 
 * Sample output:
 *  38
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1390
 * REF: https://javarevisited.blogspot.com/2015/03/how-to-find-largest-prime-factor-of.html
 */
import java.util.Scanner;

public class _1390_MaxFactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short n = Short.parseShort(in.nextLine());
        int maxPrimeFactor = 0;
        short numWithMaxPrimeFactor = 0;

        while (n-- > 0) {
            short num = Short.parseShort(in.nextLine());
            int primeFactor = primeFactor(num);
            if (maxPrimeFactor < primeFactor) {
                maxPrimeFactor = primeFactor;
                numWithMaxPrimeFactor = num;
            }
        }
        System.out.println(numWithMaxPrimeFactor);
        in.close();
    }

    private static int primeFactor(int num) {
        int i = 2;
        while (i <= num) {
            if (num % i == 0) {
                num /= i;
                i--;
            }
            ++i;
        }
        return i;
    }
}