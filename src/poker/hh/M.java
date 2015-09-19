package poker.hh;

public class M {
	
	public static String toS(int cents) {
		if (cents%100==0) return Integer.toString(cents/100);
		else if (cents%100<10) return Integer.toString(cents/100) + ".0" + Integer.toString(cents%100);
		else return Integer.toString(cents/100) + "." + Integer.toString(cents%100);
	}
}
