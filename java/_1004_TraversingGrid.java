
/**
 * Problem: 1004 - Traversing Grid
 * 
 * Description:
 *  Starting at the top left corner of an N x M grid and facing towards the right, you keep walking 
 *  one square at a time in the direction you are facing. If you reach the boundary of the grid or 
 *  if the next square you are about to visit has already been visited, you turn right. You stop 
 *  when all the squares in the grid have been visited. What direction will you be facing when you 
 *  stop? For example: Consider the case with N = 3, M = 3. The path followed will be 
 *  (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (2,1) -> (2,0) -> (1,0) -> (1,1). 
 *  At this point, all squares have been visited, and you are facing right.
 * 
 * Input specification:
 *  The first line contains T the number of test cases. Each of the next T lines contain two 
 *  integers N and M, denoting the number of rows and columns respectively.
 *  1 <= T <= 5000, 
 *  1 <= N,M <= 10^9.
 * 
 * Output specification: 
 *  Output T lines, one for each test case, containing the required direction you will be facing at 
 *  the end. Output L for left, R for right, U for up, and D for down. 
 * 
 * Sample input:
 *  4
 *  1 1
 *  2 2
 *  3 1
 *  3 3
 * 
 * Sample output:
 *  R
 *  L
 *  D
 *  R
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1004
 */
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
        
        //if x < y we take one turn off and after that one we take 2 steps of
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