/**
 * Problem: 2344 - Encountering the Medal Table
 *
 * Description:
 *  In Olympics a medal table is a way to know the most prolific countries in
 *  sports. It shows the number of gold, silver and bronze medals earned by athletes
 *  representing each country. The convention used is to put at the top the country
 *  with the biggest number of gold medals, if a tie occurs then the number of
 *  silver medals is taken into consideration, if the tie continues then the number
 *  of bronze medals is taken into consideration.
 *  
 *  Given a list of countries and the earned medals by each one, output the medal
 *  table using the criteria discussed above.
 *
 * Input specification:
 *  Input consists of several test cases (but no more than 50). Test cases are
 *  separated by a @. A test case is a list of at most 25 countries consisting of n
 *  g s b each separated by one space. Where: n is the country’s name; less than 64
 *  characters and no whitespace. g is an integer between 0 and 10^6 indicating the
 *  number of gold medals. s is an integer between 0 and 10^6 indicating the number
 *  of silver medals. b is an integer between 0 and 10^6 indicating the number of
 *  bronze medals. There are no empty lines and input ends with the # character.
 *
 * Output specification:
 *  Output the medal table, if there are two or more countries with the same
 *  medal count order them alphabetically. Print a @ between test cases.
 *
 * Sample input:
 *  USA 34 20 13
 *  Mexico 1 1 4
 *  China 28 14 19
 *  Argentina 0 1 1
 *  @
 *  USA 34 20 13
 *  Mexico 1 1 4
 *  China 28 14 19
 *  Argentina 0 1 1
 *  Brazil 4 0 13
 *  Rusia 28 14 19
 *  #
 *
 * Sample output:
 *  USA
 *  China
 *  Mexico
 *  Argentina
 *  @
 *  USA
 *  China
 *  Rusia
 *  Brazil
 *  Mexico
 *  Argentina
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2344
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class _2344_EncounteringTheMedalTable {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = in.readLine();
    while (!line.equals("#")) {
      ArrayList<Country> countries = new ArrayList<>();

      while (!line.equals("@") && !line.equals("#")) {
        Country c = new Country(line);
        countries.add(c);
        line = in.readLine();
      }

      Collections.sort(countries);
      for (int i = 0; i < countries.size(); i++) {
        out.write((countries.get(i).name));
        out.newLine();
      }

      if (line.equals("@")) {
        out.write("@\n");
        line = in.readLine();
      }
    }

    in.close();
    out.close();
  }
}

class Country implements Comparable<Country> {
  String name;
  int gold, silver, bronze;

  Country(String line) {
    String[] values = line.split(" ", 4);
    this.name = values[0];
    this.gold = Integer.parseInt(values[1]);
    this.silver = Integer.parseInt(values[2]);
    this.bronze = Integer.parseInt(values[3]);
  }

  @Override
  public int compareTo(Country o) {
    if (this.gold > o.gold) {
      return -1;
    } else if (this.gold < o.gold) {
      return 1;
    }

    if (this.silver > o.silver) {
      return -1;
    } else if (this.silver < o.silver) {
      return 1;
    }

    if (this.bronze > o.bronze) {
      return -1;
    } else if (this.bronze < o.bronze) {
      return 1;
    }
    return this.name.compareTo(o.name);
  }
}