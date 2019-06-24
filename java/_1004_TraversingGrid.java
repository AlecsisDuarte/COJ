import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _1004_TraversingGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        short t = Short.parseShort(in.readLine());

        HashMap<String, Character> results = new HashMap<>();

        while (t-- > 0) {
            String line = in.readLine();
            String[] values = line.split(" ");

            int y = Integer.parseInt(values[0]);
            int x = Integer.parseInt(values[1]);

            Character res = results.get(line);
            if (res == null) {
                res = finalFacingDirection(x, y);
                results.put(line, res);
            }
            System.out.println(res);
        }
        in.close();
    }

    //Got this algorithm by maping al posible results of grids sized raging from [1...5]
    private static char finalFacingDirection(int x, int y) {
        int max = Math.max(x, y);
        
        //This is the max turns we can make if x == y
        long maxTurns = (max - 1L) * 2L;
        int min = 0;
        
        if (x < y) {
            x += 1;
            maxTurns -= 1;
            min = x;
        } else {
            min = y;
        }
        
        
        int diff = max - min;
        maxTurns -= (2L * diff);

        return getFacingDirection(maxTurns);
    }

    private static char getFacingDirection(long turns) {
        //We remove full spins if any
        turns %= 4;

        //As our max value could be we cast our long to an int for the switch
        int t = (int) (turns);

        switch (t) {
        case 1:
            return 'D';
        case 2:
            return 'L';
        case 3:
            return 'U';
        case 4:
        default:
            return 'R';

        }
    }
}