package candy.splitting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sean {

	private Patrick patrick;

	public Sean() {
		patrick = new Patrick();
	}

	protected Integer keep(List<Integer> decimals) {
		
		if (patrick.add(decimals).contains("1")) {
			throw new RuntimeException();
		}
		
		Collections.sort(decimals);
		Integer keep = 0;
		
		List<Integer> sBag = null;
		List<Integer> pBag = null;
		
		sBag = new ArrayList<Integer>();
		pBag = new ArrayList<Integer>();
		
		List<Integer> pPile = new ArrayList<Integer>();
		while(decimals.size() > 0) {
			pPile.add(decimals.get(0));
			decimals.remove(decimals.get(0));
			String aPile = patrick.add(pPile);
			String sPile = patrick.add(decimals);
			
			if (aPile.equals(sPile)) {
				sBag.addAll(decimals);
				pBag.addAll(pPile);
				decimals.removeAll(decimals);
				decimals.removeAll(pPile);
			}
		}
		
		for(int i=0; i<sBag.size(); i++) {
			keep += sBag.get(i);
		}
		if (keep == 0) throw new RuntimeException();
		return keep;
	}
}
