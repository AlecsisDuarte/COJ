
/**
 * Problem: 1625 - Day of the Week
 * 
 * Description:
 *  Certain student is preparing to participate in an international competition of mental agility 
 *  in which one of the events will be calculating the day of the week corresponding to a given 
 *  date. Therefore the student needs a program to help in their training. Help him in this task.
 * 
 * Input specification:
 *  The input will consist of a first line with a number n, such that 1 <= n <= 100. Then n lines 
 *  each with a date in the format: 1984 JUNE 27 (Year, Month, Day). The date will be in the 
 *  range: 1800 JANUARY 1 - 2100 DECEMBER 31. Leap years must be taken into account. For instance, 
 *  1800 JANUARY 1 is WEDNESDAY.
 * 
 * Output specification: 
 *  The output will consist of n lines each with a day of the week for the date of the line i+1 
 *  input of the form:
 *  MONDAY
 *  TUESDAY
 *  WEDNESDAY
 *  THURSDAY
 *  FRIDAY
 *  SATURDAY
 *  SUNDAY

 * 
 * Sample input:
 *  3
 *  2011 NOVEMBER 21
 *  2006 OCTOBER 31
 *  1800 JANUARY 1
 * 
 * Sample output:
 *  MONDAY
 *  TUESDAY
 *  WEDNESDAY
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1625
 * REF: http://mathforum.org/dr.math/faq/faq.calendar.html
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class _1625_DayOfTheWeek {

    private static HashMap<Integer, String> DAY = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;
        {
            put(0, "SUNDAY\n");
            put(1, "MONDAY\n");
            put(2, "TUESDAY\n");
            put(3, "WEDNESDAY\n");
            put(4, "THURSDAY\n");
            put(5, "FRIDAY\n");
            put(6, "SATURDAY\n");
        }
    };

    private static HashMap<String, Integer> MONTH_VALUE = new HashMap<String, Integer>() {
        private static final long serialVersionUID = 2L;
        {
            put("JANUARY", 1);
            put("FEBRUARY", 4);
            put("MARCH", 4);
            put("APRIL", 0);
            put("MAY", 2);
            put("JUNE", 5);
            put("JULY", 0);
            put("AUGUST", 3);
            put("SEPTEMBER", 6);
            put("OCTOBER", 1);
            put("NOVEMBER", 4);
            put("DECEMBER", 6);
        }
    };

    private static HashMap<Integer, Integer> CENTURY_VALUE = new HashMap<Integer, Integer>() {
        private static final long serialVersionUID = 3L;

        {
            put(17, 4);
            put(18, 2);
            put(19, 0);
            put(20, 6);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        byte n = Byte.parseByte(in.readLine());
        while (n-- > 0) {
            String[] date = in.readLine().split(" ");
            out.write(getDayTwo(date));
        }
        out.close();
        in.close();
    }

    private static String getDayTwo(String[] date) {
        short year = Short.parseShort(date[0]);
        // last two digits of the year
        int d = year % 100;
        int val = d;

        // We divide by 4
        val /= 4;

        // Add the day of the month
        val += Integer.parseInt(date[2]);

        // Add month value
        val += MONTH_VALUE.get(date[1]);

        // Validate that current year is not leap year
        if (date[1] == "JANUARY" || date[1] == "FEBRUARY") {
            if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
                val -= 1;
            }
        }

        // We add years century value
        int c = year / 100;
        // We reduce the century by 4 each step
        while (c > 20)
            c -= 4;
        val += CENTURY_VALUE.get(c);

        // Add last two digits of the year
        val += d;

        int day = (val % 7) - 1;
        if (day == -1) {
            day = 6;
        }

        return DAY.get(day);

    }

}