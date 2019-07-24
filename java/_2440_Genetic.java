/**
 * Problem: 2440 - Genetic
 *
 * Description:
 *  Deoxyribonucleic acid (DNA) is a molecule that encodes the genetic
 *  instructions used in the development and functioning of all known living
 *  organisms and many viruses. Along with RNA and proteins, DNA is one of the three
 *  major macromolecules essential for all known forms of life. Genetic information
 *  is encoded as a sequence of nucleotides (guanine, adenine, thymine, and
 *  cytosine) recorded using the letters G, A, T, and C. Most DNA molecules are
 *  double-stranded helices, consisting of two long polymers of simple units called
 *  nucleotides, molecules with backbones made of alternating sugars (deoxyribose)
 *  and phosphate groups (related to phosphoric acid), with the nucleobases (G, A,
 *  T, C) attached to the sugars. DNA is well-suited for biological information
 *  storage, since the DNA backbone is resistant to cleavage and the double-stranded
 *  structure provides the molecule with a built-in duplicate of the encoded
 *  information.
 *  
 *  For clarity, let's say that a DNA chain can be written as a sequence of
 *  nucleobases, eg. "AGCCTC".
 *  
 *  Scientifics of UTP have hired you to accomplish the following task: given two
 *  chains of DNA, M and N, your job is to decide whether M could have been
 *  generated from N. A chain M can be generated from a chain N, if it is possible
 *  to obtain M just by adding zero or most nucleobases either to the left or right
 *  of chain N. Additionally, as UTP is obsessed with thymine, they say that in
 *  order for M to be generated from N, M must have at least one thymine.
 *
 * Input specification:
 *  The first line contains an integer T (1 <= T <= 1000) which specifies the
 *  number of test cases. Followed by T lines, each one contains two DNA chains M
 *  and N separated by a single space, both with no more than 60 nucleobases.
 *
 * Output specification:
 *  For each input case print the letter "Y" (quotes for clarity) if the string M
 *  can be generated from N, otherwise print "N" (quotes for clarity).

 *
 * Sample input:
 *  6
 *  AGACT AC
 *  AGACG AC
 *  ATTTTACA ACA
 *  ACAGGCT ACA
 *  T T
 *  T A
 *
 * Sample output:
 *  Y
 *  N
 *  Y
 *  Y
 *  Y
 *  N
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2440
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2440_Genetic {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String[] mn = in.readLine().split(" ", 2);
      out.write(mGeneratedFromNTwo(mn[0], mn[1]) ? "Y\n" : "N\n");
    }

    in.close();
    out.close();
  }

  //Manually searching T and N within M
  static boolean mGeneratedFromN(String m, String n) {

    if (n.length() > m.length()) {
      return false;
    }

    boolean hasThymine = false;
    boolean hasN = false;

    for (int i = 0; i < m.length(); i++) {
      if (!hasN) {
        int tmpI = i, j = 0;

        for (; j < n.length() && tmpI < m.length(); j++) {
          if (m.charAt(tmpI) == 'T') {
            hasThymine = true;
          }
          if (m.charAt(tmpI) != n.charAt(j)) {
            break;
          }
          ++tmpI;
        }
        if (j == n.length()) {
          hasN = true;
          i = tmpI - 1;
        }
      } else if (!hasThymine) {
        if (m.charAt(i) == 'T') {
          hasThymine = true;
        }
      } else {
        break;
      }
    }

    return hasThymine && hasN;
  }

  //Using String contains method
  static boolean mGeneratedFromNTwo(String m, String n) {
    if (n.length() > m.length()) {
      return false;
    }
    if (!m.contains("T")) {
      return false;
    }
    return m.contains(n);
  }
}