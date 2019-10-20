
/**
 * Problem: 1684 - Binary to Roman
 * 
 * Description:
 *  Lucky is a hacker who is trying to enter in a server system. He realizes that servers do not 
 *  work with binary numbers, instead of that, the server use an model never seen that works with 
 *  roman numbers. All programs created by Lucky are binary, it asks you to help make a program 
 *  that given a number N of binary numbers make it into roman numerals.
 * 
 * Input specification:
 *  In the first line an integer N represents the number of test cases. Then follow N lines, each 
 *  of which contains a binary number. The number making up the binary will be in a range between 
 *  1 and 111110100000.
 * 
 * Output specification: 
 *  The output consists of N lines, each line will be a roman numeral whose binary equivalent is 
 *  the number given.
 * 
 * Sample input:
 *  3
 *  10
 *  1110
 *  1111111
 * 
 * Sample output:
 *  II
 *  XIV
 *  CXXVII
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1684
 */
import java.util.HashMap;
import java.util.Scanner;

public class _1684_BinaryToRoman {
    static HashMap<Integer, String> ROMANS = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;

        {
            put(1, "I");
            put(5, "V");

            put(9, "IX");
            put(10, "X");
            put(50, "L");

            put(90, "XC");
            put(100, "C");
            put(500, "D");

            put(900, "CM");
            put(1000, "M");
        }
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {
            String bin = in.nextLine();
            System.out.println(binToRoman(bin));
        }
        in.close();
    }

    private static short binToDec(String bin) {
        short val = 1;
        short res = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (bin.charAt(i) == '1') {
                res += val;
            }
            val *= 2;
        }

        return res;

    }

    private static String binToRoman(String bin) {
        short dec = binToDec(bin);
        int div = 1000;
        int next = 2;
        StringBuilder sb = new StringBuilder();

        while (dec > 0) {
            int firstDigits = (dec / 10) * 10;
            if (ROMANS.containsKey(firstDigits)) {
                sb.append(ROMANS.get(firstDigits));
                dec -= firstDigits;
            } else if (ROMANS.containsKey((int)dec)) {
                sb.append(ROMANS.get((int)dec));
                break;
            } else {
                int rep = dec / div;
                dec %= div;

                //If rep == 4 instead of IIII we write IV
                //else we just write III
                if (div != 1000 && rep > 3) {
                    sb.append(ROMANS.get(div));
                    sb.append(ROMANS.get(div * (next == 2 ? 5 : 2)));
                } else {
                    while (rep-- > 0) sb.append(ROMANS.get(div));
                }
            }
            div /= next;
            next = next == 2 ? 5 : 2;
        }

        return sb.toString();
    }
}