import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2623_SuperEncryption {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = in.readLine();
    int len = line.length();
    int middle = (int)Math.ceil(len / 2f), index = 0, right = len - 1;
    // int left = middle;
    StringBuilder sb = new StringBuilder(line.substring(0, middle));
    out.write(sb.reverse().toString());

    sb = new StringBuilder(line.substring(middle));
    out.write(sb.reverse().toString());
    out.newLine();

    // char[] encrypted = new char[len + 1];

    // // We add the middle to left part
    // for (; index < middle; index++) {
    //   encrypted[index] = line.charAt(--left);
    // }

    // // We add the right to middle part
    // for (; index < len; index++) {
    //   encrypted[index] = line.charAt(right--);
    // }

    // encrypted[index] = '\n';

    // out.write(encrypted);

    in.close();
    out.close();
  }
}