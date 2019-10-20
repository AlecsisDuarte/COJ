
/**
 * Problem: 2620 - Aaaaaaah
 * 
 * Description:
 *  When the dentist attacks, the patient hurts and scream. Make a program that screams 
 *  proportionally to the damage received.
 * 
 * Input specification:
 *  A natural number r > 0  with the radius in millimeters of the instrument used by the dentist.
 * 
 * Output specification: 
 *  Your program shall scream Aaaaa...aaaah, where the number of 'a' it is exactly twice the 
 *  diameter of the instrument used by the dentist.
 * 
 * Sample input:
 *  3
 * 
 * Sample output:
 *  Aaaaaaaaaaaaah
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2620
 */
import java.util.Scanner;

public class _2620_Aaaaaaaah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        scream(r);
        in.close();
    }

    private static void scream(int r) {
        char[] scream = new char[r * 4 + 2];
        scream[0] = 'A';
        int i = 1;
        for (; i < scream.length - 1; i++) {
            scream[i] = 'a';
        }
        scream[i] = 'h';
        System.out.println(scream);
    }
}