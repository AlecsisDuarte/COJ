import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1006_CipheringPrograms {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String line;
    do {
      line = in.readLine();
      out.write(decrypt(line));
      out.newLine();
    } while (line.charAt(line.length() - 1) != '.');

    in.close();
    out.close();
  }

  private static char[] decrypt(String line) {
    char[] decrypt = new char[line.length()];
    for (int i = 0; i < decrypt.length; i++) {
      char c = line.charAt(i);
      if ((c > 64 && c <= 90) || (c > 97 && c <= 122)) {
        c = (char)(c - 1);
      } else if (c == 65) {
        c = 'Z';
      } else if (c == 97) {
        c = 'z';
      }
      decrypt[i] = c;
    }

    return decrypt;
  }

  //   private static String rearrange(String line) {
  //     char[] code = new char[line.length()];
  //     rearrange(line, 0, line.length() - 1, );
  //     return sb.toString();
  //   }

  private static void rearrange(String line, int from, int to,
                                StringBuilder sb) {
    int diff = to - from;
    if (diff == 0) {
      sb.append(line.charAt(from));
      return;
    } else if (diff == 1) {
      sb.append(line.charAt(from));
      sb.append(line.charAt(to));
      return;
    }

    int mid = from + (diff / 2);
    sb.append(line.charAt(mid));
    rearrange(line, from, mid - 1, sb);
    rearrange(line, mid + 1, to, sb);
  }
}

class Int {
  private int index;

  Int(int index) { this.index = index; }

  int get() { return index; }

  void set(int index) { this.index = index; }
}

//:    ,bcfoJufhs;