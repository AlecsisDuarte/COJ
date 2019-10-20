
/**
 * Problem: 1676 - Let us help George
 * 
 * Description:
 *  George and all children are fascinated with shapes. His father knowing this takes a simple 
 *  problem that combines elements of calculation with some geometry. George is very adept working 
 *  with geometry, but it is only a 6-year-old knows nothing of calculation. The problem is 
 *  described below:  
 *  N is defined level of a diamond shape formed entirely as shown:
 *  (ImageURL) http://coj.uci.cu/downloads/images/1676.jpg
 *  
 *  The N-Shape is formed by N*N single diamonds. Knowing this, calculate the amount of diamonds 
 *  present in an N-Shape. Could you help the little George?
 * 
 * Input specification:
 *  The input consists of several cases. Each case contains an integer N (0 < N <= 10^4) indicating 
 *  the level of the figure. The input ends when entering the value 0, this line should not be 
 *  processed.
 * 
 * Output specification: 
 *  The output will consist of several lines, two lines for each case: the first with the number of 
 *  the current case, and the second with the total number of diamonds for an N-Shape (N is the 
 *  given number of the current case). See the output example.
 * 
 * Sample input:
 *  1
 *  2
 *  0
 * 
 * Sample output:
 *  Case 1:
 *  n = 1, diamonds = 1
 *  Case 2:
 *  n = 2, diamonds = 5
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1676
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1676_LetUsHelpGeorge {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        short n = Short.parseShort(in.readLine());
        int c = 1;
        
        //Added memorization
        long[] values = new long[10001];
        values[0] = 1;

        while (n > 0) {
            out.write(String.format("Case %d:\n", c++));
            out.write(String.format("n = %d, diamonds = %d\n", n, getDiamonds(n, values)));
            n = Short.parseShort(in.readLine());
        }

        out.close();
        in.close();
    }

    private static long getDiamonds(short n, long[] values) {
        if (values[n] == 0) {
            for (int i = 1; i <= n; ++i) {
                values[i] = values[n] += i * i;
            }
        }
        return values[n];
    }
}