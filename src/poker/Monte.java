package poker;

import org.uncommons.maths.random.*;

public class Monte {
	
	private static XORShiftRNG rng = new XORShiftRNG();
	
	public static int[] pfHandEquity(Hand a, Hand b, int trials){
		int w =0;
		int l =0;
		int t =0;
		
		for (int h = 0; h < trials; h++){
			Deck d = new Deck();
			d.removeCards(a);
			d.removeCards(b);
			d.shuffle(rng);
			Hand board = new Hand();

			for (int i = 0; i < 5; i++){
				board.addCard(d.nextcard());
			}
			
			Hand v = (Hand) b.clone();
			v.addhand(board);
			board.addhand(a);
			
			int x = board.evaluate();
			int y = v.evaluate();
			if (x>y) w ++; else if (x<y) l++; else t++;
		}
		
		int[] r = {w,l,t};
		return r;
	}

	public static int[] pfRangeEquity(Range a, Range b, int trials) {
		
		int w = 0;
		int l = 0;
		int t = 0;
		
		for (int h = 0; h < trials; h++) {

			Hand j = a.get(rng.nextInt(a.size()));
			Hand k = b.get(rng.nextInt(b.size()));	
			
			if (j.getcard(1) != k.getcard(1) && j.getcard(1) != k.getcard(0) && j.getcard(0) != k.getcard(1) && j.getcard(0) != k.getcard(0)) {
			int[] r = pfHandEquity(j,k,1);
			w += (int) r[0];
			l += (int) r[1];
			t += (int) r[2];
			}
						
		}
		
		int[] r = {w,l,t};
		return r;
			
	}
	
	public static double pfRangeEquity(Range a, Range b, int trials, boolean b1) {
		int[] val = Monte.pfRangeEquity(a,b, trials);
		return ((val[0]+(0.5*val[2]))/(val[0]+val[1]+val[2]));		
	}

}