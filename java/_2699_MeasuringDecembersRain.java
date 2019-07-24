/**
 * Problem: 2699 - Measuring December´s Rain
 *
 * Description:
 *  This year the December's rains have been something out of control in melman
 *  planet. Several milimeters of rains fell on each of the 31 days of the month.
 *  Scientists are concerned about unusual behaviors of the nature. They wondered
 *  what is the total amount of rain that has fallen this year, but for the moment
 *  they only need help for calculating the total amount of rain that has fallen in
 *  December.
 *  
 *  Currently they have the measuring of the first 30 days of December. The problem
 *  is that they forgot to measure the rain for December, 31. But don't worry about
 *  that, because young scientist Naebbirac comes with one idea for solving the
 *  problem. He defends the following idea: "the measuring for day 31 is equal to
 *  the average of the first 30 days". Can you help scientists with the task?
 *
 * Input specification:
 *  Exactly 30 lines. Each line contain a positive integer number no greater than
 *  1000, the amount of rain for the first 30 days of December.
 *
 * Output specification:
 *  A real number, the total amount of rain that has fallen in December. The
 *  number should be rounded up to three decimal places.
 *
 * Sample input:
 *  1
 *  2
 *  3
 *  5
 *  7
 *  11
 *  13
 *  17
 *  19
 *  23
 *  29
 *  4
 *  6
 *  8
 *  10
 *  12
 *  14
 *  16
 *  18
 *  20
 *  22
 *  24
 *  26
 *  28
 *  30
 *  9
 *  15
 *  21
 *  25
 *  27
 *
 * Sample output:
 *  480.500
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2699
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2699_MeasuringDecembersRain {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int days = 30;
    double totalRain = 0;

    for (int i = 0; i < days; i++) {
      totalRain += Float.parseFloat(in.readLine());
    }

    totalRain += totalRain / days;

    out.write(String.format("%.3f\n", totalRain));

    out.close();
    in.close();
  }
}