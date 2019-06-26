
/**
 * Problem: 
 * 
 * Description:
 *  For years, a group of Regional Contest Directors (RCDs) of the ACM International Collegiate 
 *  Programming Contest (ICPC) have been unsatisfied with the way contest submissions get ranked. 
 *  The group sees it is academically wrong to emphasize the importance of program correctness, 
 *  disregarding the ``quality" of the program itself. After all, programming as a profession 
 *  promotes design, style, maintainability, etc. and not just correctness. The group's suggestion 
 *  is to have a panel of six judges. Each judge is assigned the task of grading the submissions 
 *  based on a particular aspect: 1) Correctness; 2) Robustness; 3) Overall design; 4) Clarity; 
 *  5) Coding style; and finally 6) Maintainability. The final grade of a submission would be the 
 *  average of the six grades it gets. The old guards of the current ICPC judging style have always 
 *  responded that it is not possible to impartially judge a program on anything but correctness. 
 *  How can the ICPC be certain that judging is fair? In other words, how can the ICPC be sure that 
 *  non of the judges is favoring certain teams and disadvantaging others? Any hint of accusation 
 *  to the judging process and ICPC loses the prestigious status it worked on for years. (Alright! 
 *  So they do have a point.) Still, this hasn't stopped other domains from judging candidates 
 *  based on subjective metrics. Take for example Gymnastics, or The Nobel Prizes, or even the 
 *  ACM's very own Doctoral Dissertation Award. These are all highly respected awards where the 
 *  winner is selected by judges using subjective metrics. ICPC could use a new judging system 
 *  based on what is used in gymnastics. Rather than having each judge grade a certain aspect of 
 *  the program, each of the six judges would assign an overall grade (out of ten) based on all of 
 *  the six metrics mentioned above. To enforce impartiality, the final grade of a submission 
 *  would be calculated as the average of all the grades after deleting two grades: The highest 
 *  and the lowest. Any judge that favors a certain team (and assigns them an undeserved high 
 *  grade,) risks the possibility of that grade being dismissed. Similarly, any judge that attempts 
 *  to disadvantage a team by assigning them a low grade faces a similar risk. Write a program to 
 *  print the final grade of a submission.
 * 
 * Input specification:
 *  Your program will be tested on one or more test cases. Each test case is described on a single 
 *  input line listing the grades of the judges. The end of the test cases is identified with a 
 *  dummy test case with all the grades being zero.

 * 
 * Output specification: 
 *  For each test case, print the grade on a separate line (without unnecessary decimal points 
 *  and/or zeros.)

 * 
 * Sample input:
 *  8 8 8 4 4 4
 *  8 8 6 4 4 3
 *  0 0 0 0 0 0
 * 
 * Sample output:
 *  6 
 *  5.5
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1278
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class _1278_JudgingOlympia {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("#.##");

        String line = in.readLine();
        while (!line.equals("0 0 0 0 0 0")) {
            out.write(df.format(getGrade(line)) + '\n');
            line = in.readLine();
        }

        out.close();
        in.close();
    }

    private static float getGrade(String line) {
        byte min = 10, max = 0;
        byte total = 0;
        for (String grade : line.split(" ")) {
            byte num = Byte.parseByte(grade);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            total += num;
        }
        total -= (max + min);

        return total / 4F;
    }
}