/**
 * Problem: 1242 - Digits Count
 *
 * Description:
 *  Diana is going to write a list of all positive integers between A and B,
 *  inclusive, in base 10 and without any leading zeros. She wants to know how
 *  many times each digit is going to be used.
 *
 * Input specification:
 *  Each test case is given in a single line that contains two integers A and B (1
 *  <= A <= B <= 108). The last test case is followed by a line containing two
 *  zeros.
 *
 * Output specification:
 *  For each test case output a single line with 10 integers representing the
 *  number of times each digit is used when writing all integers between A and B,
 *  inclusive, in base 10 and without leading zeros. Write the counter for each
 *  digit in increasing order from 0 to 9.
 *
 * Sample input:
 *  1 9
 *  12 321
 *  5987 6123
 *  12345678 12345679
 *  0 0
 *
 * Sample output:
 *  0 1 1 1 1 1 1 1 1 1
 *  61 169 163 83 61 61 61 61 61 61
 *  134 58 28 24 23 36 147 24 27 47
 *  0 2 2 2 2 2 2 2 1 1
 *
 * URL:http://coj.uci.cu/24h/problem.xhtml?pid=1242
 * REF: https://stackoverflow.com/questions/2059680/how-to-count-each-digit-in-a-range-of-integers
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1242_DigitsCount {
    private static class PrefixAndPower {
        int prefix = 0, power = 0;
    }

    public static void main(String[] firstrgs) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        while (!line.equals("0 0")) {
            String[] ranges = line.split(" ");
            int a = Integer.parseInt(ranges[0]);
            int b = Integer.parseInt(ranges[1]);
            
            int[] digits = getDigitsUse(a, b);

            out.write(join(digits));
            line = in.readLine();
        }
        out.flush();
        out.close();
        in.close();
    }

    private static String join(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length * 2);
        sb.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            sb.append(' ').append(arr[i]);
        }

        return sb.append('\n').toString();
    }


    private static int[] getDigitsUse(int first, int last) {
        int[] digits = new int[10];
        for (int number = first; number <= last; number++) {
            increaseDigits(digits, number, 1);

            //We check if current number has any leading zeros
            PrefixAndPower pnp = prefixAndPower(number);
            if (pnp.power > 0) {
                
                //We calculate how many nines are there (i.e., 1000 = 999)
                int nines = (int)(Math.pow(10, pnp.power) - 1);

                //Verify that if the number incremented by the sum of nines doesn't surpass
                //the las number
                if (number + nines <= last) {
                    increaseDigitsByPower(digits, pnp.power);

                    increaseDigits(digits, pnp.prefix, nines);

                    number += nines;
                }
            }
        
        }
        return digits;
    }

    /**
     * Increase the digits by the specified ammount every time such digit is
     * found in the specified number
     * @param digits array of digits (0-9) to increase
     * @param number number to iterate digit by digit
     * @param count value to increment the digits with
     */
    private static void increaseDigits(int[] digits, int number, int count) {
        while (number > 0) {
            digits[number % 10] += count;
            number /= 10;
        }
    }

    /**
     * We increase the digits depending on the power as these are the times the digits will
     * repeat for example from (1000 to 2000) and we substract the ammount the value of power
     * from the digit 0 (leading zeros formula)
     * @param digits reference to digits to increase
     * @param power power of the number (i.e., 1000 = 3 (3 zeros))
     */
    private static void increaseDigitsByPower(int[] digits, int power) {
        int increase = (int)(power * Math.pow(10, power-1));
        for (int i = 0; i < digits.length; i++) {
            digits[i] += increase;
        }
        digits[0] -= power;
    }

    /**
     * We get the prefix and power of the number, for example,
     * the number 132,100  would return a prefix of 1,321 and a power of 2 (2 zeros)
     * @param number Number to calculate
     * @return Prefix and power of the number
     */
    private static PrefixAndPower prefixAndPower(int number) {
        PrefixAndPower prefixAndPower = new PrefixAndPower();
        
        while (number > 0) {
            int digit = number % 10;
            if (digit != 0) {
                prefixAndPower.prefix = number;
                break;
            }
            number /= 10;
            ++prefixAndPower.power;
        }
        return prefixAndPower;
    }

}