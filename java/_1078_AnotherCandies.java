
/**
 * Problem: 1078 - Another Candies
 * 
 * Description:
 *  A class went to a school trip. And, as usually, all N kids have got their backpacks stuffed 
 *  with candy. But soon quarrels started all over the place, as some of the kids had more candies 
 *  than others. Soon, the teacher realized that he has to step in: "Everybody, listen! Put all 
 *  the candies you have on this table here!" Soon, there was quite a large heap of candies on the 
 *  teacher's table. "Now, I will divide the candies into N equal heaps and everyone will get one 
 *  of them." announced the teacher. "Wait, is this really possible?" wondered some of the smarter 
 *  kids. You are given the number of candies each child brought. Find out whether the teacher can 
 *  divide the candies into N exactly equal heaps. (For the purpose of this task, all candies are 
 *  of the same type.)

 * 
 * Input specification:
 *  The first line of the input file contains an integer T (no more than 25) specifying the number 
 *  of test cases. Each test case is preceded by a blank line. Each test case looks as follows: 
 *  The first line contains N - the number of children (no more than 30). Each of the next N lines 
 *  contains the number of candies one child brought.
 * 
 * Output specification: 
 *  For each of the test cases output a single line with a single word "YES" if the candies can be 
 *  distributed equally, or "NO" otherwise.
 * 
 * Sample input:
 *  2
 *  
 *  5
 *  5
 *  2
 *  7
 *  3
 *  8
 *  
 *  6
 *  7
 *  11
 *  2
 *  7
 *  3
 *  4
 * 
 * Sample output:
 *  YES
 *  NO
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1078
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1078_AnotherCandies {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        byte t = Byte.parseByte(in.readLine());
        while (t-- > 0) {
            in.readLine();
            byte children = Byte.parseByte(in.readLine());
            long totalCandies = 0;
            for (int i = 0; i < children; i++) {
                totalCandies += Long.parseLong(in.readLine());
            }
            out.write(children > 0 && totalCandies % children == 0? "YES\n" : "NO\n");
        }
        out.flush();
        out.close();
        in.close();
    }
}