
/**
 * Problem: 1484 - Hotest Mountain
 * 
 * Description:
 *  Given the temperature of 1 <= N <= 100 mountains, you should simply find the hottest of them. 
 *  If two mountains have the same temperature, then you must chose the one which have the highest 
 *  position in the input (given last). Also simple, is not it?
 * 
 * Input specification:
 *  The first line of the input is N, the number of mountains for this problem. In each of the N 
 *  following lines, there are one real number T <= 1000, the N-th mountain temperature.
 * 
 * Output specification: 
 *  Print a single line with the number P, representing the position of the hottest mountain.
 * 
 * Sample input:
 *  7
 *  15.00
 *  35.54
 *  11.32
 *  11.32
 *  21.00
 *  15.00
 *  35.54
 * 
 * Sample output:
 *  7
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1484
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1484_HotestMountain {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        byte mountains = Byte.parseByte(in.readLine());
        
        int index = 0;
        float hottest = 0;
        for (int i = 0; i < mountains; i++) {
            float hotness = Float.parseFloat(in.readLine());
            if (hotness >= hottest) {
                hottest = hotness;
                index = i;
            }
        }
        out.write(String.valueOf(index + 1) + "\n");
        out.close();
        in.close();
    }
}