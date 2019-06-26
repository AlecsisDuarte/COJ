
/**
 * Problem: 1071 - Bishops
 * 
 * Description:
 *  Yesterday was Sam's birthday. The most interesting gift was definitely the chessboard. Sam 
 *  quickly learned the rules of chess and defeated his father, all his friends, his little sister, 
 *  and now no one wants to play with him any more. So he decided to play with another birthday 
 *  gift - a Book of Math Problems for Young Mathematicians. He opened the book somewhere in the 
 *  middle and read the following problem: "How many knights can be placed on a chessboard without 
 *  threatening each other?" After a while he realized that this was trivial and moved on to the 
 *  next problem: "How many bishops can be placed on a chessboard without threatening each other?". 
 *  Sam is in trouble here. He is not able to solve this problem and needs your help. Sam's 
 *  chessboard has size N x N. A bishop can move to any distance in any of the four diagonal 
 *  directions. A bishop threatens another bishop if it can move to the other bishop's position. 
 *  Your task is to compute the maximum number of bishops that can be placed on a chessboard in 
 *  such a way that no two bishops threaten each other.
 * 
 * Input specification:
 *  The input file consists of several lines. The line number i contains a single number 
 *  1 <= N <= 10^100 representing the size of the i-th chessboard.
 * 
 * Output specification: 
 *  The output file should contain the same number of lines as the input file. The i-th line should 
 *  contain one number - the maximum number of bishops that can be placed on i-th chessboard 
 *  without threatening each other.
 * 
 * Sample input:
 *  1
 *  2
 *  3
 * 
 * Sample output:
 *  1
 *  2
 *  4
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=1071
 */
import java.math.BigInteger;
import java.util.Scanner;

public class _1071_Bishops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger two = new BigInteger("2");

        while (in.hasNext()) {
            String line = in.nextLine();
            System.out.println(getPossiblePlacements(line, two));
        }
        in.close();
    }

    private static String getPossiblePlacements(String line, BigInteger two) {
        if (line.equals("1")) {
            return "1";
        }
        return ((new BigInteger(line).subtract(BigInteger.ONE)).multiply(two)).toString();
    }
}