/**
 * Problem: 1307 - Chocolate Bars
 * 
 * Description:
 *  Jimmy left his younger brother Tyler in charge of the chocolate shop, and let him prohibited 
 *  not only sell; Tyler could not eat even a piece of some of the chocolates that he left there. 
 *  All the chocolate bars have the same lenght at the begining. Tyler loves chocolate and gets an 
 *  idea; perhaps in this way his brother can not know whether or not he ate of some chocolate bars. 
 *  Tyler does not sell any chocolate bar, he cut each bar into exactly two pieces not necessarily 
 *  of the same length. Then he can eat of one of the pieces and his brother can't easily determine 
 *  whether or not he ate of any chocolate bars. Knowing that tyler never eat of more than one 
 *  piece, can you help Jimmy to determine whether or not Tyler ate of any chocolate bars.
 * 
 * Input specification:
 *  The first line of the input havs a integer number T (1<=T<=10) specifying the number of test 
 *  cases. The next T lines will starts with a positive integer number 2 <= N <= 5000, the number 
 *  of chocolate bars that Jimmy have on the shop before he go out. Then follows a list of 2*N 
 *  numbers 1 <= Ni <= 999, with the lenght of final pieces of chocolate when Jimmy return (the 
 *  pieces are not given in any particular order).
 * 
 * Output specification: 
 *  For each test case, if Tyler ate of any chocolate bars, print a single line with YES else, 
 *  print NO.
 * 
 * Sample input:
 *  3
 *  5 9 8 7 6 5 5 1 2 3 4
 *  3 1 1 6 9 10 14
 *  2 5 5 5 5
 * 
 * Sample output:
 *  YES
 *  NO
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1307
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _1307_ChocolateBars {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        byte t = Byte.parseByte(in.readLine());
        while (t-- > 0) {
            String[] values = in.readLine().split(" ");
            short[] chocolates = new short[values.length - 1];
            for (int i = 1; i < values.length; i++) {
                chocolates[i - 1] = Short.parseShort(values[i]);
            }
            
            out.write(tylerAteAChocolate(chocolates) ? "YES\n" : "NO\n");
        }

        out.close();
        in.close();
    }

    private static boolean tylerAteAChocolate(short[] chocolates) {
        Arrays.sort(chocolates);
        int lastChocolateIndex = chocolates.length - 1;
        short size = (short)(chocolates[0] + chocolates[lastChocolateIndex]);
        for (int i = 1; i < chocolates.length / 2; i++ ) {
            if (chocolates[i] + chocolates[lastChocolateIndex - i] != size) {
                return true;
            }
        }

        return false;

    }

    
}