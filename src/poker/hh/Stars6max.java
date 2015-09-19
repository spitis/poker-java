package poker.hh;

import java.util.ArrayList;

import poker.Card;
import poker.Hand;

public final class Stars6max extends HandHistory {
	
	long gameId; //Stars game id
	Player[] p = new Player[7]; //create an array for up to 6 new player objects. Object at 0 is null.
	ArrayList<PA> pfActions = new ArrayList<PA>();
	ArrayList<PA> flopActions = new ArrayList<PA>();
	ArrayList<PA> turnActions = new ArrayList<PA>();
	ArrayList<PA> riverActions = new ArrayList<PA>();
	
	public static void main(String[] args) {
		Stars6max h = new Stars6max();
		h.tableName = "Ostanina";
		h.blindLevel = 5000;
		h.buLocation = 4;
		h.sbLocation = 5;
		h.bbLocation = 6;
		h.gameId = 42546821745L;
		h.go();
		
	}
	
	public void go() {
		p[1] = new Player("Matate", 42500, new Hand("As 7s"));
		p[2] = new Player("Philbeer", 137300, new Hand("Th 9h"));
		p[3] = new Player("TheDarkJoker", 105000, new Hand("6c Qc"));
		p[4] = new Player("Sujumbike", 92500, new Hand());
		p[5] = new Player("menmar09", 240000, new Hand("Ac Tc"));
		p[6] = new Player("calvin7v", 231900, new Hand());
		
		pfActions.add(new PA(1,PA.RAISE,5000));
		pfActions.add(new PA(2,PA.CALL,10000));
		pfActions.add(new PA(3,PA.FOLD,0));
		pfActions.add(new PA(4,PA.FOLD,0));
		pfActions.add(new PA(5,PA.CALL,7500));
		pfActions.add(new PA(6,PA.CALL,5000));
		
		flopActions.add(new PA(5,PA.CHECK,0));
		flopActions.add(new PA(6,PA.CHECK,0));
		flopActions.add(new PA(1,PA.BET,32500,true));
		flopActions.add(new PA(2,PA.CALL,32500));
		flopActions.add(new PA(5,PA.RAISE,197500,true));
		flopActions.add(new PA(6,PA.FOLD,0));
		flopActions.add(new PA(2,PA.CALL,94800,true));
		
		flop = new Hand("3sTsAd");
		turn = new Card("3c");
		river = new Card("Ah");
		
		hero = 3;
		System.out.print(print());
	}
	
	
	public String print() {
		int pot = 0;
		int bet = 0;
		StringBuilder x = new StringBuilder();
		x.append("PokerStars Game #" + gameId +":  Hold'em No Limit ($" + M.toS(blindLevel/2) +"/" + M.toS(blindLevel) + " USD)\n");
		x.append("Table '" + tableName +"' 6-max Seat #" + buLocation + " is the button\n");
		//SEAT LOOP:
		for (int i=1;i<7;i++){
			if (p[i] != null) {
				x.append("Seat " + i +": " + p[i].name + " ($" + M.toS(p[i].stack) + " in chips)\n");
			}
		}
		
		x.append (p[sbLocation].name + ": posts small blind $" + M.toS(blindLevel/2) + "\n");
		x.append (p[bbLocation].name + ": posts big blind $" + M.toS(blindLevel) + "\n"); pot += (int) blindLevel*1.5;
		x.append ("*** HOLE CARDS ***\n");
		if (hero != 0) x.append("Dealt to " + p[hero].name + " [" + p[hero].holeCards.toString().trim() +"]\n");
		//PREFLOP ACTIONS LOOP:
			bet = blindLevel;
			for (int i = 0; i<pfActions.size();i++){
				x.append (p[pfActions.get(i).seatId].name + ": " + pfActions.get(i).getAction());
				switch (pfActions.get(i).action) {
				case 0: break; //folds
				case 1: break; //checks
				case 2: //calls
					x.append(" $" + M.toS(pfActions.get(i).cents)); 
					pot += pfActions.get(i).cents;
					if (pfActions.get(i).allIn) x.append(" and is all-in"); break; 
				case 3: //bets
					x.append(" $" + M.toS(pfActions.get(i).cents)); 
					pot += pfActions.get(i).cents;
					bet = pfActions.get(i).cents;
					if (pfActions.get(i).allIn) x.append(" and is all-in"); break;
				case 4: //raises
					x.append(" $" + M.toS(pfActions.get(i).cents));
					pot += pfActions.get(i).cents;
					bet += pfActions.get(i).cents;
					x.append(" to $" + M.toS(bet));
					if (pfActions.get(i).allIn) x.append(" and is all-in"); break;
				}
				x.append("\n");			 
			}
		x.append("*** FLOP *** [" + flop.toString() + "]\n");
		//FLOP ACTIONS LOOP:
		bet = 0;
		for (int i = 0; i<flopActions.size();i++){
			x.append (p[flopActions.get(i).seatId].name + ": " + flopActions.get(i).getAction());
			switch (flopActions.get(i).action) {
			case 0: break; //folds
			case 1: break; //checks
			case 2: //calls
				x.append(" $" + M.toS(flopActions.get(i).cents)); 
				pot += flopActions.get(i).cents;
				if (flopActions.get(i).allIn) x.append(" and is all-in"); break; 
			case 3: //bets
				x.append(" $" + M.toS(flopActions.get(i).cents)); 
				pot += flopActions.get(i).cents;
				bet = flopActions.get(i).cents;
				if (flopActions.get(i).allIn) x.append(" and is all-in"); break;
			case 4: //raises
				x.append(" $" + M.toS(flopActions.get(i).cents));
				pot += flopActions.get(i).cents;
				bet += flopActions.get(i).cents;
				x.append(" to $" + M.toS(bet));
				if (flopActions.get(i).allIn) x.append(" and is all-in"); break;
			}
			x.append("\n");			 
		}
		x.append("*** TURN *** [" + flop.toString() + "] [" + turn.toString() + "]\n");
		//TURN ACTIONS LOOP:
		bet = 0;
		for (int i = 0; i<turnActions.size();i++){
			x.append (p[turnActions.get(i).seatId].name + ": " + turnActions.get(i).getAction());
			switch (turnActions.get(i).action) {
			case 0: break; //folds
			case 1: break; //checks
			case 2: //calls
				x.append(" $" + M.toS(turnActions.get(i).cents)); 
				pot += turnActions.get(i).cents;
				if (turnActions.get(i).allIn) x.append(" and is all-in"); break; 
			case 3: //bets
				x.append(" $" + M.toS(turnActions.get(i).cents)); 
				pot += turnActions.get(i).cents;
				bet = turnActions.get(i).cents;
				if (turnActions.get(i).allIn) x.append(" and is all-in"); break;
			case 4: //raises
				x.append(" $" + M.toS(turnActions.get(i).cents));
				pot += turnActions.get(i).cents;
				bet += turnActions.get(i).cents;
				x.append(" to $" + M.toS(bet));
				if (turnActions.get(i).allIn) x.append(" and is all-in"); break;
			}
			x.append("\n");			 
		}
		x.append("*** RIVER *** [" + flop.toString() + " " + turn.toString() + "] [" + river.toString() + "]\n");
		//RIVER ACTIONS LOOP:
		bet = 0;
		for (int i = 0; i<riverActions.size();i++){
			x.append (p[riverActions.get(i).seatId].name + ": " + riverActions.get(i).getAction());
			switch (riverActions.get(i).action) {
			case 0: break; //folds
			case 1: break; //checks
			case 2: //calls
				x.append(" $" + M.toS(riverActions.get(i).cents)); 
				pot += riverActions.get(i).cents;
				if (riverActions.get(i).allIn) x.append(" and is all-in"); break; 
			case 3: //bets
				x.append(" $" + M.toS(riverActions.get(i).cents)); 
				pot += riverActions.get(i).cents;
				bet = riverActions.get(i).cents;
				if (riverActions.get(i).allIn) x.append(" and is all-in"); break;
			case 4: //raises
				x.append(" $" + M.toS(riverActions.get(i).cents));
				pot += riverActions.get(i).cents;
				bet += riverActions.get(i).cents;
				x.append(" to $" + M.toS(bet));
				if (riverActions.get(i).allIn) x.append(" and is all-in"); break;
			}
			x.append("\n");			 
		}
		x.append("*** SHOW DOWN *** \n");
		
		return x.toString();
	}
	
	
	
	
}
