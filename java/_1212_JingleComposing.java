/**
 * Problem: 1212 - Jingle Composing
 *
 * Description:
 *  A. C. Marcos is taking his first steps in the direction of jingle composition.
 *  He is having some troubles, but at least he is achieving pleasant melodies and
 *  attractive rhythms. In music, a note has a pitch (its frequency, resulting in
 *  how high or low is the sound) and a duration (for how long the note should
 *  sound). In this problem we are interested only in the duration of the notes. A
 *  jingle is divided into a sequence of measures, and a measure is formed by a
 *  series of notes. The duration of a note is indicated by its shape. In this
 *  problem, we will use uppercase letters to indicate a note?s duration. The
 *  following table lists all the available notes:  The duration of a measure is
 *  the sum of the durations of its notes. In Marcos? jingles, each measure has the
 *  same duration. As Marcos is just a beginner, his famous teacher Johann
 *  Sebastian III taught him that the duration of a measure must always be 1. For
 *  example, Marcos wrote a composition containing five measures, of which the
 *  first four have the correct duration and the last one is wrong. In the example
 *  below, each measure is surrounded with slashes and each note is represented as
 *  in the table above.  Marcos likes computers as much as music. He wants you to
 *  write a program that determines, for each one of his compositions, how many
 *  measures have the right duration.
 *
 * Input specification:
 *  The input contains several test cases. Each test case is described in a single
 *  line containing a string whose length is between 3 and 200 characters,
 *  inclusive, representing a composition. A composition begins and ends with a
 *  slash "/". Measures in a composition are separated by a slash "/". Each note in
 *  a measure is represented by the corresponding uppercase letter, as described
 *  above. You may assume that each composition contains at least one measure and
 *  that each measure contains at least one note. All characters in the input will
 *  be either slashes or one of the seven uppercase letters used to represent
 *  notes, as described above. The last test case is followed by a line containing
 *  a single asterisk.
 *
 * Output specification:
 *  For each test case your program must output a single line, containing a single
 *  integer, the number of measures that have the right duration.
 *
 * Sample input:
 *  /HH/QQQQ/XXXTXTEQH/W/HW/
 *  /W/W/SQHES/
 *  /WE/TEX/THES/
 *  *
 *
 * Sample output:
 *  4
 *  3
 *  0
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1212
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class _1212_JingleComposing {
  private final static HashMap<Character, Integer> NOTES =
      new HashMap<Character, Integer>() {
        private static final long serialVersionUID = 1L;
        {
          put('W', 1000000); // (1000000/1)
          put('H', 500000);  // (1000000/2)
          put('Q', 250000);  // (1000000/4)
          put('E', 125000);  // (1000000/8)
          put('S', 62500);   // (1000000/16)
          put('T', 31250);   // (1000000/32)
          put('X', 15625);   // (1000000/64)
        }
      };

  private final static int MAX_DURATION = 1000000;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String composition = in.readLine();
    while (!composition.equals("*")) {
      out.write(String.valueOf(countRightDurations(composition)));
      out.newLine();

      composition = in.readLine();
    }

    in.close();
    out.close();
  }

  static int countRightDurations(String composition) {
    int count = 0;
    int duration = 0;
    for (int i = 1; i < composition.length(); i++) {
      char c = composition.charAt(i);
      if (c == '/') {
        if (duration == MAX_DURATION) {
          ++count;
        }
        duration = 0;
      } else {
        duration += NOTES.get(c);

        //If the duration is already beyong correct duration
        //we advance until next '/' in the composition
        if (duration > MAX_DURATION) {
          i = composition.indexOf('/', i);
          duration = 0;
        }
      }
    }

    return count;
  }
}