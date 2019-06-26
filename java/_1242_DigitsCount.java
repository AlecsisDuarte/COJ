import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1242_DigitsCount {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        while (!line.equals("0 0")) {
            String[] ranges = line.split(" ");
            int a = Integer.parseInt(ranges[0]);
            int b = Integer.parseInt(ranges[1]);
            
            long start = System.nanoTime();
            int[] digits = getDigitsUse(a, b);
            long end = System.nanoTime();
            System.out.println("Time One: " + (end - start) / 1000);

            out.write(join(digits));
            line = in.readLine();
        }
        out.flush();
        out.close();
        in.close();
    }

    //Throws Time-out exception
    private static int[] getDigitsUse(int a, int b) {
        int[] digits = new int[10];
        
        for (int i = a; i <= b; i++) {
            int num = i;
            while (num > 0) {
                ++digits[num % 10];
                num /= 10;
            }
        }
        return digits;
    }

    private static String join(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        sb.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            sb.append(' ').append(arr[i]);
        }

        return sb.append('\n').toString();
    }

}