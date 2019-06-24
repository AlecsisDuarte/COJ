
/**
 * Problem: 1046 - Product Subsequence
 * 
 * Description:
 *  Consider a sequence of 10^3 integers, where for each position 1 <= N <= 10^3 in the sequence 
 *  corresponds a number given by: (N)*(N+1)*(N+2). Then the sum of the first 1 <= M <= 10^3 
 *  sequence numbers can be expressed as follows: 
 *      S = 1*2*3 + 2*3*4 + ... + (M-1)*(M)*(M+1) + (M)*(M+1)*(M+2). 
 *  Consider the interval of integers [a,b] with (1 <= a <= b <= 10^3). Can you determine the sum 
 *  of all the sequence numbers between a and b, they also included?
 * 
 * Input specification:
 *  An integer T with the number of cases in the first line of input. Each case consists of a line 
 *  with two integers a and b, representing the extremes of the interval.
 * 
 * Output specification: 
 *  One line for each case, with the sum of all the sequence numbers between a and b mod 100.
 * 
 * Sample input:
 *  3
 *  1 10
 *  30 30
 *  1 1000
 * 
 * Sample output:
 *  90
 *  60
 *  0
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1046
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1046_ProductSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] range = in.readLine().split(" ");
            short a = Short.parseShort(range[0]);
            short b = Short.parseShort(range[1]);

            out.write(String.valueOf(getRangeSumModded(a,b)));
            out.newLine();
        }

        out.flush();
        out.close();
        in.close();
    }

    private static long getRangeSumModded(short a, short b) {
        long res = 0;
        while (a <= b) {
            res += a * (++a) * (a + 1);
        }
        return res %= 100;
    }
}