package poker.hh;

import poker.Card;
import poker.Hand;

abstract class HandHistory {

	final static String gameType = "NLHE";
	String tableName;
	int buLocation; //location of button
	int sbLocation;
	int bbLocation;
	int blindLevel; //big blind size in CENTS
	int finalPot;
	int rake;
	Hand flop;
	Hand board;
	Card turn;
	Card river;
	int hero;
}
