/**
 * Problem: 2514 - Elo Calculator
 *
 * Description:
 *  The Elo rating system is a method for calculating the relative skill level of
 *  players in competitor-versus-competitor games such as chess. It is named after
 *  its creator Arpad Elo, a Hungarian-born American physics professor. The
 *  difference in the ratings between two players serves as a predictor of the
 *  outcome of a match. If two players with equal ratings play against each other,
 *  they are expected to score an equal number of wins. A player whose rating is 100
 *  points greater than his or her opponent’s is expected to score 64%, if the
 *  difference is 200 points the expected score for the stronger player is 76%.
 *  
 *  A player’s Elo rating is represented by an integer number, which increases or
 *  decreases based upon the outcome of games between rated players. After every
 *  game, the winning player takes points from the losing one. The total number of
 *  points gained or lost after a game is determined by the difference between the
 *  ratings of the winner and loser. In a series of games between a high-rated
 *  player and a low-rated player, the high-rated player is expected to score more
 *  wins. If the high-rated player wins, only a few rating points will be taken from
 *  the low-rated player. However, if the lower rated player scores an upset win,
 *  many rating points will be transferred. The lower rated player will also gain a
 *  few points from the higher rated player in the event of a draw. This makes the
 *  rating system self-correcting. A player whose rating is too low should, in the
 *  long run, do better than the rating system predicts, and thus gain rating points
 *  until the rating reflects the true playing strength.
 *  
 *  When a player competes in a tournament the quantity of expected score it is
 *  determined according to the level of the rest of the participants in the
 *  tournament. Supposing a player was expected to score We points but actually
 *  scored W points. The formula for updating his rating is R = Ra + K (W - We),
 *  where: 
 * 
 *   - R is the new rating. 
 *   - Ra is the rating before play in a tournament. 
 *   - K is an integer value that each player has. 
 * 
 *  Your task consists in finding the new rating of each player in a tournament.
 *
 * Input specification:
 *  The first line consists of two space-separated values S and N where S is one
 *  string representing the Tournament’s name and N is the number of players. The
 *  following N lines have the information about the players, one player per line.
 *  For each player, this data is the player’s last name L (string), an integer
 *  number with the rating (Ra, 1900 < Ra < 3000), two real values (W and We, 0 < W,
 *  We <= N) and an integer number K (1 <= K <= 30), all separated by single spaces.
 *  All strings have at most 30 characters, and there aren’t two players with the
 *  same last name.
 *
 * Output specification:
 *  - Line 1 has the format “Tournament: S” (without quotes) where S is the
 *      Tournament’s name. 
 *  - Line 2 has the format “Number of players: N” (without quotes) where N is the 
 *      number of players. 
 *  - Line 3 has the format “New ratings:” (without quotes). 
 *  - Lines 4…N+3 have the new ratings of each player, in the same order of the input. 
 *      Each line has the format “L R” (without quotes) where L is the player’s last 
 *      name and R his new rating. 
 *  - Line N+4 has the format “Media Elo: M” (without quotes) where M is the average 
 *      of the rating of all players, before Tournament. 
 * 
 *  All ratings of the output, including the average rating, are rounded
 *  to zero decimal places, i.e. rounded to the integer value.
 *
 * Sample input:
 *  Capablanca 5
 *  Delgado 2700 3.6 0.3 20
 *  Quesada 2639 2.6 2.7 20
 *  Gonzalez 2520 1.6 3.6 30
 *  Bruzon 2698 1.4 4.8 10
 *  Arencibia 2526 2.9 1.9 10
 *
 * Sample output:
 *  Tournament: Capablanca
 *  Number of players: 5
 *  New ratings:
 *  Delgado 2766
 *  Quesada 2637
 *  Gonzalez 2460
 *  Bruzon 2664
 *  Arencibia 2536
 *  Media Elo: 2617
 *
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2514
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2514_EloCalculator {
  public static void main(String[] args) throws IOException {
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] values = in.readLine().split(" ", 2);

    String tournament = values[0];
    int n = Integer.parseInt(values[1]);

    out.write(
        String.format("Tournament: %s\nNumber of players: %d\nNew ratings:\n",
                      tournament, n));

    float elo = 0;
    for (int i = 0; i < n; i++) {
      values = in.readLine().split(" ", 5);
      int ra = Integer.parseInt(values[1]), k = Integer.parseInt(values[4]);
      float w = Float.parseFloat(values[2]), we = Float.parseFloat(values[3]);

      float r = ra + k * (w - we);
      elo += ra;

      out.write(String.format("%s %.0f\n", values[0], r));
    }

    out.write(String.format("Media Elo: %.0f\n", elo / n));

    out.close();
    in.close();
  }
}