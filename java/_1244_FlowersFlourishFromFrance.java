
/**
 * Problem: 1244 - Flowers Flourish from France
 * 
 * Description:
 *  Fiona has always loved poetry, and recently she discovered a fascinating poetical form. 
 *  Tautograms are a special case of alliteration, which is the occurrence of the same letter at 
 *  the beginning of adjacent words. In particular, a sentence is a tautogram if all of its words 
 *  start with the same letter. For instance, the following sentences are tautograms: ? Flowers 
 *  Flourish from France ? Sam Simmonds speaks softly ? Peter pIckEd pePPers ? truly tautograms 
 *  triumph Fiona wants to dazzle her boyfriend with a romantic letter full of this kind of 
 *  sentences. Please help Fiona to check if each sentence she wrote down is a tautogram or not.
 * 
 * Input specification:
 *  Each test case is given in a single line that contains a sentence. A sentence consists of a 
 *  sequence of at most 50 words separated by single spaces. A word is a sequence of at most 20 
 *  contiguous uppercase and lowercase letters from the English alphabet. A word contains at 
 *  least one letter and a sentence contains at least one word. The last test case is followed by a 
 *  line containing only a single character "*" (asterisk).
 * 
 * Output specification: 
 *  For each test case output a single line containing an uppercase "Y" if the sentence is a 
 *  tautogram, or an uppercase "N" otherwise.
 * 
 * Sample input:
 *  Flowers Flourish from France
 *  Sam Simmonds speaks softly
 *  Peter pIckEd pePPers
 *  truly tautograms triumph
 *  this is NOT a tautogram
 *  *
 * 
 * Sample output:
 *  Y
 *  Y
 *  Y
 *  Y
 *  N
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1244
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1244_FlowersFlourishFromFrance {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = in.readLine();
        while (line.charAt(0) != '*') {
            out.write(isTautogram(line) ? "Y\n" : "N\n");
            line = in.readLine();
        }
        out.close();
        in.close();
    }

    private static boolean isTautogram(String line) {
        String[] word = line.split(" ");
        char lowC, upperC;

        if (word[0].charAt(0) > 96) {
            lowC = word[0].charAt(0);
            upperC = (char)(word[0].charAt(0) - 32);
        } else {
            upperC = word[0].charAt(0);
            lowC = (char)(word[0].charAt(0) + 32);
        }

        for (int i = 1; i < word.length; i++) {
            if (word[i].charAt(0) != lowC && word[i].charAt(0) != upperC) {
                return false;
            }
        }
        return true;
    }
}