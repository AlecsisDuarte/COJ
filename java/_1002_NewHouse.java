
/**
 * Problem: 1002 - New house
 * 
 * Description:
 *  Johan wants to build a new house and he wants his house as large as it can.
 *  Given an N x N grid land, find the largest square size that fit in the free area.
 * 
 * Input specification:
 *  The first line of input contains an integer T (1 <= T <= 100), the number of test cases follow. 
 *  Each test case starts with an integer N <= 10 denoting the size of the grid land. The next N 
 *  lines each contains N characters. Each character be either '.' (free area) or '#' (obstacle). 
 *  Your house should be build on free area.
 * 
 * Output specification: 
 *  For each test case, output in a line the size of the largest square on free area.
 * 
 * Sample input:
 *  2
 *  10
 *  ..........
 *  .#####....
 *  ..#..###..
 *  ...##.....
 *  ...#..#...
 *  ...#...###
 *  ....######
 *  ..........
 *  ##########
 *  #########.
 *  5
 *  ##..#
 *  ....#
 *  .#..#
 *  ####.
 *  .#..#
 * 
 * Sample output:
 *  3
 *  2
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1002
 */
import java.util.Scanner;

public class _1002_NewHouse {
    static class Point {
        private int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void grow() {
            this.x = x + 1;
            this.y = y + 1;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        int getDifference(Point point) {
            return Math.abs(this.x - point.x);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte t = Byte.parseByte(in.nextLine());

        while (t-- > 0) {

            byte n = Byte.parseByte(in.nextLine());

            if (n < 0) {
                System.out.println('0');
                continue;
            }

            boolean[][] area = new boolean[n][n];

            for (int y = 0; y < n; y++) {
                String line = in.nextLine();
                for (int x = 0; x < n; x++) {
                    area[y][x] = line.charAt(x) == '.';
                }
            }

            System.out.println(largestSquare(area));
        }
        in.close();
    }

    private static short largestSquare(boolean[][] area) {
        short maxHouseArea = 0;
        int len = area.length;
        for (int y = 0; y < len - maxHouseArea; y++) {
            for (int x = 0; x < len - maxHouseArea; x++) {

                // If the start is not free we don't continue
                if (!area[y][x])
                    continue;

                Point start = new Point(x, y);
                Point finish = new Point(x + 1, y + 1);

                while (finish.getX() < len && finish.getY() < len && validArea(area, start, finish)) {
                    finish.grow();
                }

                short houseArea = (short) (finish.getDifference(start));
                if (houseArea > maxHouseArea) {
                    maxHouseArea = houseArea;
                }
            }
        }

        return maxHouseArea;
    }

    private static boolean validArea(boolean[][] area, Point start, Point finish) {
        short distance = (short) (finish.getDifference(start) + 1);

        // We start by validating that the opposite corner is free
        if (!area[finish.getY()][finish.getX()])
            return false;

        // We continue validating all along the sides, as the inner square, if any,
        // should've
        // been already verified
        while (--distance > 0) {
            if (!area[finish.getY() - distance][finish.getX()])
                return false;
            if (!area[finish.getY()][finish.getX() - distance])
                return false;
        }

        return true;
    }
}