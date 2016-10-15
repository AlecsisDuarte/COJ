import java.util.Scanner;

public class Div5 {
	public static void main(String[] args) {
		Scanner tcl = new Scanner(System.in);
		byte t = tcl.nextByte();
		while (t > 0) {
			t--;
			String linea = tcl.next();
			byte m = (byte)Character.getNumericValue(linea.charAt(linea.length() - 1));
			if(m == 5 || m == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		tcl.close();
	}
}
