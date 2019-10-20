/**
 * Problem: 2655 - AVION
 *
 * Description:
 *  Mirko and Slavko are USKOK agents tracking the movements of an unnamed corrupt
 *  government official. Anonymous sources have tipped them about his upcoming
 *  escape attempt. They now know he plans to use his diplomatic liaisons to try and
 *  hitch a ride on a CIA blimp leaving from Severin na Kupi blimp port.
 *  
 *  It’s common knowledge that all CIA blimps have the string “FBI” somewhere in
 *  their registration codes. They obtained a list of all blimps scheduled for the
 *  designated day. There are exactly 5 blimps on the list. Write a program that
 *  will point out all CIA blimps.
 *
 * Input specification:
 *  There are exactly 5 rows of input, each row representing one blimp
 *  registration code from the list. A registration code is a sequence of at most 10
 *  uppercase letters of the English alphabet, digits ‘0’ to ‘9’, or dashes ‘-’.
 *
 * Output specification:
 *  The first and only line of output must contain a space separated list of
 *  integers, sorted in increasing order, indicating the corresponding input rows
 *  containing registrations of CIA blimps.
 *  
 *  If there are no CIA blimps, output the string “HE GOT AWAY!”.
 *
 * Sample input:
 *  47-FBI
 *  BOND-007
 *  RF-FBI18
 *  MARICA-13
 *  13A-FBILL
 *
 * Sample output:
 *  1 3 5
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2655
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;

public class _2655_Avion {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder(5);
    int blimps = 5;
    char[] fbi = new char[] {'F', 'B', 'I'};
    // String fbiS = "FBI";

    for (int i = 1; i <= blimps; i++) {
      String blimp = in.readLine();

      // Search if blimp contains fbis with String method
      //   if (blimp.contains(fbiS)) {
      if (isFromFBI(blimp, fbi)) {
        sb.append(i);
        sb.append(' ');
      }
    }

    if (sb.length() > 0) {
      sb.deleteCharAt(sb.length() - 1);
      out.write(sb.toString());
      out.newLine();
    } else {
      out.write("HE GOT AWAY!\n");
    }

    out.close();
    in.close();
  }

  // Manually searches for FBI within the blimp code
  static boolean isFromFBI(String blimp, char[] fbi) {
    for (int j = 0; j <= blimp.length() - fbi.length; j++) {
      int index = 0, tmpJ = j;
      for (; index < fbi.length && tmpJ < blimp.length(); index++) {
        if (blimp.charAt(tmpJ++) != fbi[index]) {
          break;
        }
      }
      if (index == fbi.length) {
        return true;
      }
    }
    return false;
  }
}