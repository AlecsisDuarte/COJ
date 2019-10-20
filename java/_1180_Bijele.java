
/**
 * Problem: 1180 - Bijele
 * 
 * Description:
 *  Wilson has found an old chessboard and a set of pieces in his attic. Unfortunately, the set 
 *  contains only white pieces and, apparently, an incorrect number of them. A set of pieces should 
 *  contain:
 *   - One king
 *   - One queen
 *   - Two rooks
 *   - Two bishops
 *   - Two knights
 *   - Eight pawns
 *  Wilson would like to know how many pieces of each type he should add or remove to make a valid 
 *  set.
 * 
 * Input specification:
 *  The first line contains a number n, is the number of test cases. The input for each test case 
 *  consists of six integers on a single line, each between 0 and 10 (inclusive). The numbers are, 
 *  in order, the numbers of kings, queens, rooks, bishops, knights and pawns in the set found by 
 *  Wilson.
 * 
 * Output specification: 
 *  Output should consist of six integers on a single line: the number of pieces of each type 
 *  Wilson should add or remove. A positive value means Wilson needs to add pieces; a negative 
 *  value means Wilson needs to remove pieces.
 * 
 * Sample input:
 *  2
 *  0 1 2 2 2 7
 *  2 1 2 1 2 1
 * 
 * Sample output:
 *  1 0 0 0 0 1
 * -1 0 0 1 0 7
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1180
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1180_Bijele {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        final byte[] realBoard = new byte[] { 1, 1, 2, 2, 2, 8 };

        long t = Long.parseLong(in.readLine());
        while (t-- > 0) {
            String[] line = in.readLine().split(" ");
            int i = 0;
            for (; i < line.length - 1; i++) {
                short num = Short.parseShort(line[i]);
                out.write(String.valueOf(realBoard[i] - num));
                out.write(' ');
            }
            out.write(String.valueOf(realBoard[i] - Short.parseShort(line[i])));
            out.write('\n');
        }

        out.flush();
        out.close();
        in.close();
    }

}