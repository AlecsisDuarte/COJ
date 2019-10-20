
/**
 * Problem: 1070 - A Simple Calculation
 * 
 * Description:
 *  The next questions are classics of mathematics workshop. How many squares are in the N x N 
 *  chessboard squares? And, how many rectangles of any size?
 * 
 * Input specification:
 *  The input file consists of several lines. The line number i contains a single number 
 *  N [1 <= N <= 100] representing the size of the i-th chessboard.
 * 
 * Output specification: 
 *  The output file should contain the same number of lines as the input file. The i-th line should 
 *  contain two numbers separated by a blank space - the number of squares, and the number of 
 *  rectangles.
 * 
 * Sample input:
 *  1
 *  2
 *  3
 * 
 * Sample output:
 *  1 1
 *  5 9
 *  14 36
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1070
 */
import java.util.HashMap;
import java.util.Scanner;

public class _1070_ASimpleCalculation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Byte, Integer[]> values = createValuesMap();

        while (in.hasNext()) {
            byte n = Byte.parseByte(in.nextLine());
            Integer[] res = values.get(n);
            System.out.printf("%d %d\n", res[0], res[1]);
        }
        in.close();
    }

    //Algorithm create by finding the way squares and rectangles increase by size
    //We store all values possibilities ahead of time
    private static HashMap<Byte, Integer[]> createValuesMap() {
        HashMap<Byte, Integer[]> values = new HashMap<>();
        int sqrs = 0, inc = 1, tmpInc = 2;

        for (byte i = 1; i < 101; i++) {
            Integer[] vals = new Integer[2];
            //Squares are previous value plus current square
            sqrs += Math.pow(i, 2);
            vals[0] = sqrs;
            
            //The rectangles is a constant increment
            vals[1] = (int)Math.pow(inc, 2);
            inc += tmpInc;
            ++tmpInc;

            values.put(i, vals);
        }

        return values;
    }
}