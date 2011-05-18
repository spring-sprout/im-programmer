package candy.splitting;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {
	protected int maxNumberOfDigits(List<String> binaries) {
		int numberOfDigits = 0;
		for(String binary : binaries) {
			int strBinaryLength = binary.length();
			if ( strBinaryLength > numberOfDigits) numberOfDigits = strBinaryLength;
		}
		return numberOfDigits;
	}
	
	protected List<String> toBinaries(List<Integer> decimals) {
		List<String> binaries = new ArrayList<String>();
		for(int i=0; i< decimals.size(); i++) {
			binaries.add(Integer.toBinaryString(decimals.get(i)));
		}
		return binaries;
	}
}
