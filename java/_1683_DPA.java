
/**
 * Problem: 1683 - DPA
 * 
 * Description:
 *  In the mathematical works usually with dividers numbers for many applications.
 *  In our case, we want to make a classification system with the divisors of a number N.
 *  Our system will have 3 possible classifications:
 *  
 *  - Deficient.
 *  - Perfect.
 *  - Abundant.
 *  
 *  We say that a number is Deficient if the sum of its divisors, excluding N, is less than N. It 
 *  is Perfect if the sum of these divisors is equal to N. Abundant, in the event that the sum of 
 *  the divisors is greater than N.
 * 
 * Input specification:
 *  Line 1: A number C which represents the number of cases tested.
 *  Then C lines, where each line will show a number N (1 <= N <= 500).
 * 
 * Output specification: 
 *  C lines: In each line, a string of characters ("Deficient", "Perfect" or "Abundant"), 
 *  indicating the type of classification according to the above system.
 * 
 * Sample input:
 *  3
 *  6
 *  12
 *  3
 * 
 * Sample output:
 *  Perfect
 *  Abundant
 *  Deficient
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1683
 * REF: https://www.dcode.fr/divisors-list-number
 */
import java.util.Scanner;

public class _1683_DPA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int c = in.nextInt();
        int[] values = getValues();
        
        while (c-- > 0 ) {
            short n = in.nextShort();
            int diff = values[n] - n;
            System.out.println(diff == 0 ? "Perfect" : diff > 0 ? "Abundant" : "Deficient");
        }
        
        in.close();
    }

    private static int[] getValues() {
        int[] values = new int[501];
        values[1] = 0;
        for (int i = 2; i < values.length; i++) {
            int sqr = (int)Math.sqrt(i);
            values[i] = 1;
            while (sqr > 1) {
                if (i % sqr == 0) {
                    int val = i / sqr;
                    values[i] += sqr + (sqr == val ? 0 : val);
                }
                --sqr;
            }
        }
        return values;
    }
}