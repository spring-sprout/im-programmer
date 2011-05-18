package candy.splitting;

import java.util.List;


public class Patrick {
	
	private NumberUtils numberUtils;
	
	public Patrick() {
		numberUtils = new NumberUtils();
	}
	
	protected String add(List<Integer> decimals) {
		List<String> binaries = numberUtils.toBinaries(decimals);
		int numberOfDigits = numberUtils.maxNumberOfDigits(binaries);
		
		StringBuffer result = new StringBuffer();
		for (int i=0; i < numberOfDigits; i++) {
			int xor = 0;
			for(String binary : binaries) {
				int numberOfZeros = numberOfDigits - binary.length();
				StringBuffer sb = new StringBuffer();
				for(int j=0; j<numberOfZeros; j++) {
					sb.append("0");
				}
				String number = sb.append(binary).toString();
				
				xor = xor ^ Integer.parseInt(String.format("%c", number.charAt(i)));
			}
			result.append(xor);
		}
		int firstIndex = result.indexOf("1");
		if (firstIndex > 0) {
			return result.substring(firstIndex, result.length());
		} else {
			return result.toString();
		}
	}
}
