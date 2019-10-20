
/**
 * Problem: 1535 - Lumberjack Sequencing
 * 
 * Description:
 *  Another tale of lumberjacks?. Let see...
 *  The lumberjacks are rude, bearded workers, while foremen tend to be bossy and simpleminded. The 
 *  foremen like to harass the lumberjacks by making them line up in groups of ten, ordered by the 
 *  length of their beards. The lumberjacks, being of different physical heights, vary their 
 *  arrangements to confuse the foremen. Therefore, the foremen must actually measure the beards in 
 *  centimeters to see if everyone is lined up in order. Your task is to write a program to assist 
 *  the foremen in determining whether or not the lumberjacks are lined up properly, either from 
 *  shortest to longest beard or from longest to shortest.
 * 
 * Input specification:
 *  The input starts with line containing a single integer N, 0 < N < 20, which is the number of 
 *  groups to process. Following this are N lines, each containing ten distinct positive integers 
 *  less than 100.
 * 
 * Output specification: 
 *  There is a title line, then one line per set of beard lengths. See the sample output for 
 *  capitalization and punctuation.
 * 
 * Sample input:
 *  3
 *  13 25 39 40 55 62 68 77 88 95
 *  88 62 77 20 40 10 99 56 45 36
 *  91 78 61 59 54 49 43 33 26 18
 * 
 * Sample output:
 *  Lumberjacks:
 *  Ordered
 *  Unordered
 *  Ordered
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1535
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1535_LumberjackSequencing {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        byte t = Byte.parseByte(in.readLine());
        out.write("Lumberjacks:\n");

        while (t-- > 0) {
            String[] values = in.readLine().split(" ");
            out.write(orderedLumberjacks(values) ? "Ordered\n" : "Unordered\n");
        }

        out.close();
        in.close();
    }

    private static boolean orderedLumberjacks(String[] values) {
        byte prev = Byte.parseByte(values[0]);
        byte next = Byte.parseByte(values[1]);

        boolean ascending = prev < next;

        for (int i = 2; i < values.length; i++) {
            prev = next;
            next = Byte.parseByte(values[i]);
            if (ascending) {
                if (prev > next) {
                    return false;
                }
            } else {
                if (prev < next) {
                    return false;
                }
            }
        }
        return true;
    }
}