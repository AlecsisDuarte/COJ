import java.util.Scanner;

public class _3080_Numeracy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte t = Byte.parseByte(in.nextLine());
        while (t-- > 0) {
            byte fTerm = Byte.parseByte(in.nextLine());
            char op = in.nextLine().charAt(0);
            byte sTerm = Byte.parseByte(in.nextLine());
            in.nextLine(); // We don't need the equal symbol
            float res = Float.parseFloat(in.nextLine());
            System.out.println(correctResult(fTerm, sTerm, op, res) ? "Yes" : "No");
        }

        in.close();
    }

    private static boolean correctResult(byte fTer, byte sTer, char op, float res) {
        switch (op) {
        case '+':
            return res == fTer + sTer;
        case '-':
            return res == fTer - sTer;
        case '*':
            return res == fTer * (int) sTer;
        case '/':
            return sTer == 0 ? false : res == fTer / (float) sTer;
        default:
            return false;
        }
    }
}