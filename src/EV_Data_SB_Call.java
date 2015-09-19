import java.text.DecimalFormat;
import java.text.NumberFormat;

import poker.Monte;
import poker.Range;


public class EV_Data_SB_Call{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		EV_Data_SB_Call.printBvB();
		
	}

	private static void printBvB() {
		for (int or = 40; or <99; or+=5) {
		
		System.out.println("Opening Range: " + or +"%");
		System.out.print ("SR:  ");
		
		for (int sr = 11; sr<36; sr+=2) {
			System.out.print(sr + "%   ");
					
		}
		System.out.println("");
		for (int cr = 11; cr<26; cr+=2) {
			System.out.print(cr + "%  ");
			for (int sr = 11; sr < 36; sr+=2){
				Range ror = new Range();
				ror.add("RP" + Integer.toString(or));
				Range rsr = new Range();
				rsr.add("RP" + Integer.toString(sr));
				Range rcr = new Range();
				rcr.add("RC" + Integer.toString(cr));
				System.out.print(evRaiserSBCall(ror, rcr, rsr, 100000) + "    ");
				
				
			}
			System.out.println("");	
		}
		System.out.println("");	
		System.out.println("");	
		}
		
		
	}
	
	private static String evRaiserSB(Range open, Range call, Range shove, int trials) {
		
		double rPercent = open.size()/1326.0;
		double fe = (1326 - shove.size())/1326.0;
		double fes = 1.0*call.size()/open.size();
		double ev = (rPercent)*((fe)*(1.5) + (1-fe)*( (fes)*((Monte.pfRangeEquity(call,shove,trials,true))*2*20-(20-0.5)) - (1-fes)*(2-0.5) ));
		int iev = (int) roundTwoDecimals(ev);
		return Integer.toString(iev);
	}
	
private static String evRaiserSBCall(Range open, Range SBcall, Range shove, int trials) {
		Range BBcall = shove; //the BB calls and shoves in a 50/50 ratio
		double rPercent = open.size()/1326.0;
		double fe = (1326 - 2*shove.size())/1326.0;
		double fes = 1.0*SBcall.size()/open.size();
		double ev = (rPercent)*(      (fe)*(1.5)     +     0.5*(1-fe)*( (fes)*((Monte.pfRangeEquity(SBcall,shove,trials,true))*2*20-(20-0.5)) - (1-fes)*(2-0.5) )  + 0.5*(1-fe)*((Monte.pfRangeEquity(open,shove,trials,true))*4 - 1.5)  ) ;
		int iev = (int) roundTwoDecimals(ev);
		return Integer.toString(iev);
	}
	
	private static String evRaiserBB(Range open, Range call, Range shoveSB, Range shoveBB, int trials) {
		
		double rPercent = open.size()/1326.0;
		double fe = (1326 - shoveSB.size())/1326.0;
		double fes = 1.0*call.size()/open.size();
		double ev = (rPercent)*((fe)*(1.5) + (1-fe)*( (fes)*((Monte.pfRangeEquity(call,shoveSB,trials,true))*2*20-(20-0.5)) - (1-fes)*(2-0.5) ));
		int iev = (int) roundTwoDecimals(ev);
		return Integer.toString(iev);
	}
	
	private static double roundTwoDecimals(double d) {
	return Math.round(d*100);
	}
	
}
