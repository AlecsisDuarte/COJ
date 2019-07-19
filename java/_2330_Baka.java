/**
 * Problem: 2300 - Baka
 *
 * Description:
 *  Mirko's grandma still uses an ancient pulse dial telephone with a rotary dial
 *  as shown in the following picture:
 *  
 *  For  each  digit  that  we  want  to  dial,  we  need  to  turn  the  rotary
 *  dial  clockwise  until  the  chosen  digit reaches  the finger  stop  (metal
 *  fin).  Then we  let  go  of  the  dial  and  wait  for  it  to  return  to  its
 *  original position  before  we  can dial  another  digit.  In  our  modern,
 *  instant  gratification  world,  the  dial  return often  lasts  much  longer
 *  than  our patience.  More  precisely,  dialling  the  digit  1  takes  a total
 *  of  two seconds,  while  dialling  any  larger  digit  takes  an additional
 *  second  for  each  additional  finger  circle counting from 1 to the dialled
 *  digit (as shown in the picture).
 *  
 *  Mirko's  grandma  remembers  phone  numbers  by  memorizing  a  corresponding
 *  word  which,  when dialled,  results  in the  correct  number  being  dialled.
 *  When  dialling  a  word,  for  each  letter,  we  dial  the digit which has that
 *  letter written next to it on the dial (for example, the digit 7 for  the letter
 *  S). For example, the word UNUCIC corresponds to the number 868242. Your task is
 *  determining, for a given word, the total time required to dial that word.
 *
 * Input specification:
 *  The  first  and  only  line  of  input  contains  a  single  word  consisting
 *  of between 2 and 15 (inclusive) uppercase English letters.
 *
 * Output specification:
 *The first and only line of output must contain the required dialling time.
 *
 * Sample input:
 *  UNUCIC
 *
 * Sample output:
 *  36
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2300
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2330_Baka {

  final static byte[] letters =
      new byte[] {3, 3, 3, 4, 4, 4, 5, 5, 5, 6,  6,  6,  7,
                  7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String line = in.readLine();
    int time = 0;

    for (int i = 0; i < line.length(); i++) {
      time += letters[line.charAt(i) - 'A'];
    }

    System.out.println(time);
    in.close();
  }
}