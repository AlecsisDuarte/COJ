
/**
 * Problem: 1181 - Bee
 * 
 * Description:
 *  In Africa there is a very special species of bee. Every year, the female bees of such species 
 *  give birth to one male bee, while the male bees give birth to one male bee and one female bee, 
 *  and then they die! Now scientists have accidentally found one "magical female bee" of such 
 *  special species to the effect that she is immortal, but still able to give birth once a year as 
 *  all the other female bees. The scientists would like to know how many bees there will be after 
 *  N years. Please write a program that helps them find the number of male bees and the total 
 *  number of all bees after N years.
 * 
 * Input specification:
 *  Each line of input contains an integer N (N ≥ 0). Input ends with a case where N = -1 (this 
 *  case should NOT be processed).
 * 
 * Output specification: 
 *  Each line of output should have two numbers, the first one being the number of male bees after 
 *  N years, and the second one being the total number of bees after N years. The two numbers will 
 *  not exceed 232.
 * 
 * Sample input:
 *  1
 *  3
 *  -1
 * 
 * Sample output:
 *  1 2
 *  4 7
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1181
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _1181_Bee {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Long> bees = getAllBees();
        String line = in.readLine();

        while (!line.equals("-1")) {
            short n = Short.parseShort(line);
            long males = bees.get(n);
            long total = bees.get(n + 1);
            out.write(String.format("%d %d\n", males, total));
            line = in.readLine();
        }
        out.flush();
        out.close();
        in.close();
        
    }

    private static ArrayList<Long> getAllBees() {
        long total = 0;
        long males = 0;
        long females = 1;

        ArrayList<Long> values = new ArrayList<>();
        while (total <= 4294967296L) {
            values.add(total);
            long tmpMales = males;
            males += females;
            females = tmpMales + 1L;
            total = males;
        }
        return values;
    }
}   