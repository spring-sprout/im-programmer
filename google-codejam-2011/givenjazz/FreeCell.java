import java.util.Scanner;

public class FreeCell {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int num = 1; num <= t; num++) {
			double n = sc.nextDouble();
			int pd = sc.nextInt();
			int pg = sc.nextInt();

			Fraction frac = getFraction(pd, n);
			if (frac == null) {
				System.out.println("Case #" + num + ": Broken");
			} else {
				if (pg == 100 && pd == 100) {
					System.out.println("Case #" + num + ": Possible");
				} else if (pd > 0 && pg == 0) {
					System.out.println("Case #" + num + ": Broken");
				} else if (pg < 100) {
					System.out.println("Case #" + num + ": Possible");
				} else {
					System.out.println("Case #" + num + ": Broken");
				}
			}
		}
	}

	private static Fraction getFraction(int pd, double n) {
		n = Math.min(100, n);
		for (int den = 1; den <= n; den++) {
			for (int num = 0; num <= den; num++) {
				if (num * 100 % den == 0 && num * 100 / den == pd) {
					return new Fraction(num, den);
				}
			}
		}
		return null;
	}

}

class Fraction {
	int numerator;
	int denominator;

	Fraction(int num, int den) {
		numerator = num;
		denominator = den;
	}
}
