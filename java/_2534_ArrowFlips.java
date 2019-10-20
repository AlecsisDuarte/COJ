import java.util.Iterator;
import java.util.Scanner;

public class _2534_ArrowFlips {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int k = in.nextInt();
            String line = in.nextLine();

            int max = maxRepeatedSymbols(k, line);

        }

        in.close();

    }

    static int maxRepeatedSymbols(int k, String line) {

        if (line.length() < 2) {
            return 0;
        }

        Stack<Value> reps = new Stack<>();
        char lastChar = line.charAt(1);
        reps.push(Value());

        for (int i = 2; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c != lastChar) {
                reps.push(Value());
            } else {
                reps.peek().reps++;
            }
        }

        return maxRepeatedSymbols(reps, k);
    }

    static int maxRepeatedSymbols(Stack<Value> reps, int k) {
        int size = reps.size();
        if (size == 1) {
            return reps.pop();
        }

        int odd = 0, even = 0, max = 0, from = 0, to = 0;

        do {
            int val = values.get(to).reps;

            if (odd > k && even > k) {
                if (from % 2 == 0) {
                    odd -= val;
                } else {
                    even -= val;
                }
            }

            if (to++ % 2 == 0) {
                even += values.get(curr);
            } else {
                odd += values.get(curr);
            }

        } while (size > curr);

        return max;

    }
}

class Value {
    int reps = 1;
}