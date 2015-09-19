package poker.hh;

public class PA { //PA => Player Action

	static final int FOLD = 0;
	static final int CHECK = 1;
	static final int CALL = 2;
	static final int BET = 3;
	static final int RAISE = 4;
	static final int SHOW = 5;
	static final int COLLECTSIDE = 6;
	static final int COLLECTMAIN = 7;
	static final int MUCK = 8;
	
	int seatId;
	int action;
	int cents;
	boolean allIn = false;
	
	public PA(int cseat, int caction, int c) {
		seatId = cseat;
		action = caction;
		cents = c;
	}
	
	public PA(int cseat, int caction, int c, boolean ai) {
		this(cseat,caction,c);
		allIn = ai;
	}
	
	public String getAction() {
		switch (action) {
		case 0: return "folds";
		case 1: return "checks";
		case 2: return "calls";
		case 3: return "bets";
		case 4: return "raises";
		}
		return "";
	}
	
}
