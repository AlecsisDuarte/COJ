/**
 * Problem: 1740 - Another Palindrome Problem II
 *
 * Description:
 *  You are given a non-empty string S consisting of lowercase letters.
 *  You must find the number of pairs of non-overlapping palindromic substrings of S.
 *  This is, you have to find how many tuples (a, b, c, d) such that
 *  1 <= a <= b < c <= d <= |S| and substrings S[a... b], S[c... d] are palindromes.
 *  
 *  A substring S[i... j] (1 <= i <= j <= |S|) of string S = S1S2...S|S| is a string
 *  SiSi+1...Sj. For example, substring S[6...8] of string S = "palimdrome" equals
 *  "dro".
 *
 * Input specification:
 *  The only line of input contains a non-empty string S which consists of
 *  lowercase letters ('a'...'z'), S contains at most 2*10^3 characters.
 *
 * Output specification:
 *  Output a single number - the quantity of pairs of non-overlapping palindromic
 *  substrings of S.
 *
 * Sample input:
 *  abacaba
 *
 * Sample output:
 *  36
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1740
 * NOTE: Throws Wrong Answer with Test 9
 */
import java.util.Scanner;

public class _1740_AnotherPalindromeProblemII {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String line = in.nextLine();
    System.out.println(countPalindomes(line));
    in.close();
  }

  private static int countPalindomes(String line) {
    int n = line.length();
    boolean[][] palindromes = new boolean[n][n];

    for (int l = 1; l <= n; l++) {
      for (int i = 0; i <= n - l; i++) {
        int len = i + l - 1;
        if (l <= 2) {
          if (line.charAt(i) == line.charAt(len)) {
            palindromes[i][len] = true;
          }
        } else if (line.charAt(i) == line.charAt(len)) {
          palindromes[i][len] = palindromes[i + 1][i + l - 2];
        }
      }
    }

    return countPairs(palindromes, n);
  }

  private static int countPairs(boolean[][] palindromes, int n) {
    int[] left = new int[n], right = new int[n];

    left[0] = right[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (palindromes[j][i]) {
          ++left[i];
        }
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      right[i] = right[i + 1];

      for (int j = n - 1; j >= i; j--) {
        if (palindromes[i][j]) {
          right[i]++;
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
      ans += left[i] * right[i + 1];
    }
    return ans;
  }
}