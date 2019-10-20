/**
 * Problem: 1840 - Broken Strings
 *
 * Description:
 *  Many security systems are based on character codes (passwords) provided by
 *  users. And this is the case of the company BWALL SECURE SYSTEMS, whose users
 *  have grown considerably. However, there is a security flaw in the last
 *  module released which is very worrying. A new virus called BROKEN, take
 *  advantage of specific characteristics of some passwords to access restricted
 *  data.
 *
 *  The password consist of a string consisting only of capital letters between
 * 'A' and 'Z'. If in this password are the same amount of letters 'B', 'R',
 * 'O', 'K', 'E' and 'N', then the password is not secure and the virus BROKEN
 *  may access and potentially destroy information of users. Can you develop a
 *  module that allows to check if a password is safe or not?
 *
 * Input specification:
 *  First line contains an integer 1 <= T <= 1000 which is the number of test
 *  cases. Following this T-cases exist. Each test case consist of an string of
 *  1 <= N <= 100 characters at most, on a line by itself denoting the password.
 *
 * Output specification:
 *  For each test case output a single line with one of the following two
 *  sentences:
 *   - "Secure" (no quotes) if the password selected is secure.
 *   - "No Secure" (no quotes) otherwise.
 *
 * Sample input:
 *  3
 *  PASSWORDSECURE
 *  BLUEWORKING
 *  SECUREWORD
 *
 * Sample output:
 *  Secure
 *  No Secure
 *  Secure
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1840
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1840_BrokenString {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    short t = Short.parseShort(in.readLine());
    while (t-- > 0) {
      String line = in.readLine();
      out.write(isSecure(line) ? "Secure\n" : "No Secure\n");
    }

    out.close();
    in.close();
  }

  private static short[] initializeLetters() {
    short[] letters = new short[26];
    // B            R            O               K           E
    letters[1] = letters[17] = letters[14] = letters[10] = letters[4] =
        // N
        letters[13] = 1;
    return letters;
  }

  private static boolean isSecure(String line) {
    short[] letters = initializeLetters();

    for (int i = 0; i < line.length(); i++) {
      --letters[line.charAt(i) - 65];
    }

    return !(letters[1] == letters[17] && letters[17] == letters[14] &&
             letters[14] == letters[10] && letters[10] == letters[4] &&
             letters[4] == letters[13]);
  }
}