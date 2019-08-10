/**
 * Problem: 3375 - Naebbirac Phrases
 *
 * Description:
 *  Naebbirac is excited due the contest of this weekend. He wants to fill the
 *  entire site with posters and phrases according to the event. For this reason
 *  Naebbirac hired a company for the task; he gave them all the phrases he needs
 *  and they deal with the process of filling the walls of the site with the phrases
 *  like one Graffiti.
 *  
 *  The problem is that the painter who was sent has a rare mental disorder called
 *  Incurable Change of Positions and Characters (ICPC); i.e. he could change some
 *  character of the phrase for other or even the same character, or he may
 *  interchange two characters on the phrase from their respective positions. After
 *  that, final phrases sometimes not even resemble to what is wanted; i.e. for
 *  "Welcome_Contestants" final phrase could be "We_are_fine_here_:)". What a crazy
 *  thing don´t you think, but at least we can know for sure that final phrase will
 *  have the same number of characters of the original phrase. Now Naebbirac wants
 *  to know how many positions have different characters for each phrase in order to
 *  correct them; i.e pairs of different characters sharing the same position.
 *  
 *  The task for you is to determine how many characters need to be corrected before
 *  the contest starts.
 *
 * Input specification:
 *  The first line of input contains an integer 1 <= T <= 100 denoting the number
 *  of test cases. T lines follow each one containing two single space-separated
 *  strings representing original and final phrases respectively. Phrases are
 *  non-empty and you can safely assume that all given phrases are composed by at
 *  most 100 consecutive characters without blank spaces.
 *
 * Output specification:
 *  For each case output a line with an integer representing how many characters
 *  needs to be corrected before the contest starting.
 *
 * Sample input:
 *  3
 *  Caribbean Naebbirac
 *  Welcome_Contestants We_are_fine_here_:)
 *  Bienvenidos_Concursantes Estamos_muy_bien_aqui_:)
 *
 * Sample output:
 *  6
 *  17
 *  23
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=3375
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3375_NaebbiracPhrases {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String line = in.readLine();
      int middle = line.length() / 2, toCorrect = 0;

      for (int i = 0; i < middle; i++) {
        if (line.charAt(i) != line.charAt(middle + i + 1)) {
          ++toCorrect;
        }
      }

      out.write(String.valueOf(toCorrect));
      out.newLine();
    }

    in.close();
    out.close();
  }
}