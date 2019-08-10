/**
 * Problem: 2775 - LATIN
 *
 * Description:
 *  Cows have heard that pigs use a secret language called " Pig Latin " when they
 *  want to communicate, without the Farmer John is able to understand what they are
 *  saying. Thinking that this is an excellent idea , they invented their own
 *  version , appropriately called Latin Bovino.
 *  
 *  Convert a word in English to Latin Bovino is something simple. For words
 *  beginning with a vowel ('a' , 'e' , 'i' , 'o' or ' u' ) , "cow" is added to the
 *  end of the word ; eg "udder " becomes " uddercow " . For words that do not begin
 *  with a vowel , the first letter moves to the end of the word, and " ow" is added
 *  ; eg " farmer" becomes " armerfow " . Thus "the cows escape at dawn" becomes "
 *  hetow owscow escapecow atcow awdow " . Cows fervently believe that GJ will not
 *  understand this subterfuge .
 *  
 *  Cows have never been known as enthusiastic linguists , therefore they find this
 *  rather tedious translation and therefore ask you to write a program that will
 *  take individual words and translate them to Latin Bovino. They will give you N (
 *  1 < = N < = 100 ) to translate words ; word lengths are from 3 to 40 points .

 *
 * Input specification:
 *  Line 1:  A single integer: N
 *  Lines 2 .. N+1: One word per line.
 *
 * Output specification:
 *  Lines 1 .. N: Translations into Latin Bovino of the words given.
 *
 * Sample input:
 *  5
 *  udder
 *  farmer
 *  milk
 *  aaa
 *  zzz
 *
 * Sample output:
 *  uddercow
 *  armerfow
 *  ilkmow
 *  aaacow
 *  zzzow
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2775
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class _2775_Latin {
  private static HashSet<Character> VOWELS = new HashSet<Character>() {
    private static final long serialVersionUID = 1L;
    {
      add('a');
      add('e');
      add('i');
      add('o');
      add('u');
    }
  };

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(in.readLine());
    while (n-- > 0) {
      String english = in.readLine();
      out.write(toBovino(english));
    }

    in.close();
    out.close();
  }

  static String toBovino(String english) {
    StringBuilder bovino = new StringBuilder(english.length() + 4);
    if (VOWELS.contains(english.charAt(0))) {
      bovino.append(english).append("cow\n");
    } else {
      bovino.append(english.substring(1))
          .append(english.charAt(0))
          .append("ow\n");
    }
    return bovino.toString();
  }
}