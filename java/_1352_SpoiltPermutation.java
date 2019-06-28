
/**
 * Problem: 1352 - Spoilt Permutation
 * 
 * Description:
 *  Vasya collects coins: he has exactly one coin for every year from 1 to n. Naturally, Vasya 
 *  keeps all the coins in his collection in the order in which they were released. Once Vasya's 
 *  younger brother made a change ? he took all the coins whose release year dated from l to r 
 *  inclusively and put them in the reverse order. That is, he took a certain segment [l, r] and 
 *  reversed it. At that the segment's endpoints did not coincide. For example, if n = 8, then 
 *  initially Vasya's coins were kept in the order 1 2 3 4 5 6 7 8. If Vasya's younger brother 
 *  chose the segment [2, 6], then after the reversal the coin order will change to 1 6 5 4 3 2 7 8. 
 *  Vasya suspects that someone else could have spoilt the permutation after his brother. Help him 
 *  to find that out. Check if the given permutation can be obtained from the permutation 1 2 ... n 
 *  using exactly one segment reversal. If it is possible, find the segment itself.
 * 
 * Input specification:
 *  Several test cases of two lines. The first line contains an integer n (1 <= n <= 1000) which is 
 *  the number of coins in Vasya's collection. The second line contains space-separated n integers 
 *  which are the spoilt sequence of coins. It is guaranteed that the given sequence is a 
 *  permutation, i.e. it contains only integers from 1 to n, and every number is used exactly 
 *  1 time. The input with n = 0 is the end of the input.

 * 
 * Output specification: 
 *  If it is impossible to obtain the given permutation from the original one in exactly one 
 *  action, print one line with 0 0. Otherwise, print two numbers l r (1 <= l < r <= n) which are 
 *  the endpoints of the segment that needs to be reversed to obtain from permutation 1 2 ... n 
 *  the given one.
 * 
 * Sample input:
 *  8
 *  1 6 5 4 3 2 7 8
 *  4
 *  2 3 4 1
 *  4
 *  1 2 3 4
 *  0
 * 
 * Sample output:
 *  2 6
 *  0 0
 *  0 0
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1352
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1352_SpoiltPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        short n = Short.parseShort(in.readLine());
        while (n > 0) {
            String[] values = in.readLine().split(" ");
            short[] coins = new short[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Short.parseShort(values[i]);
            }
            short[] segment = getReversedSegment(coins);
            out.write(String.format("%d %d\n", segment[0], segment[1]));
            n = Short.parseShort(in.readLine());
        }

        out.close();
        in.close();
    }

    private static short[] getReversedSegment(short[] coins) {
        short[] segment = new short[2];
        if (coins.length == 1) {
            return new short[] { 0, 0 };
        }

        short maxval = (short) coins.length;
        short minval = 1;
        for (int i = 0; i < coins.length; i++) {
            if (segment[0] == 0 && coins[i] != minval) {
                segment[0] = (short) (minval);
                if (segment[1] != 0) {
                    break;
                }
            }
            if (segment[1] == 0 && coins[maxval - 1] != maxval) {
                segment[1] = (short) (maxval);
                if (segment[0] != 0) {
                    break;
                }
            }
            ++minval;
            --maxval;
        }

        if (segment[0] != 0 && segment[1] != 0 && !isReversed(coins, segment[0] - 1, segment[1] - 1)) {
            return new short[] { 0, 0 };
        }
        return segment;
    }

    private static boolean isReversed(short[] arr, int from, int to) {
        for (int i = from; i < to; i++) {
            if (arr[i] - arr[i + 1] != 1) {
                return false;
            }
        }
        return true;
    }
}