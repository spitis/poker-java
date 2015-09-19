package poker.hh;

import poker.Hand;

public class Player {
	public Player(String cname, int cstack, Hand hcards) {
		name = cname;
		stack = cstack; //in CENTS
		holeCards = hcards;
	}
	public int stack;
	public String name;
	public Hand holeCards;
}
