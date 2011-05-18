package bot.trust;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private int numberOfCases;
	private Scanner scanner;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.fileTest();
	}
	
	private void fileTest() {
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("A-small-attempt0.in");
			fw = new FileWriter("A-small.out");
			scanner = new Scanner(fr);
			numberOfCases = scanner.nextInt();

			for (int i = 0; i < numberOfCases; i++) {
				int n = scanner.nextInt();
				
				ArrayList<Command> oranges = null;
				ArrayList<Command> blues = null;
				
				oranges = new ArrayList<Command>();
				blues = new ArrayList<Command>();
				
				for (int j = 0; j < n; j++) {
					String r = scanner.next();
					int p = scanner.nextInt();
					if (r.equals("O")) {
						oranges.add(new Command(j, p));
					} else if(r.equals("B")) {
						blues.add(new Command(j, p));
					} else {
						throw new RuntimeException();
					}
					
				}
				int result = minimumNumberOfSeconds(oranges, blues, n);
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

	private int minimumNumberOfSeconds(ArrayList<Command> oranges, ArrayList<Command> blues, int n) {
//		current position
		int o = 1;
		int b = 1;
		
		for (int sec=1;; sec++) {
			
			Command orange = null;
			if (oranges.size() != 0) {
				orange = oranges.get(0);
			}
			
			Command blue = null;
			if(blues.size() != 0) {
				blue = blues.get(0);
			}
			
			if (orange != null) {
				if (orange.getButtonPosition() > o) {
					o++;
				} else if(orange.getButtonPosition() < o) {
					o--;
				} else {	// orange.getButtonPosition() == o
					if (blue == null || orange.getSeq() < blue.getSeq()) {
						// push
						oranges.remove(0);
					}
				}
			}
			
			if (blue != null) {
				if (blue.getButtonPosition() > b) {
					b++;
				} else if(blue.getButtonPosition() < b) {
					b--;
				} else {	// orange.getButtonPosition() == b
					if (orange == null || orange.getSeq() > blue.getSeq()) {
						// push
						blues.remove(0);
					}
				}
			}
			
			if(oranges.size() == 0 && blues.size() == 0) {
				return sec;
			}
		}
	}
}

class Command {
	private int seq;
	private int buttonPosition;
	
	public Command(int seq, int buttonPosition) {
		this.seq = seq;
		this.buttonPosition = buttonPosition;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getButtonPosition() {
		return buttonPosition;
	}

	public void setButtonPosition(int buttonPosition) {
		this.buttonPosition = buttonPosition;
	}
}
