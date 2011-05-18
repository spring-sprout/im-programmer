package candy.splitting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private int numberOfCases;
	private Scanner scanner;

	private Sean sean;

	public Main() {
		sean = new Sean();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.fileTest();
	}

	private void fileTest() {
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("C-small-attempt0.in");
			fw = new FileWriter("C-small.out");
			scanner = new Scanner(fr);
			numberOfCases = scanner.nextInt();

			for (int i = 0; i < numberOfCases; i++) {
				int n = scanner.nextInt();

				List<Integer> decimals = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					int c = scanner.nextInt();
					decimals.add(c);
				}
				String result = null;
				try {
					result = "" + sean.keep(decimals);
				} catch (RuntimeException e) {
					result = "NO";
				}
				fw.write("Case #" + (i + 1) + ": " + result + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
