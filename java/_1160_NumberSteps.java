import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1160_NumberSteps {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(in.readLine());
        
        while (n-- > 0) {
            String[] line = in.readLine().split(" ");
            short x = Short.parseShort(line[0]);
            short y = Short.parseShort(line[1]);
            out.write(getNumber(x, y) + "\n");
        }

        out.flush();
        out.close();
        in.close();
    }

    private static String getNumber(short x, short y) {
        if (x == y || x == y + 2) {
            return String.valueOf(calculateNumberTwo(x, y));
        }
        return "No Number";
    }

    //Algorithm calculated by finding the patter in the table
    private static int calculateNumber(int x, int y) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }
        int val = x / 2;
        int ones = x % 2 == 0 ? val - 1 : val;
        int minus = x == y ? 0 : 2;
        return (val * 3) + (ones) - minus + 1;
    }

    //It always is the sum of x and y only if x is odd we substract 1
    private static int calculateNumberTwo(int x, int y) { 
        return x + y - (x % 2);
    }
}