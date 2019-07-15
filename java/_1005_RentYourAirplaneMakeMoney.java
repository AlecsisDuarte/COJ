/**
 * Problem: 1005 - Rent your Airplane and make Money
 *
 * Description:
 *  "ABEAS Corp." is a very small company that owns a single airplane. The
 *  customers of ABEAS Corp are large airline companies which rent the airplane
 * to accommodate occasional overcapacity. Customers send renting orders that
 * consist of a time interval and a price that the customer is ready to pay for
 * renting the airplane during the given time period. Orders of all the
 * customers are known in advance. Of course, not all orders can be accommodated
 * and some orders have to be declined. Eugene LAWLER, the Chief Scientific
 * Officer of ABEAS Corp would like to maximise the profit of the company. You
 * are requested to compute an optimal solution.
 *
 *  Small Example: Consider the case where the company has 4 orders:
 *      -   Order 1 (start time 0, duration 5, price 10).
 *      -   Order 2 (start time 3, duration 7, price 8).
 *      -   Order 3 (start time 5, duration 9, price 7).
 *      -   Order 4 (start time 6, duration 9, price 8).
 *  The optimal solution consists in declining Order 2 and 3 and the gain is 10
 * + 8 = 18. Note that the solution made of Order 1 and 3 is feasible (the
 * airplane is rented with no interruption from time 0 to time 14) but
 * non-optimal.
 *
 * Input specification:
 *  The first line of the input contains a number T (1 <= T <= 30)
 *  that indicates the number of test cases to follow. The first line of each
 * test case contains the number of orders n (0 <= n <= 10000). In the following
 * n lines the orders are given. Each order is described by 3 integer values:
 * The start time of the order st (0 <= st < 10^6), the duration d of the order
 * (0 < d < 10^6), and the price p (0 < p < 10^5) the customer is ready to pay
 * for this order.
 *
 * Output specification:
 *  You are required to compute an optimal solution. For each test case your
 *  program has to write the total price paid by the airlines.
 *
 * Sample input:
 *  1
 *  4
 *  0 5 10
 *  3 7 14
 *  5 9 7
 *  6 9 8
 *
 * Sample output:
 *  18
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1005
 * REF: https://www.geeksforgeeks.org/weighted-job-scheduling/
 * REF(2): https://www.geeksforgeeks.org/weighted-job-scheduling-log-n-time/
 */
import java.util.Arrays;
import java.util.Scanner;

public class _1005_RentYourAirplaneMakeMoney {
  private static class Flight implements Comparable<Flight> {
    int start, end, price;

    Flight(int start, int duration, int price) {
      this.start = start;
      this.end = start + duration;
      this.price = price;
    }

    @Override
    public int compareTo(Flight f) {
      int res = Integer.compare(this.end, f.end);
      if (res == 0) {
        // In case there are 2 flights that end at the same time, sort by price
        // (max price)
        return Integer.compare(f.price, this.price);
      } else {
        return res;
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    byte t = Byte.parseByte(in.nextLine());
    while (t-- > 0) {
      short n = Short.parseShort(in.nextLine());
      Flight[] flights = new Flight[n];
      for (int i = 0; i < n; i++) {
        String[] vals = in.nextLine().split(" ");
        int st = Integer.parseInt(vals[0]), d = Integer.parseInt(vals[1]),
            p = Integer.parseInt(vals[2]);
        flights[i] = new Flight(st, d, p);
      }

      System.out.println(findMaximumProfit(flights, n));
    }

    in.close();
  }

  private static int findMaximumProfit(Flight[] flights, int n) {
    Arrays.sort(flights);

    int[] solutions = new int[n];
    solutions[0] = flights[0].price;

    for (int i = 1; i < n; i++) {
      int inclProf = flights[i].price;
      int nonConfFlight = nonConflictingBinarySearchFlight(flights, i);

      if (nonConfFlight != -1) {
        inclProf += solutions[nonConfFlight];
      }

      // We store the best solution for the current flight (including or
      // excluding)
      solutions[i] = Math.max(inclProf, solutions[i - 1]);
    }

    return solutions[n - 1];
  }

  /**
   * Binary Search the next flight that has no conflict with this flight
   * @param flights All flights
   * @param n Reference flight to search another non-conflicting flight
   * @return returns the other non-conflicting flight or -1 if no other flight
   *     was found
   */
  private static int nonConflictingBinarySearchFlight(Flight[] flights, int n) {
    int left = 0, right = n - 1;

    while (left <= right) {
      // We check if current flight(min) doesn't overlapp with the referenced
      // flight(n)
      int mid = (left + right) / 2;
      if (flights[mid].end <= flights[n].start) {
        // If current flight doesn't overlap we check if there is another flight
        // that doesn't overlap if there is we continue checking if not, we take
        // the current flight
        if (flights[mid + 1].end <= flights[n].start) {
          left = mid + 1;
        } else {
          return mid;
        }
      } else {
        // If we overlap we continua reducing the flights pool from the right
        right = mid - 1;
      }
    }

    // We return -1 if no non-conflight flight exists
    return -1;
  }
}