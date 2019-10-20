
/**
 * Problem: 2409 - Find the Heterochromatic Index
 * 
 * Description:
 *  Heterochromia is a rare feature on some animals and humans. It consists of having more than one 
 *  color on the eyes. Complete Heterochromia is a term used to describe a face where the left eye’s 
 *  color is entirely different from the right eye’s color. Siberian Huskies for example commonly 
 *  present this feature.
 *  Now Doctor Frank B. Tree is treating cats with this pattern (Heterochromatic Cats), he says the 
 *  more difference between the cat eyes’ color, the more aggressive the cat can turn. The Doctor 
 *  assigned each color a number 1 <= C <= 10^9, and for each cat he calculates the Heterochromatic 
 *  Index which is a positive integer equal to the difference between the left eye’s color and the 
 *  right eye’s color of a cat.
 *  Now the Doctor asks you to calculate the Heterochromatic Index for a given cat.
 * 
 * Input specification:
 *  On the first line a string 1 <= |S| <= 20 the name of the cat. On the second line two 
 *  space-separated integer numbers representing the color values of the left and right eyes of the 
 *  cat.
 * 
 * Output specification: 
 *  A single line containing the name of the cat followed by a space and the Heterochromatic Index 
 *  of the given cat.

 * 
 * Sample input:
 *  Anders
 *  13 83
 * 
 * Sample output:
 *  Anders 70
 * 
 * URL: http://coj.uci.cu/24h/problem.xhtml?pid=2409
 */
import java.util.Scanner;

public class _2409_FindHeterochromaticIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        String[] values = in.nextLine().split(" ");

        int leftEye = Integer.parseInt(values[0]);
        int rightEye = Integer.parseInt(values[1]);
        
        System.out.printf("%s %d\n", name, Math.abs(leftEye - rightEye));
        in.close();
    }
}