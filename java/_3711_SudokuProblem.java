/**
 * Problem: 3711 - Sudoku Problem
 *
 * Description:
 *  My friend Gerson loves to resolve sudokus. A sudoku is a numeric puzzle formed
 *  by a grid of n*n, divided in n grids of sqrt(n)*sqrt(n). Every row, column and
 *  grid must contain all the numbers from 1 to n, without repeat. Gerson can
 *  resolve 20 sudokus per day, the problem is that 19 of them are wrong. Can you
 *  make a program that given the solutions found by Gerson tell him if they are
 *  wrong or right?
 *
 * Input specification:
 *  The first line of input contains a integer t, the number of test cases. Each
 *  case begins with an integer n (1 <= n <= 25), it is guaranteed that n have an
 *  square root. This line is followed by n lines, each one with n numbers m_i,j
 *  separated by a blank space (1 <= m_i,j <= n, with 1 <= i, j <= n).
 *
 * Output specification:
 *  For each test case prints a single line with the word "yes" if the sudoku has
 *  been resolved correctly or "no" otherwise.
 *
 * Sample input:
 *  2
 *  4
 *  1 2 3 4
 *  3 4 1 2
 *  2 3 4 1
 *  4 1 2 3
 *  9
 *  1 2 3 4 5 6 7 8 9
 *  2 3 4 5 6 7 8 9 1
 *  3 4 5 6 7 8 9 1 2
 *  4 5 6 7 8 9 1 2 3
 *  5 6 7 8 9 1 2 3 4
 *  6 7 8 9 1 2 3 4 5
 *  7 8 9 1 2 3 4 5 6
 *  8 9 1 2 3 4 5 6 7
 *  9 1 2 3 4 5 6 7 8
 *
 * Sample output:
 *  yes
 *  no
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3711
 * NOTE: Returns wrong answer on test 1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class _3711_SudokuProblem {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(in.readLine()) + 1;
      int sqrt = (int)Math.sqrt(n - 1);

      int[][] board = new int[n][n];
      ArrayList<HashSet<Integer>> repeated = new ArrayList<HashSet<Integer>>(n);
      boolean diff = true;
      int index = -1;

      for (int y = 1; y < n; y++) {
        String[] values = in.readLine().split(" ");
        if ((y - 1) % sqrt != 0) {
          index -= sqrt;
        }
        for (int x = 1; x < n; x++) {
          board[y][x] = Byte.parseByte(values[x - 1]);
          if (diff) {
            if ((x - 1) % sqrt == 0) {
              index += 1;
              if (repeated.size() == index) {
                repeated.add(new HashSet<Integer>());
              }
            }
            if (!repeated.get(index).add(board[y][x])) {
              diff = false;
            }
          }
          board[y][x] +=
              board[y - 1][x] + board[y][x - 1] - board[y - 1][x - 1];
        }
      }

      out.write((diff ? isCorrect(board) ? "yes\n" : "no\n" : "no\n"));
    }

    out.close();
    in.close();
  }

  private static boolean isCorrect(int[][] board) {
    int total = 0;
    int n = board.length;
    int sqrt = (int)Math.sqrt(board.length);
    int maxsize = board.length - sqrt;

    while (n > 0) {
      total += n--;
    }

    for (int y = 1; y < maxsize; y += sqrt) {
      int y2 = y + sqrt - 1;
      for (int x = sqrt + 1; x < maxsize; x += sqrt) {
        int x2 = x + sqrt - 1;
        int sum = board[y2][x2] - board[y - 1][x2] - board[y2][x - 1];
        if (sum != total) {
          return false;
        }
      }
    }

    return true;
  }
}