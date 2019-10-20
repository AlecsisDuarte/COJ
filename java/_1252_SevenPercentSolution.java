
/**
 * Problem: 1252 - The Seven Percent Solution
 * 
 * Description:
 *  Uniform Resource Identifiers (or URIs) are strings like http://icpc.baylor.edu/icpc/, 
 *  mailto:foo@bar.org, ftp://127.0.0.1/pub/linux, or even just readme.txt that are used to 
 *  identify a resource, usually on the Internet or a local computer. Certain characters are 
 *  reserved within URIs, and if a reserved character is part of an identifier then it must be 
 *  percent-encoded by replacing it with a percent sign followed by two hexadecimal digits 
 *  representing the ASCII code of the character. A table of seven reserved characters and their 
 *  encodings is shown below. Your job is to write a program that can percent-encode a string of 
 *  characters.
 *          Character               Encoding
 *      " " (space)	                  %20
 *      "!" (exclamation point)	      %21
 *      "$" (dollar sign)	          %24
 *      "%" (percent sign)	          %25
 *      "(" (left parenthesis)	      %28
 *      ")" (right parenthesis)	      %29
 *      "*" (asterisk)	              %2a
 * 
 * Input specification:
 *  The input consists of one or more strings, each 1-79 characters long and on a line by itself, 
 *  followed by a line containing only "#" that signals the end of the input. The character "#" is 
 *  used only as an end-of-input marker and will not appear anywhere else in the input. A string may 
 *  contain spaces, but not at the beginning or end of the string, and there will never be two or 
 *  more consecutive spaces.
 * 
 * Output specification: 
 *  For each input string, replace every occurrence of a reserved character in the table above by 
 *  its percent-encoding, exactly as shown, and output the resulting string on a line by itself. 
 *  Note that the percent-encoding for an asterisk is %2a (with a lowercase "a") rather than %2A 
 *  (with an uppercase "A").
 * 
 * Sample input:
 *  Happy Joy Joy!
 *  http://icpc.baylor.edu/icpc/
 *  plain_vanilla
 *  (**)
 *\ ?
 *  the 7% solution
 *  #
 * 
 * Sample output:
 *  Happy%20Joy%20Joy%21
 *  http://icpc.baylor.edu/icpc/
 *  plain_vanilla
 *  %28%2a%2a%29
 *\ ?
 *  the%207%25%20solution
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1252
 */
import java.util.HashMap;
import java.util.Scanner;

public class _1252_SevenPercentSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, String> replacer = new HashMap<Character,String>() {
            private static final long serialVersionUID = 1L;
            {
                put(' ', "%20");
                put('!', "%21");
                put('$', "%24");
                put('%', "%25");
                put('(', "%28");
                put(')', "%29");
                put('*', "%2a");
            }
        };

        String line = in.nextLine();

        while (!line.equals("#")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                String res = replacer.get(line.charAt(i));
                sb.append( res == null ? line.charAt(i) : res);
            }
            System.out.println(sb.toString());
            line = in.nextLine();
        }

        in.close();
    }

}