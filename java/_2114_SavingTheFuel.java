/**
 * Problem: 2144 - Saving the Fuel
 *
 * Description:
 *  Alexander is driver of load trucks. Alex has developed a surprising technique,
 *  to save fuel. Every day their boss indicates him a lot of N (0 < N < = 1000)
 *  sacks and how many D (0 < D < = N) sacks should he transfer toward the city, the
 *  boss also give to Alex the weight of each one of the N sacks (possible
 *  distints), and also the highway type C (regulate or irregular) in which Alex
 *  must travel.
 *  
 *  Alex will evaluate the highway type:
 *  - If the type is regulate then Alex take D sacks with total weight is the
 *  maximum possible.
 *  - If the type is irregular then Alex take D sacks with total weight is the
 *  minimum possible.
 *  
 *  Would you be able to be as intelligent as Alexander and to predict their
 *  behavior?
 *
 * Input specification:
 *  The first line will indicate the number of cases. In each case:
 *  The first line contain three values for N, D, and T (regulate or irregular)
 *  indicating the total number of existent sacks in the lot, the sacks that Alex
 *  should transport and the highway type in which Alex must travel respectively.
 *  The next line contain N space-separated values indicating the weight Pi (0 < Pi
 *  < = 1000) of each sack.
 *
 * Output specification:
 *  A line for each case indicating the total weight that Alexander will take
 *  toward the city.
 *
 * Sample input:
 *  3
 *  6 3 regulate
 *  2 4 3 5 6 1
 *  6 3 irregular
 *  2 4 3 5 6 1
 *  6 6 regulate
 *  2 4 3 5 6 1
 *
 * Sample output:
 *  15
 *  6
 *  21
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2144
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2114_SavingTheFuel {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String[] values = in.readLine().split(" ", 3);
      short n = Short.parseShort(values[0]);
      short d = Short.parseShort(values[1]);
      boolean regular = values[2].charAt(0) == 'r';

      values = in.readLine().split(" ", n);
      out.write(String.valueOf(weightToCarry(regular, values, n, d)));
      out.newLine();
    }

    out.close();
    in.close();
  }

  private static int weightToCarry(boolean regular, String[] weights, short n,
                                   short d) {
    int totalWeight = 0;
    if (d < n) {
      short[] arr = new short[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Short.parseShort(weights[i]);
      }
      Arrays.sort(arr);
      if (regular) {
        while (d-- > 0) {
          totalWeight += arr[--n];
        }
      } else {
        for (int i = 0; i < d; i++) {
          totalWeight += arr[i];
        }
      }
    } else {
      for (int i = 0; i < n; i++) {
        totalWeight += Short.parseShort(weights[i]);
      }
    }

    return totalWeight;
  }
}