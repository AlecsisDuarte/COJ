
/**
 * Problem: 1774 - Capitalization
 * 
 * Description:
 *  The Caps Lock is a computer keyboard key which enable (and disable) an input mode in which 
 *  typed letters are capital by default. If this key is pressed by accident, then you can write 
 *  words of undesirable ways.
 *  Then, let's consider that a word has not been typed with the Caps Lock key accidentally switched
 *  on, if:
 *   - the word only contains lowercase letters.
 *   - or all letters except for the first one are lowercase.
 *  In all other cases we should automatically change the case of all letters. For example, the 
 *  case of the letters that form words "gOOD" and "SMS" should be changed.
 *  
 *  Write a program that applies the rule mentioned above. If the word has not been typed with the 
 *  Caps Lock key accidentally switched on, the rule cannot be applied, and the program should leave 
 *  the word unchanged.
 * 
 * Input specification:
 *  The first line of the input data contains a word consisting of uppercase and lowercase Latin 
 *  letters, with length between 1 to 100 characters, inclusive.
 * 
 * Output specification: 
 *  The result of the given word, after the program processing.
 * 
 * Sample input:
 *  hELLO
 * 
 * Sample output:
 *  Hello
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1774
 */
import java.util.Scanner;

public class _1774_Capitalization {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();

        fixCapitalization(word);
        in.close();
    }

    private static void fixCapitalization(String word) {
        char[] changed = new char[word.length()];

        //Discard first letter as a way to tell if it was accident or not
        changed[0] = isUpper(word.charAt(0)) ? toLower(word.charAt(0)) :  toUpper(word.charAt(0));
        
        boolean accident = false;
        for (int i = 1; i < changed.length; i++) {
            char c = word.charAt(i);
            if (isUpper(c)) {
                accident = true;
                changed[i] = toLower(c);
            } else {
                changed[i] = toUpper(c);
            }
        }

        if (accident) {
            System.out.println(changed);
        } else {
            System.out.println(word);
        }
    }

    private static char toUpper(char c) {
        return (char)(c - 32);
    }
    
    private static char toLower(char c) {
        return (char)(c + 32);
    }

    private static boolean isUpper(char c) {
        return c < 97;
    }
    
}