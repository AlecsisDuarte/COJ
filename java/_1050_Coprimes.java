
/**
 * Problem: 1050 - Coprimes
 * 
 * Description:
 *  For given integer N (1 <= N <= 10^4) find the amount of positive numbers not greater than N 
 *  that coprime with N. Let us call two positive integers (say, A and B, for example) coprime if 
 *  (and only if) their greatest common divisor is 1. (i.e. A and B are coprime if gcd(A,B) = 1).
 * 
 * Input specification:
 *  Input contains integer N.
 * 
 * Output specification: 
 *  Write answer in standard output.
 * 
 * Sample input:
 *  9
 * 
 * Sample output:
 *  6
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1050
 * Improvement Ref: https://github.com/MiichaelD/COJ/blob/master/_1050_A_Comprime.cpp
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1050_Coprimes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        System.out.println(countCommonDivisorTwo(n));
        in.close();
    }

    private static int countCommonDivisorOne(int n) {
        int count = 0;

        List<Integer> aDivisors = new ArrayList<>();
        for (int i = n; i > 1; i--) {
            if (n % i == 0) {
                aDivisors.add(i);
            }
        }
        n /= 2;
        while (--n > 1) {
            if (gcd(aDivisors, n) == 1) {
                count++;
            }
        }

        return (count + 1) * 2;
    }

    private static int gcd(List<Integer> aDivisors, int b) {
        for (int i = 0; i < aDivisors.size(); i++) {
            if (b % aDivisors.get(i) == 0) {
                return aDivisors.get(i);
            }
        }
        return 1;
    }

    private static int countCommonDivisorTwo(int n) {
        int count = 0;
        
        for (int i = 2; i < n / 2; i++) {
            if (gcdTwo(n, i) == 1) {
                count++;
            }
        }
        return (count + 1) * 2;
    }
    
    //Faster way to get the GCD
    private static int gcdTwo(int a, int b) {
        return b == 0 ? a : gcdTwo(b, a % b);
    }
}