/**
 * Problem: 1290 - Bytelandian Gold Coins
 *
 * Description:
 *  Bytelandia have a strange coin system. Each gold coin in Bytelandia have an
 *  integer number printed. A coin with the value n can be changed at any bank in
 *  three coins with the values: n/2, n/3 and n/4. The only problem is that these
 *  numbers are rounded off (the banks have to make a profit). You can also sell
 *  gold coins for convertible pesos. The exchange rate is 1:1. But you can't buy
 *  gold coins. Taking a gold coin, what is the maximum amount of convertible
 *  pesos that can be obtained?
 *
 * Input specification:
 *  The entry consists of ten lines. Each line consists of a single integer 0 <= n
 *  <= 10^9. This integer represents the number written on the coin.
 *
 * Output specification:
 *  You must print ten lines, one for each line of input with the maximum number
 *  of convertible pesos that can be obtained.
 *
 * Sample input:
 *  2
 *  3
 *  4
 *  5
 *  6
 *  7
 *  8
 *  20
 *  70
 *  12
 *
 * Sample output:
 *  2
 *  3
 *  4
 *  5
 *  6
 *  7
 *  8
 *  21
 *  76
 *  13
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1290
 */
import java.util.HashMap;
import java.util.Scanner;

public class _1290_BytelandianGoldCoins {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    HashMap<Integer, Long> pesos = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      int coins = in.nextInt();
      System.out.println(getRealCoins(coins, pesos));
    }

    in.close();
  }

  private static Long getRealCoins(int n, HashMap<Integer, Long> pesos) {
    if (n == 0) {
      return 0L;
    }
    if (!pesos.containsKey(n)) {

      long calc = getRealCoins((int)Math.floor(n / 2), pesos) +
                  getRealCoins((int)Math.floor(n / 3), pesos) +
                  getRealCoins((int)Math.floor(n / 4), pesos);
      if (calc > n) {
        pesos.put(n, calc);
      } else {
        pesos.put(n, (long)n);
      }
    }
    return pesos.get(n);
  }
}