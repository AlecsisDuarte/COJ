/**
 * Problem: 2732 - Coco-Bits and the Coco-Strings
 *
 * Description:
 *  The Coco-Bits are fans of Coco-Strings. Coco-Strings have opposite sisters
 *  they have never met, Inverse-Coco-Strings. An Inverse-Coco-String is a
 *  Coco-String where all characters are opposed, regarding size, to its twin
 *  Coco-String sister.
 *  The Coco-Bits want you to help them find their opposite sisters.
 *
 * Input specification:
 *  A line representing the amount of Coco-Strings (1 <= CC <= 100). Each
 *  following line contains a Coco-String.
 *
 * Output specification:
 *  The corresponding Inverse-Coco-String.
 *
 * Sample input:
 *  3
 *  a
 *  BcD
 *  FeeU
 *
 * Sample output:
 *  A
 *  bCd
 *  fEEu
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2732
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2732_CocoBitsAndCocoStrings {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String cocoString = in.readLine();
      char[] inverseCocoString = new char[cocoString.length() + 1];
      int i = 0;
      for (; i < cocoString.length(); i++) {
        char c = cocoString.charAt(i);
        if (c > 96) {
          inverseCocoString[i] = (char)(c - 32);
        } else {
          inverseCocoString[i] = (char)(c + 32);
        }
      }

      inverseCocoString[i] = '\n';

      out.write(inverseCocoString);
    }

    in.close();
    out.close();
  }
}