
/**
 * Problem: 1300 - Modulo
 * 
 * Description:
 *  Given two integers A and B, A modulo B is the remainder when dividing A by B. For example, the 
 *  numbers 7, 14, 27 and 38 become 1, 2, 0 and 2, modulo 3. Write a program that accepts 10 
 *  numbers as input and outputs the number of distinct numbers in the input, if the numbers are 
 *  considered modulo 42.
 * 
 * Input specification:
 *  The input will contain 10 non-negative integers, each smaller than 1000, one per line.
 * 
 * Output specification: 
 *  Output the number of distinct values when considered modulo 42 on a single line.
 * 
 * Sample input:
 *  39
 *  40
 *  41
 *  42
 *  43
 *  44
 *  82
 *  83
 *  84
 *  85
 * 
 * Sample output:
 *  6
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1300
 */
import java.util.HashSet;
import java.util.Scanner;

public class _1300_Modulo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<Integer> modules = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            Short n = Short.parseShort(in.nextLine());
            modules.add(n % 42);
        }
        System.out.println(modules.size());
        in.close();
    }
}