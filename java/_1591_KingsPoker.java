
/**
 * Problem: 1591 - King's Poker
 * 
 * Description:
 *  Poker is one of the most widely played card games, and King's Poker is one of its variations. 
 *  The game is played with a normal deck of 52 cards. Each card has one of 4 suits and one of 13 
 *  ranks. However, in King's Poker card suits are not relevant, while ranks are Ace (rank 1), 2, 
 *  3, 4, 5, 6, 7, 8, 9, 10, Jack (rank 11), Queen (rank 12) and King (rank 13). The name of the 
 *  game comes from the fact that in King's Poker, the King is the highest ranked card. But this 
 *  is not the only difference between regular Poker and King's Poker. Players of King's Poker are 
 *  dealt a hand of just three cards. There are three types of hands:
 *   - A set , made of three cards of the same rank.
 *   - A pair, which contains two cards of the same rank, with the other card  unmatched.
 *   - A no-pair, where no two cards have the same rank.
 * 
 *  Hands are ranked using the following rules:
 *   - Any set defeats any pair and any no-pair.
 *   - Any pair defeats any no-pair.
 *   - A set formed with higher ranked cards defeats any set formed with lower ranked cards.
 *   - If the matched cards of two pairs have different ranks, then the pair with the higher 
 *      ranked matched cards defeats the pair with the lower ranked matched cards.
 *   - If the matched cards of two pairs have the same rank, then the unmatched card of both hands 
 *      are compared; the pair with the higher ranked unmatched card defeats the pair with the 
 *      lower ranked unmatched card, unless both unmatched cards have the same rank, in which 
 *      case there is a tie.
 *  A new software house wants to offer King's Poker games in its on-line playing site, and needs a 
 *  piece of software that, given a hand of King's Poker, determines the set or pair with the 
 *  lowest rank that beats the given hand. Can you code it?
 * 
 * Input specification:
 *  Each test case is described using a single line. The line contains three integers A, B , and C 
 *  representing the ranks of the cards dealt in a hand (1 <= A, B, C <= 13). The last test case is 
 *  followed by a line containing three zeros.
 * 
 * Output specification: 
 *  For each test case output a single line. If there exists a set or a pair that beats the given 
 *  hand, write the lowest ranked such a hand. The beating hand must be written by specifying the 
 *  ranks of their cards, in non-decreasing order. If no set or pair beats the given hand, write 
 *  the character '*' (asterisk).
 * 
 * Sample input:
 *  1 1 1
 *  1 1 12
 *  1 1 13
 *  1 13 1
 *  10 13 10
 *  1 2 2
 *  13 13 13
 *  13 12 13
 *  12 12 12
 *  3 1 4
 *  1 5 9
 *  0 0 0
 * 
 * Sample output:
 *  2 2 2
 *  1 1 13
 *  1 2 2
 *  1 2 2
 *  1 11 11
 *  2 2 3
 *  *
 *  1 1 1
 *  13 13 13
 *  1 1 2
 *  1 1 2
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1591
 */
import java.util.Scanner;

public class _1591_KingsPoker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            byte a = in.nextByte(), b = in.nextByte(), c = in.nextByte();
            if (a == 0) {
                break;
            }
            System.out.println(beatingHand(new byte[] { a, b, c }));
        }

        in.close();
    }

    // TODO: Improve (reduce the if statements)
    private static String beatingHand(byte[] hand) {
        int same = 0;
        int max = hand[2];
        int min = hand[2];
        int repeated = 0;

        for (int i = 0; i < hand.length - 1; i++) {
            if (hand[i] > max) {
                max = hand[i];
            }
            if (hand[i] < min) {
                min = hand[i];
            }
            if (hand[i] == hand[i + 1]) {
                same++;
                repeated = hand[i];
            }
        }

        if (hand[0] == hand[2]) {
            ++same;
            repeated = hand[0];
        }

        switch (same) {
        case 0:
        default:
            return "1 1 2";
        case 1:
            if (max == repeated) {
                if (max == 13) {
                    if (min == 12) {
                        return "1 1 1";
                    } else {
                        ++min;
                        return String.format("%d %d %d", min, max, max);
                    }
                } else {
                    if (max > min + 1) {
                        ++min;
                        return String.format("%d %d %d", min, max, max);
                    } else if (min + 2 < 14) {
                        min += 2;
                        return String.format("%d %d %d", max, max, min);
                    } else {
                        ++max;
                        return String.format("%d %d %d", min, max, max);
                    }
                }
            } else {
                if (max == 13) {
                    ++min;
                    return String.format("%d %d %d", 1, min, min);
                } else {
                    ++max;
                    return String.format("%d %d %d", min, min, max);
                }
            }
        case 3:
            if (max == 13) {
                return "*";
            } else {
                ++max;
                return String.format("%d %d %d", max, max, max);
            }
        }
    }
}