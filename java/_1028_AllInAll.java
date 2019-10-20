
/**
 * Problem: 1028 - All in All
 * 
 * Description:
 *  You have devised a new encryption technique which encodes a message by inserting between its 
 *  characters randomly generated strings in a clever way. Because of pending patent issues we will 
 *  not discuss in detail how the strings are generated and inserted into the original message. To 
 *  validate your method, however, it is necessary to write a program that checks if the message is 
 *  really encoded in the final string. Given two strings s and t, you have to decide whether s is 
 *  a subsequence of t; i.e. if you can remove characters from t such that the concatenation of 
 *  the remaining characters is s.
 * 
 * Input specification:
 *  The input contains multiple test cases (no more than 20). Each is specified by two strings (of 
 *  at most 30 characters) s, t of alphanumeric ASCII characters separated by white-space. Input is 
 *  terminated by EOF.
 * 
 * Output specification: 
 *  For each test case output, if s is a subsequence of t.
 * 
 * Sample input:
 *  sequence subsequence
 *  person compression
 *  VERDI vivaVittorioEmanueleReDiItalia
 *  caseDoesMatter CaseDoesMatter
 * 
 * Sample output:
 *  Yes
 *  No
 *  Yes
 *  No
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1028
 */
import java.util.Scanner;

public class _1028_AllInAll {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] words = in.nextLine().split(" ");
            System.out.println(isEncripted(words[0], words[1]) ? "Yes" : "No");
        }

        in.close();
    }

    private static boolean isEncripted(String original, String encripted) {
        int oIndex = 0, eIndex = 0;
        while (oIndex < original.length() && eIndex < encripted.length()) {
            if (encripted.charAt(eIndex) == original.charAt(oIndex)) {
                ++oIndex;
            }
            ++eIndex;
        }
        return oIndex == original.length();

    }
}