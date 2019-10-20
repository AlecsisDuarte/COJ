
/**
 * Problem: 1064 - Alarm Clock
 * 
 * Description:
 *  Daniela is a nurse in a large hospital, which causes her working shifts to constantly change. 
 *  To make it worse, she has deep sleep, and a difficult time to wake up using alarm clocks. 
 *  Recently she got a digital clock as a gift, with several different options of alarm sounds, 
 *  and she has hope that it might help solve her problem. But, lately, she has been very tired and 
 *  want to enjoy every single moment of rest. So she carries her new clock to every place she goes, 
 *  and whenever she has some spare time, she tries to sleep, setting her alarm clock to the time 
 *  when she needs to wake up. But, with so much anxiety to sleep, she ends up with some difficulty 
 *  to fall asleep and enjoy some rest. A problem that has been tormenting her is to know how many 
 *  minutes of sleep she would have if she felt asleep immediately and woken up when the alarm 
 *  clock ringed. But she is not very good with numbers, and asked you for help to write a program 
 *  that, given the current time and the alarm time, find out the number of minutes she could sleep.
 * 
 * Input specification:
 *  The input contains several test cases. Each test case is described in one line, containing four 
 *  integers H1, M1, H2 and M2, with H1:M1 representing the current hour and minute, and H2:M2 
 *  representing the time (hour and minute) when the alarm clock is set to ring 
 *  (0 <= H1 <= 23, 0 <= M1 <= 59, 0 <= H2 <= 23, 0 <= M2 <= 59). The end of the input is 
 *  indicated by a line containing only four zeros, separated by blank spaces.
 * 
 * Output specification: 
 *  For each test case, your program must print one line, containing a single integer, indicating 
 *  the number of minutes Daniela has to sleep.
 * 
 * Sample input:
 *  1 5 3 5
 *  23 59 0 34
 *  21 33 21 10
 *  0 0 0 0
 * 
 * Sample output:
 *  120
 *  35
 *  1417
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1064
 */
import java.util.Scanner;

public class _1064_AlarmClock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("0 0 0 0")) {
            String[] values = line.split(" ");
            short h1 = Short.parseShort(values[0]);
            short m1 = Short.parseShort(values[1]);

            short h2 = Short.parseShort(values[2]);
            short m2 = Short.parseShort(values[3]);

            System.out.println(minutesOfSleep(h1, m1, h2, m2));
            line = in.nextLine();
        }
        in.close();
    }

    private static int minutesOfSleep(short h1, short m1, short h2, short m2) {
        int hours = 0;
        if (h1 > h2) {
            hours = 24 - h1 + h2;
        } else {
            hours = h2 - h1;
        }

        int minutes = m2 - m1;
        if (minutes < 0) {
            if (hours == 0) {
                return (24*60) + minutes;
            }
        }
        return (hours * 60) + minutes ;
    }
}