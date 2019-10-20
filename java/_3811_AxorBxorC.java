import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class _3811_AxorBxorC {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] values = in.readLine().split(" ");
    short n = Short.parseShort(values[0]);
    short x = Short.parseShort(values[1]);

    short[] l = new short[n];
    HashSet<Short> lset = new HashSet<Short>();
    
    values = in.readLine().split(" ");
    for (int i = 0;  i < n; i++) {
        l[i] = Short.parseShort(values[i]);
        
    }

    out.close();
    in.close();
  }
}