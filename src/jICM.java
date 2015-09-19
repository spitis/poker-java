import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import poker.Monte;
import poker.Range;

public class jICM {

	/**
	 * @param args
	 */
	
	public static double[] prizes = {6.5, 3.5};
	
	public static void main(String[] args) throws Exception {
		
		PrintWriter out = new PrintWriter(new File("nashOut.tmp"));
		out.print("52;42");
		
		out.close();
	
		
		if (args[3].matches("SB")) {

			//nash3SB(args);
			
		}
		

	}
	
	public static void nash3SB (String[] args) {
		//NOT FINISHED; DOES NOT WORK
		Range SB, BB, SB1, BB1;
		double sbRange = 10.0;
		double bbRange = 10.0; 
		int sbr, bbr, sbr1, bbr1 = 0;
		
		int[] oWin = {Integer.parseInt(args[1])+Math.min(Integer.parseInt(args[1]), Integer.parseInt(args[2])),Integer.parseInt(args[2]) - Math.min(Integer.parseInt(args[1]), Integer.parseInt(args[2])),Integer.parseInt(args[0])};
		int[] oLose = {Integer.parseInt(args[1])-Math.min(Integer.parseInt(args[1]), Integer.parseInt(args[2])),Integer.parseInt(args[2]) +Math.min(Integer.parseInt(args[1]), Integer.parseInt(args[2])),Integer.parseInt(args[0])};
		
		double winEVsb = heroICM(oWin[0],oWin[1],oWin[2]);
		double loseEVsb = heroICM(oLose[0],oLose[1],oLose[2]);
		double winEVbb = heroICM(oLose[1],oLose[0],oLose[2]);
		double loseEVbb = heroICM(oWin[1],oWin[0],oWin[2]);
		
		for (int x = 0; x < 100; x++){
			SB = new Range();
			SB1 = new Range();
			BB = new Range();
			BB1 = new Range();

			sbr = (int) sbRange;
			bbr = (int) bbRange;
			sbr1 = sbr + 1;
			bbr1 = bbr + 1;
			
			SB.add("RP" + sbr);
			SB1.add("RP"+sbr1);
			
			BB.add("RC" + bbr);
			BB1.add("RC" + bbr1);
	
			
			double a = heroEV(SB,BB,winEVsb,loseEVsb,5000);
			double b = heroEV(SB1,BB,winEVsb,loseEVsb,5000);
			System.out.print("heroEV1: " + a + " heroEV2 " + b);
			if(a>b+0.03) {
				sbRange -= Math.random()/10;
			} else if (a<b-0.03){
				sbRange += Math.random()/10;
			}
			
			a = heroEV(BB,SB,winEVbb,loseEVbb,5000);
			b = heroEV(BB1,SB,winEVbb,loseEVbb,5000);
			if(a>b+0.03) {
				bbRange -= Math.random()/10;
			} else if (a<b-0.03){
				bbRange += Math.random()/10;
			}
			
			System.out.println("  " + sbr + "  " + bbr);
			
		}
		
		
	}
	
	public static double heroEV (Range heroR, Range villainR, double oWin, double oLose, int trials) {
		double ev;
		double pWin = Monte.pfRangeEquity(heroR, villainR, trials, true);
		ev = pWin*oWin + (1-pWin)*oLose;
		return ev;
	}
	
	
	public static double heroICM (int heroStack, int v1, int v2) {
		double ev = 0;
		double sumChips = heroStack + v1 + v2;
		double prob1st = heroStack/sumChips;
		double prob2nd = v1/sumChips * heroStack / (sumChips-v1) + v2/sumChips * heroStack / (sumChips-v2);
		
		ev = prizes[0]*prob1st + prizes[1]*prob2nd;
		return ev;
	}
	
	public static double heroICM (int heroStack, int v1, int v2, int v3) {
		double ev = 0;
		return ev;
	
	}

	
}
